# 1번 문제.
CREATE DATABASE HumanResource;

# 2번 문제.
USE HumanResource;

# 3번 문제.
CREATE TABLE Department (
	department_code VARCHAR(10) PRIMARY KEY,
    department_name VARCHAR(20) NOT NULL,
    department_tel_number VARCHAR(20) NOT NULL UNIQUE,
    department_address VARCHAR(20) NOT NULL,
    head_employee_number INT
);

CREATE TABLE Posit (
	position_code VARCHAR(10) PRIMARY KEY,
    position_name VARCHAR(20) NOT NULL
);

CREATE TABLE Employee (
	employee_number INT,
    employee_name VARCHAR(20) NOT NULL,
    employee_birth_date VARCHAR(20) NOT NULL,
    employee_tel_number VARCHAR(20) NOT NULL UNIQUE,
    employee_address VARCHAR(20) NOT NULL,
    department_code VARCHAR(10),
    position_code VARCHAR(10)
);

# 4번 문제.
ALTER TABLE Employee
ADD CONSTRAINT employee_foreign_key_1
FOREIGN KEY (department_code)
REFERENCES Department (department_code);

ALTER TABLE Employee
ADD CONSTRAINT employee_foreign_key_2
FOREIGN KEY (position_code)
REFERENCES Posit (position_code);

CREATE TABLE Annual_Income (
	department_code VARCHAR(10),
    position_code VARCHAR(10),
    annual_income_amount INT NOT NULL
);

# 5번 문제.
INSERT INTO Employee(employee_number, employee_name,
					employee_birth_date, employee_tel_number,
                    employee_address, department_code, position_code)
VALUES (2023010101, 'John doe', '1980-11-12', '010-9184-6574',
		'부산광역시 부산진구', 'DEV', 'PO1');
        
INSERT INTO Department(department_code, department_name, department_tel_number,
					department_address, head_employee_number)
VALUES ('DEV', '개발부', '051-240-1155', '부산광역시 부산진구', 2023010101);

INSERT INTO Posit(position_code, position_name)
VALUES ('PO1', '사원');

INSERT INTO Annual_Income(department_code, position_code, annual_income_amount)
VALUES ('DEV', 'PO1', 38000000);

# 6번 문제.
SELECT D.department_code, D.department_name, E.employee_name, E.employee_tel_number 
FROM Department D JOIN Employee E
ON D.head_employee_number = E.employee_number;

# 7번 문제.
INSERT INTO Employee(employee_number, employee_name,
					employee_birth_date, employee_tel_number,
                    employee_address, department_code, position_code)
VALUES (2023010102, 'raynor seo', '1993-06-02', '010-4736-1346', '부산광역시 서구', 'DEV', 'PO1');
COMMIT;

# 8번 문제.
ALTER TABLE Employee
ADD INDEX department_code_index (department_code);

ALTER TABLE Employee
ADD INDEX position_code_index (position_code);

# 9번 문제.
CREATE VIEW Department_View AS
SELECT D.department_code, D.department_name, E.employee_name, E.employee_tel_number 
FROM Department D JOIN Employee E
ON D.head_employee_number = E.employee_number;


