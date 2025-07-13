scenario:1 
SELECT CalculateAge(TO_DATE('1990-06-15', 'YYYY-MM-DD')) AS age FROM dual;
AGE
---
35

scenario2
SELECT CalculateMonthlyInstallment(100000, 12, 5) AS monthly_emi FROM dual;
MONTHLY_EMI
-----------
2224.44

scenario3
Sufficient Balance
