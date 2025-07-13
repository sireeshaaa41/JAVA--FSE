Scenario 1: CustomerManagement Package
package body
CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddCustomer(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    );

    PROCEDURE UpdateCustomerDetails(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE
    );

    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;

package specifications:
CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddCustomer(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    );

    PROCEDURE UpdateCustomerDetails(
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE
    );

    FUNCTION GetCustomerBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;



Scenario 2: EmployeeManagement Package
package specificiations:
CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(
        p_emp_id IN NUMBER,
        p_name IN VARCHAR2,
        p_position IN VARCHAR2,
        p_salary IN NUMBER,
        p_department IN VARCHAR2,
        p_hire_date IN DATE
    );

    PROCEDURE UpdateEmployeeDetails(
        p_emp_id IN NUMBER,
        p_position IN VARCHAR2,
        p_salary IN NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_emp_id IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;

package body:
CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS

    PROCEDURE HireEmployee(p_emp_id IN NUMBER, p_name IN VARCHAR2, p_position IN VARCHAR2, p_salary IN NUMBER, p_department IN VARCHAR2, p_hire_date IN DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_emp_id, p_name, p_position, p_salary, p_department, p_hire_date);
    END;

    PROCEDURE UpdateEmployeeDetails(p_emp_id IN NUMBER, p_position IN VARCHAR2, p_salary IN NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Position = p_position,
            Salary = p_salary
        WHERE EmployeeID = p_emp_id;
    END;

    FUNCTION CalculateAnnualSalary(p_emp_id IN NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_emp_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;

END EmployeeManagement;


Scenario 3: AccountOperations Package
package specifications:
CREATE OR REPLACE PACKAGE AccountOperations IS
    PROCEDURE OpenAccount(
        p_account_id IN NUMBER,
        p_customer_id IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance IN NUMBER
    );

    PROCEDURE CloseAccount(
        p_account_id IN NUMBER
    );

    FUNCTION GetTotalCustomerBalance(
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;

package body:
CREATE OR REPLACE PACKAGE BODY AccountOperations IS

    PROCEDURE OpenAccount(p_account_id IN NUMBER, p_customer_id IN NUMBER, p_account_type IN VARCHAR2, p_balance IN NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);
    END;

    PROCEDURE CloseAccount(p_account_id IN NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_account_id;
    END;

    FUNCTION GetTotalCustomerBalance(p_customer_id IN NUMBER) RETURN NUMBER IS
        v_total_balance NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;
        RETURN v_total_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END;

END AccountOperations;
