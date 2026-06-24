
-- ============================================================
-- Exercise 3, Scenario 1: ProcessMonthlyInterest
-- ============================================================
-- Applies 1% monthly interest to every savings account's
-- current balance.
--
-- Assumed table: SavingsAccounts(account_id, customer_id, balance)
-- ============================================================
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    v_interest_rate       CONSTANT NUMBER := 0.01;   -- 1% monthly interest
    v_accounts_processed  NUMBER := 0;
BEGIN
    UPDATE savings_accounts
    SET    balance = balance * (1 + v_interest_rate);

    v_accounts_processed := SQL%ROWCOUNT;

    DBMS_OUTPUT.PUT_LINE(
        'Monthly interest applied to ' || v_accounts_processed ||
        ' savings account(s) at ' || (v_interest_rate * 100) || '%.'
    );

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
        RAISE;
END ProcessMonthlyInterest;
/

SET SERVEROUTPUT ON;
BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM savings_accounts;