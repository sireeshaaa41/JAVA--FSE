Scenario 1: UpdateCustomerLastModified
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;



Scenario 2: LogTransaction
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
    INSERT INTO auditlog (transaction_id, action_type, action_date)
    VALUES (:NEW.transaction_id, 'INSERT', SYSDATE);
END;

Scenario 3: CheckTransactionRules
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    -- Get current balance
    SELECT balance INTO v_balance FROM accounts WHERE account_id = :NEW.account_id;

    IF :NEW.type = 'withdrawal' AND :NEW.amount > v_balance THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal.');
    ELSIF :NEW.type = 'deposit' AND :NEW.amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;
END;
