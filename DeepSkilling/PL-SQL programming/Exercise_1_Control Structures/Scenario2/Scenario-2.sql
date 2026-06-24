


-- ============================================================
-- Exercise 1, Scenario 2: VIP Status Promotion
-- ============================================================
-- Iterates through all customers; sets is_vip = 'TRUE'/'FALSE'
-- based on balance > $10,000.
--
-- Matches actual table structure:
--   customers(customer_id, customer_name, age, balance, is_vip)
--   is_vip is VARCHAR2(5), storing 'TRUE' or 'FALSE'
-- ============================================================
DECLARE
    CURSOR cust_cursor IS
        SELECT customer_id, balance
        FROM   customers;

    v_customer_id    customers.customer_id%TYPE;
    v_balance        customers.balance%TYPE;
    v_promoted_count NUMBER := 0;
BEGIN
    FOR cust_rec IN cust_cursor LOOP
        v_customer_id := cust_rec.customer_id;
        v_balance     := cust_rec.balance;

        IF v_balance > 10000 THEN
            UPDATE customers
            SET    is_vip = 'TRUE'
            WHERE  customer_id = v_customer_id;

            v_promoted_count := v_promoted_count + 1;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ' || v_customer_id ||
                ' promoted to VIP (balance: $' || v_balance || ')'
            );
        ELSE
            -- Ensure non-qualifying customers are NOT marked VIP
            UPDATE customers
            SET    is_vip = 'FALSE'
            WHERE  customer_id = v_customer_id
            AND    is_vip != 'FALSE';
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Total customers promoted to VIP: ' || v_promoted_count);
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating VIP status: ' || SQLERRM);
END;
/