CREATE TABLE DEPARTMENTS (
    department_id NUMBER(7) NOT NULL PRIMARY KEY,
    department_name VARCHAR(100),
    manager_id NUMBER(7),
    location_id NUMBER(7)
);

CREATE TABLE EMPLOYEES (
    employee_id NUMBER(7) NOT NULL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100),
    phone_number NUMBER(10),
    hire_date DATE,
    job_id NUMBER(7),
    salary NUMBER(7,2),
    commision_pct NUMBER(7,2),
    manager_id NUMBER(7),
    department_id NUMBER(7),

    FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(department_id)
);
CREATE TABLE JOBS (
    job_id NUMBER(7) NOT NULL PRIMARY KEY,
    job_title VARCHAR(100),
    min_salary NUMBER(7,2),
    max_salary  NUMBER(7,2)
);

INSERT INTO JOBS VALUES (1, 'GEN_MUD', 20000, 50000);
INSERT INTO JOBS VALUES (2, 'DEPO_SOR', 20000, 50000);
INSERT INTO JOBS VALUES (3, 'BIL_PROG', 20000, 50000);
INSERT INTO JOBS VALUES (4, 'SATIS_TEMS', 20000, 50000);
INSERT INTO JOBS VALUES (5, 'DEPO_MEM', 20000, 50000);

INSERT INTO DEPARTMENTS VALUES (1, 'SALES', 1, 1);
INSERT INTO DEPARTMENTS VALUES (2, 'HR', 2, 1);
INSERT INTO DEPARTMENTS VALUES (3, 'SOFTWARE DEVELOPMENT', 3, 1);
INSERT INTO DEPARTMENTS VALUES (4, 'MANAGEMENT', 4, 1);

INSERT INTO EMPLOYEES VALUES
(1, 'Ahmet', 'Yılmaz', 'ahmet.yilmaz@example.com', 5464567890, TO_DATE('2022-01-15', 'YYYY-MM-DD'), 101, 50000.00, 5.00, 10, 1);
INSERT INTO EMPLOYEES VALUES
(2, 'Ayşe', 'Kaya', 'ayse.kaya@example.com', 5465678901, TO_DATE('2022-02-16', 'YYYY-MM-DD'), 102, 55000.00, 6.00, 11, 2);
INSERT INTO EMPLOYEES VALUES
(3, 'Mehmet', 'Demir', 'mehmet.demir@example.com', 5466789012, TO_DATE('2022-03-17', 'YYYY-MM-DD'), 103, 60000.00, 7.00, 12, 3);
INSERT INTO EMPLOYEES VALUES
(4, 'Elif', 'Şahin', 'elif.sahin@example.com', 4567890123, TO_DATE('2022-04-18', 'YYYY-MM-DD'), 104, 65000.00, 8.00, 13, 1);
INSERT INTO EMPLOYEES VALUES
(5, 'Emre', 'Çelik', 'emre.celik@example.com', 4568901234, TO_DATE('2022-05-19', 'YYYY-MM-DD'), 105, 70000.00, 9.00, 14, 2);
INSERT INTO EMPLOYEES VALUES
(6, 'Fatma', 'Yıldız', 'fatma.yildiz@example.com', 6789012345, TO_DATE('2022-06-20', 'YYYY-MM-DD'), 106, 75000.00, 10.00, 15, 3);
INSERT INTO EMPLOYEES VALUES
(7, 'Mert', 'Kara', 'mert.kara@example.com', 7890123456, TO_DATE('2022-07-21', 'YYYY-MM-DD'), 107, 80000.00, 11.00, 16, 1);
INSERT INTO EMPLOYEES VALUES
(8, 'Zeynep', 'Aslan', 'zeynep.aslan@example.com', 7891234567, TO_DATE('2022-08-22', 'YYYY-MM-DD'), 108, 85000.00, 12.00, 17, 2);
INSERT INTO EMPLOYEES VALUES
(9, 'Ali', 'Turan', 'ali.turan@example.com', 9012345678, TO_DATE('2022-09-23', 'YYYY-MM-DD'), 109, 90000.00, 13.00, 18, 3);
INSERT INTO EMPLOYEES VALUES
(10, 'Ceren', 'Koç', 'ceren.koc@example.com', 1234567809, TO_DATE('2022-10-24', 'YYYY-MM-DD'), 110, 95000.00, 14.00, 19, 1);


SELECT employee_id, first_name, department_name
FROM employees
JOIN DEPARTMENTS ON employees.department_id = DEPARTMENTS.department_id;

SELECT employee_id, manager_id FROM employees;


SELECT operator , COUNT(operator)
FROM (SELECT SUBSTR(phone_number,1,3) AS operator FROM employees)
GROUP BY operator;


CREATE TABLE emp AS SELECT * FROM employees WHERE employee_id = null;

INSERT INTO emp VALUES
(1, 'Mustafa Yasin', 'Emir', 'test@i2i.com', 6235767209, TO_DATE('2022-10-24', 'YYYY-MM-DD'), 1, 950, 1, 1, 1);
SELECT  * FROM emp;

UPDATE emp SET phone_number=1234567890 , salary=100 WHERE employee_id=1;
SELECT * FROM emp;

DELETE FROM emp where employee_id=1;

DROP TABLE emp;

SELECT
SUBSTR(first_name, 1, 2) || LPAD('*', LENGTH(first_name) - 2, '*') || ' ' ||
SUBSTR(last_name, 1, 2) || LPAD('*', LENGTH(first_name) - 2, '*') AS name
FROM employees;

SELECT employee_id, first_name, last_name,
ROUND(MONTHS_BETWEEN(CURRENT_DATE, hire_date), 2)  AS months FROM employees;

SELECT employee_id, first_name, last_name,
DECODE(job_title,
                'GEN_MUD', 'A',
                'DEPO_SOR', 'B',
                'BIL_PROG', 'C',
                'SATIS_TEMS', 'D',
                'DEPO_MEM', 'E',

) grade
FROM employees JOIN jobs ON employees.job_id = jobs.job_id;

SELECT employee_id, first_name, last_name,
CASE job_title
                WHEN 'GEN_MUD' THEN 'A'
                WHEN 'DEPO_SOR' THEN 'B'
                WHEN 'BIL_PROG' THEN 'C'
                WHEN 'SATIS_TEMS' THEN 'D'
                WHEN 'DEPO_MEM' THEN 'E'

ELSE job_title END grade
FROM employees JOIN jobs ON employees.job_id = jobs.job_id;


SELECT employee_id, first_name, last_name,
    DECODE(job_title,
        'GEN_MUD', 'A',
        'DEPO_SOR', 'B',
        'BIL_PROG', 'C',
        'SATIS_TEMS', 'D',
        'DEPO_MEM', 'E',
        job_title) AS grade
FROM employees
JOIN jobs ON employees.job_id = jobs.job_id;