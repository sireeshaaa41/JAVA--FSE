Scenario 1: CalculateAge
CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob IN DATE
) RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;


Scenario 2: CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_amount IN NUMBER,
    p_annual_rate IN NUMBER,
    p_years IN NUMBER
) RETURN NUMBER
IS
    r NUMBER; -- monthly interest rate
    n NUMBER; -- number of months
    emi NUMBER;
BEGIN
    r := p_annual_rate / (12 * 100); -- Convert annual % to monthly decimal
    n := p_years * 12;

    IF r = 0 THEN
        emi := p_amount / n; -- No interest case
    ELSE
        emi := p_amount * r * POWER(1 + r, n) / (POWER(1 + r, n) - 1);
    END IF;

    RETURN ROUND(emi, 2);
END;


Scenario 3: HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance FROM accounts WHERE account_id = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        RETURN FALSE;
END;
