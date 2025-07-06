Sample Data:
-- accounts table
| account_id | balance |
|------------|---------|
| 1001       | 5000    |
| 1002       | 3000    |
output:
Funds transferred successfully.
| account\_id | balance |
| ----------- | ------- |
| 1001        | 4000    |
| 1002        | 4000    |


senario 2:
output
Error: Insufficient funds in account 1001
| account\_id | balance |
| ----------- | ------- |
| 1001        | 5000    |
| 1002        | 3000    |


senario3
output
Customer added successfully. ID: 3002
| customer\_id | name   | age |
| ------------ | ------ | --- |
| 3001         | Ramesh | 45  |
| 3002         | Sita   | 30  |
