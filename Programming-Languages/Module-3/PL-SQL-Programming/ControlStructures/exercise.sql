SET SERVEROUTPUT ON;

BEGIN

    FOR customer IN (
        SELECT CustomerID, DOB
        FROM Customers
    )
    LOOP

        IF MONTHS_BETWEEN(SYSDATE, customer.DOB) / 12 > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated for customers over 60 years old.');

END;
/

BEGIN
    FOR customer IN (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP

        IF customer.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated for customers with balance over 10,000.');

END;
/

BEGIN
    FOR loan IN (
        SELECT LoanID,
               EndDate
        FROM Loans
    )
    LOOP

        IF loan.EndDate <= SYSDATE + 30 THEN

            DBMS_OUTPUT.PUT_LINE(
                'Reminder: Loan '
                || loan.LoanID
                || ' is due within 30 days.'
            );

        END IF;

    END LOOP;

END;
/