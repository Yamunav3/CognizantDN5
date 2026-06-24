

-- ============================================================
-- Exercise 1, Scenario 3: Loan Due Reminders (next 30 days)
-- ============================================================
-- Fetches all loans due within the next 30 days and prints a
-- reminder message for each customer.
--
-- Matches actual table structures:
--   customers(customer_id, customer_name, age, balance, is_vip)
--   loans(loan_id, customer_id, loan_amount, interest_rate, due_date)
-- ============================================================
DECLARE
    CURSOR due_loans_cursor IS
        SELECT l.loan_id,
               l.customer_id,
               c.customer_name   AS customer_name,
               l.due_date,
               l.interest_rate
        FROM   loans l
        JOIN   customers c ON c.customer_id = l.customer_id
        WHERE  l.due_date BETWEEN SYSDATE AND (SYSDATE + 30)
        ORDER  BY l.due_date;

    v_reminder_count NUMBER := 0;
BEGIN
    FOR loan_rec IN due_loans_cursor LOOP
        v_reminder_count := v_reminder_count + 1;

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || loan_rec.customer_name ||
            ' (ID: ' || loan_rec.customer_id || ') has Loan #' ||
            loan_rec.loan_id || ' due on ' ||
            TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY') ||
            '. Current interest rate: ' || loan_rec.interest_rate || '%.'
        );
    END LOOP;

    IF v_reminder_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due in the next 30 days.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Total reminders sent: ' || v_reminder_count);
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error fetching due loans: ' || SQLERRM);
END;
/