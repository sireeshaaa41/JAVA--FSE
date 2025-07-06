Scenario 1: GenerateMonthlyStatements
DECLARE
    CURSOR txn_cursor IS
        SELECT customer_id, transaction_id, amount, type, txn_date
        FROM transactions
        WHERE TO_CHAR(txn_date, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY')
        ORDER BY customer_id;

    v_customer_id transactions.customer_id%TYPE;
    v_transaction_id transactions.transaction_id%TYPE;
    v_amount transactions.amount%TYPE;
    v_type transactions.type%TYPE;
    v_txn_date transactions.txn_date%TYPE;
BEGIN
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO v_customer_id, v_transaction_id, v_amount, v_type, v_txn_date;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || 
                             ' | Txn ID: ' || v_transaction_id || 
                             ' | Type: ' || v_type || 
                             ' | Amount: ' || v_amount || 
                             ' | Date: ' || TO_CHAR(v_txn_date, 'DD-MON-YYYY'));
    END LOOP;
    CLOSE txn_cursor;
END;


DECLARE
    CURSOR txn_cursor IS
        SELECT customer_id, transaction_id, amount, type, txn_date
        FROM transactions
        WHERE TO_CHAR(txn_date, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY')
        ORDER BY customer_id;

    v_customer_id transactions.customer_id%TYPE;
    v_transaction_id transactions.transaction_id%TYPE;
    v_amount transactions.amount%TYPE;
    v_type transactions.type%TYPE;
    v_txn_date transactions.txn_date%TYPE;
BEGIN
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO v_customer_id, v_transaction_id, v_amount, v_type, v_txn_date;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || 
                             ' | Txn ID: ' || v_transaction_id || 
                             ' | Type: ' || v_type || 
                             ' | Amount: ' || v_amount || 
                             ' | Date: ' || TO_CHAR(v_txn_date, 'DD-MON-YYYY'));
    END LOOP;
    CLOSE txn_cursor;
END;


DECLARE
    CURSOR txn_cursor IS
        SELECT customer_id, transaction_id, amount, type, txn_date
        FROM transactions
        WHERE TO_CHAR(txn_date, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY')
        ORDER BY customer_id;

    v_customer_id transactions.customer_id%TYPE;
    v_transaction_id transactions.transaction_id%TYPE;
    v_amount transactions.amount%TYPE;
    v_type transactions.type%TYPE;
    v_txn_date transactions.txn_date%TYPE;
BEGIN
    OPEN txn_cursor;
    LOOP
        FETCH txn_cursor INTO v_customer_id, v_transaction_id, v_amount, v_type, v_txn_date;
        EXIT WHEN txn_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id || 
                             ' | Txn ID: ' || v_transaction_id || 
                             ' | Type: ' || v_type || 
                             ' | Amount: ' || v_amount || 
                             ' | Date: ' || TO_CHAR(v_txn_date, 'DD-MON-YYYY'));
    END LOOP;
    CLOSE txn_cursor;
END;

Scenario 2: ApplyAnnualFee
DECLARE
    CURSOR account_cursor IS
        SELECT account_id, balance FROM accounts;

    v_account_id accounts.account_id%TYPE;
    v_balance accounts.balance%TYPE;
BEGIN
    OPEN account_cursor;
    LOOP
        FETCH account_cursor INTO v_account_id, v_balance;
        EXIT WHEN account_cursor%NOTFOUND;

        UPDATE accounts
        SET balance = balance - 500
        WHERE account_id = v_account_id;

        DBMS_OUTPUT.PUT_LINE('Annual fee applied to Account ID: ' || v_account_id);
    END LOOP;
    CLOSE account_cursor;

    COMMIT;
END;


Scenario 3: UpdateLoanInterestRates
DECLARE
    CURSOR loan_cursor IS
        SELECT loan_id, loan_amount FROM loans;

    v_loan_id loans.loan_id%TYPE;
    v_loan_amount loans.loan_amount%TYPE;
    v_new_rate NUMBER;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_loan_amount;
        EXIT WHEN loan_cursor%NOTFOUND;

        -- Determine new rate
        IF v_loan_amount < 100000 THEN
            v_new_rate := 5;
        ELSIF v_loan_amount BETWEEN 100000 AND 500000 THEN
            v_new_rate := 6.5;
        ELSE
            v_new_rate := 8;
        END IF;

        -- Update interest rate
        UPDATE loans
        SET interest_rate = v_new_rate
        WHERE loan_id = v_loan_id;

        DBMS_OUTPUT.PUT_LINE('Updated Loan ID ' || v_loan_id || ' to interest rate ' || v_new_rate || '%');
    END LOOP;
    CLOSE loan_cursor;

    COMMIT;
END;
