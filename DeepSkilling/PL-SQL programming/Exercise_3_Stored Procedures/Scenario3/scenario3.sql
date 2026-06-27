
-- ============================================================
-- Exercise 3, Scenario 3: TransferFunds
-- ============================================================
-- Transfers a specified amount from one account to another,
-- checking that the source account has sufficient balance
-- before making the transfer.
-- Assumed table: Accounts(account_id, balance)

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id  IN Accounts.account_id%TYPE,
    p_to_account_id    IN Accounts.account_id%TYPE,
    p_amount           IN NUMBER
)
IS
    v_from_balance   Accounts.balance%TYPE;
    insufficient_funds  EXCEPTION;
    account_not_found   EXCEPTION;

BEGIN
    -- Basic input validation
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transfer amount must be greater than zero.');
    END IF;

    IF p_from_account_id = p_to_account_id THEN
        RAISE_APPLICATION_ERROR(-20003, 'Source and destination accounts must differ.');
    END IF;

    -- Lock the source row to prevent race conditions during concurrent transfers
    SELECT balance
    INTO   v_from_balance
    FROM   Accounts
    WHERE  account_id = p_from_account_id
    FOR UPDATE;

    IF v_from_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Debit source account
    UPDATE Accounts
    SET    balance = balance - p_amount
    WHERE  account_id = p_from_account_id;

    -- Credit destination account
    UPDATE Accounts
    SET    balance = balance + p_amount
    WHERE  account_id = p_to_account_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE account_not_found;
    END IF;

    DBMS_OUTPUT.PUT_LINE(
        'Transferred $' || p_amount || ' from account ' ||
        p_from_account_id || ' to account ' || p_to_account_id || '.'
    );

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Source account ' || p_from_account_id || ' not found.');
        RAISE_APPLICATION_ERROR(-20004, 'Source account not found.');

    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(
            'Error: Insufficient balance in account ' || p_from_account_id ||
            ' (available: $' || v_from_balance || ', requested: $' || p_amount || ').'
        );
        RAISE_APPLICATION_ERROR(-20005, 'Insufficient funds for transfer.');

    WHEN account_not_found THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Destination account ' || p_to_account_id || ' not found.');
        RAISE_APPLICATION_ERROR(-20006, 'Destination account not found.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
        RAISE;
END TransferFunds;
/


SET SERVEROUTPUT ON;
BEGIN
    TransferFunds(p_from_account_id => 401, p_to_account_id => 402, p_amount => 500);
END;
/



SELECT * FROM accounts;