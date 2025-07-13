Scenario 1: CustomerManagement Package
Execution 1:
EXEC CustomerManagement.AddCustomer(3, 'Shireesha', TO_DATE('1998-02-15', 'YYYY-MM-DD'), 2000);
Output:
1 row inserted into Customers

Scenario 2: EmployeeManagement Package
 Execution 1:
EXEC EmployeeManagement.HireEmployee(3, 'Naveen Kumar', 'Analyst', 50000, 'Finance', SYSDATE);
Output:
1 row inserted into Employees


Scenario 3: AccountOperations Package
Execution 1:

EXEC AccountOperations.OpenAccount(3, 3, 'Savings', 2500);
 Output:
1 row inserted into Accounts
