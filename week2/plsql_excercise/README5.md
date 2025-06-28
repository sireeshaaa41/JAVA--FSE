Scenario 1: UpdateCustomerLastModified
| customer\_id | name    | age | LastModified        |
| ------------ | ------- | --- | ------------------- |
| 101          | Alice B | 62  | 2025-06-28 21:15:00 |


Scenario 2: LogTransaction
| audit\_id | transaction\_id | action\_type | action\_date        |
| --------- | --------------- | ------------ | ------------------- |
| 1         | 1001            | INSERT       | 2025-06-28 21:15:00 |


Scenario 3: CheckTransactionRules
INSERT INTO transactions (transaction_id, account_id, amount, type)
VALUES (1005, 301, 1500, 'withdrawal');
Output:
Transaction successful (trigger allows insert).
