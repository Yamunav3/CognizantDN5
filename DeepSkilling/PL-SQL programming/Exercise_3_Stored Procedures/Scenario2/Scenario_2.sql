

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id   IN employees.department_id%TYPE,
    p_bonus_percent    IN NUMBER
)
IS
    v_employees_updated NUMBER := 0;
BEGIN
    IF p_bonus_percent < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Bonus percentage cannot be negative.');
    END IF;

    UPDATE employees
    SET    salary = salary * (1 + p_bonus_percent / 100)
    WHERE  department_id = p_department_id;

    v_employees_updated := SQL%ROWCOUNT;

    IF v_employees_updated = 0 THEN
        DBMS_OUTPUT.PUT_LINE(
            'No employees found in department ' || p_department_id || '.'
        );
    ELSE
        DBMS_OUTPUT.PUT_LINE(
            'Applied ' || p_bonus_percent || '% bonus to ' ||
            v_employees_updated || ' employee(s) in department ' ||
            p_department_id || '.'
        );
    END IF;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonus: ' || SQLERRM);
        RAISE;
END UpdateEmployeeBonus;
/


SET SERVEROUTPUT ON;
BEGIN
    UpdateEmployeeBonus(p_department_id => 10, p_bonus_percent => 5);
END;
/

SELECT * FROM employees;