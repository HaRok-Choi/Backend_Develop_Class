#주석(띄어쓰기 안해줘도 주석처리를 함)
-- 내용(띄어쓰기를 해줘야함)
/* 부분주석 */
/*
여러줄로
표시가능
*/

-- DDL (데이터 정의어)
# 데이터 베이스 혹은 테이블(뷰, 인덱스, 프로시저...)을 생성, 수정, 삭제 할 때 사용하는 SQL문

-- CREATE문
# 데이터베이스, 테이블 등을 생성할 때 사용하는 SQL문

-- 테이터베이스 생성
# CREATE DATABASE 테이터베이스명;
CREATE DATABASE hotel;
SHOW DATABASES;

-- 데이터베이스를 생성했으면 사용할 데이터베이스를 선택
# USE 데이터베이스명;
USE hotel;

-- 테이블 생성
# CREATE TABLE 테이블명 (
# 	필드명 데이터타입(테이터길이) 제약조건,
#	...
# );
CREATE TABLE custom (
	id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(30) UNIQUE, # 장문의 형태로 넣을때 TEXT, TEXT일때 DEFAULT, UNIQUE를 못준다(key를 못넣음)
    age INT,
    address TEXT,
    accept_marketing BOOLEAN DEFAULT false
);

SHOW TABLES;

# 데이터베이스 수정
# ALTER는 비추천(정확히 말하면 하면 안됨, DB는 한번 만들면 수정 안하는게 낫다.)
# ALTER DATABASE 데이터베이스명 속성명=값;

-- 테이블 수정
# ALTER TABLE 테이블명

-- 테이블 필드 추가
# ALTER TABLE 테이블명 ADD 필드명 데이터타입(데이터길이) 제약조건;

-- 테이블 필드 삭제
# ALTER TABLE 테이블명 DROP 필드명;

-- 테이블필드 수정
# ALTER TABLE 테이블명 MODIFY COLUMN 필드명 데이터타입(데이터길이) 제약조건;

# 데이터베이스 삭제(웬만하면 하지 않는게 좋음)
# DROP DATABASE 데이터베이스명;

-- 테이블 삭제
# DROP TABLE 테이블명;
# TRUNCATE TABLE 테이블명;

# DROP TABLE 테이블명 : 테이블의 정의 자체를 제거
# TRUNCATE TABLE 테이블명 : 테이블을 정의만 남기고 모두 제거 (생성 초기 상태로 돌려놓음)

-- DML (데이터 조작어)
# 데이터베이스 테이블에 레코드를 삽입, 수정, 삭제, 검색 작업을 수행시키고자 할 때 사용하는 SQL문

--  삽입문 (INSERT INTO)
# 해당 테이블에 레코드를 삽입 할 때 사용하는 SQL 구문
# INSERT INTO 테이블명(필드1, 필드2, ...)
# VALUES (필드1의 데이터, 필드2의 데이터, ...);
INSERT INTO Custom(id, name) VALUES (1, '로기');
# ↓ name은 not null인데 값이 없어서 오류뜸
INSERT INTO Custom(id, email) VALUES (5, 'qwe@qwe');
# ↓ 중복된 값이 들어가서 오류뜸
INSERT INTO Custom(id, name, email) VALUES(1, 'DD', 'fd@fd');

SELECT * FROM Custom;

# 모든 필드에 값을 넣을 때:
# INSERT INTO 테이블명
# VALUSE (데이터1, 데이터2);
INSERT INTO custom VALUES(10, 'joe', 're@re', 30, '부산', true);
# ↓ 타입이 같으면 순서를 바꿔도 무방하지만 값이 이상하게 들어갈 수도 있음
INSERT INTO Custom VALUES(11, 'ew@ew', 'Harok', 26, 'busan', true);
# ↓ 모든 값을 다 넣어줘야 함
INSERT INTO Custom VALUES(12, 'Michle', 'gf@gf', 30, '부산', true);

-- 수정문 (UPDATE)
# 해당 테이블에서 특정 필드의 값을 수정하고자 할 때 사용하는 SQL문

# UPDATE 테이블명 SET 필드명1=데이터1, 필드명2=데이터2, ...;
UPDATE Custom SET accept_marketing = false;
UPDATE Custom SET accept_marketing = false, age = 10;

# UPDATE 테이블명 SET 필드명1=데이터1, ...
# WHERE 조건;
UPDATE Custom SET email='gkfhr12@naver.com' WHERE id = 1;

-- 삭제문 (DELETE)
# 해당 테이블에서 레코드를 삭제할 때 사용하는 SQL문

# DELETE FROM 테이블명;
DELETE FROM Custom;
# DELETE FROM 테이블명 WHERE = 조건;
DELETE FROM Custom WHERE name = 'joe';

-- 검색문 (SELECT)
# 해당 테이블에서 특정 필드를 검색하고자 할 때 사용하는 SQL문

# SELECT 필드명1, 필드명2, ... FROM 테이블명;
SELECT id, name FROM Custom;

# SELECT * FROM 테이블명;
SELECT * FROM Custom;

# 필드에 별칭 사용
SELECT name AS 'FULL NAME' FROM Custom;

# 테이블에 별칭 사용
SELECT C.name FROM Custom AS C;

-- 중복 제거(DISTINCT)
SELECT DISTINCT name FROM Custom;

-- 연산자
# 비교 연산
# BETWEEN a AND b
# a 보다 크거나 같으면서 b 보다 작거나 같은 값을 찾음
SELECT * FROM Custom WHERE age BETWEEN 10 AND 20;

-- IN()
# 인수로 전달된 값과 동일한 값이 하나라도 존재한다면 true를 반환
SELECT * FROM Custom WHERE name IN ('Michle', 'harok', 'joe');

# SELECT * FROM Custom WHERE name = 'Michle' OR name = 'harok' OR name = 'joe'; 위에꺼랑 같다.

-- IS
# 비교 대상이 Boolean 형태일 때 사용하는 비교 연산자
SELECT * FROM Custom WHERE accept_marketing IS true;

-- IS NULL
# 비교 대상이 Null이면 true를 반환
SELECT * FROM Custom WHERE email IS NULL;

-- LIKE
# 문자열의 패턴을 비교하여 동일한 패턴을 가지고 있는 문자열이면 true를 반환

# 와일드카드
# % : 0개 이상의 패턴(많이 쓰임)
# _ : 1개의 패턴, 아주 정확할때 사용(많이 사용안함)
SELECT * FROM Custom WHERE email LIKE '%gmail%';

-- ★★★ Constraint (제약조건) ★★★
# RDBMS에서 삽입, 수정, 삭제에 대해서 무결성을 보장해주는 조건

-- NOT NULL
# 입력 혹은 수정 작업에 있어서 해당 필드에 Null이 올 수 없도록 하는 제약조건

# Create
CREATE TABLE NotnullTable1 (
	notnull_field INT NOT NULL
);

# ALTER
# ALTER로 NOT NULL 제약조건을 추가할 땐 원래 존재하는 레코드에서 해당 필드의 데이터가 Null이 존재하면 안됨
CREATE TABLE NotnullTable (
	notnull_field INT NOT NULL
); 

ALTER TABLE NotnullTable1
MODIFY COLUMN notnull_field INT NOT NULL;

-- Default
# 입력 작업에서 해당 필드의 값이 들어오지 않으면 기본값으로 지정해 주는 제약조건

# CREATE
CREATE TABLE defaultTable1 (
	default_field INT DEFAULT 1
);

# ALTER
CREATE TABLE defaultTable2 (
	default_field INT DEFAULT 1
);

ALTER TABLE defaultTable2
MODIFY COLUMN default_field INT DEFAULT 1;

-- UNIQUE
# 삽입, 수정 작업에서 해당 제약조건이 걸려있는 필드의 데이터에대해 중복을 허용하지 않는 제약조건

# CREATE
CREATE TABLE Unique_Table1 (
	unique_field INT UNIQUE
);

CREATE TABLE Unique_Table2 (
	unique_field INT,
    CONSTRAINT unique_key_1 UNIQUE (unique_field)
);

# ALTER
CREATE TABLE Unique_Table3 (
	unique_field INT UNIQUE
);

ALTER TABLE Unique_Table3 
MODIFY unique_field INT UNIQUE;

CREATE TABLE Unique_Table4 (
	unique_field INT UNIQUE
);

ALTER TABLE Unique_Table4
ADD CONSTRAINT unique_key_1 UNIQUE (unique_field);

-- PRIMARY KEY
# 기본키에 대한 제약조건, NOT NULL / UNIQUE가 포함 되어 있음
# 삽입, 수정시에 NULL을 포함할 수 없음, 중복된 데이터를 포함할 수 없음

# CREATE
CREATE TABLE primary_table1 (
	primary_field INT PRIMARY KEY
);

CREATE TABLE primary_table2 (
	primary_field INT,
    CONSTRAINT primary_key_1
    PRIMARY KEY (primary_field)
);

# ALTER
CREATE TABLE primary_table3 (
	primary_field INT
);

ALTER TABLE primary_table3
MODIFY COLUMN primary_field INT PRIMARY KEY;

CREATE TABLE primary_tabl4 (
	primary_field INT
);

ALTER TABLE primary_table4
ADD CONSTRAINT primary_key_1 PRIMARY KEY (primary_field);

-- FORIEGN KEY
# 참조제약조건, 해당 테이블을 해당 필드를 기준으로 외부 테이블의 외부 필드를 참조하도록 하는 제약조건
# 해당 제약조건이 걸려있는 필드의 경우 참조하는 테이블의 참조필드에 데이터가 존재하는 데이터만 삽입 할 수 있음

# CREATE
CREATE TABLE Referenced_Table (
	primary_key INT PRIMARY KEY
);

# CREATE 시에 참조 제약조건을 추가할 땐 선행적으로 참조할 테이블과 필드가 존재해야하고 참조할 필드가
# PRIMARY KEY 혹은 UNIQUE 제약조건이 지정되어 있어야 함
# 참조 제약조건이 걸리는 필드는 참조할 필드의 데이터타입과 일치해야함
CREATE TABLE Foreign_Table1 (
	foreign_field INT,
    CONSTRAINT foreign_key_1 FOREIGN KEY (foreign_field)
    REFERENCES Referenced_Table (primary_key)
);

# ALTER
CREATE TABLE Foreign_Table2 (
	foreign_field INT
);

ALTER TABLE Foreign_Table2
ADD CONSTRAINT foreign_key_1
FOREIGN KEY (foreign_field) REFERENCES Referenced_Table (primary_key);

---------------------------------------------------------------------------------

CREATE TABLE Room (
	room_number VARCHAR(4) PRIMARY KEY,
    room_type VARCHAR(20) NOT NULL,
    room_amount INT NOT NULL,
    custom_id INT,
    # ↓ 현재는 볼려는 용도로 만들어 놓은 것(관계가 맞지 않음)
    CONSTRAINT Room_Foreign_Key
    FOREIGN KEY (user_id)
    REFERENCES Custom (id)
);

INSERT INTO Room VALUES ('1001', '비즈니스', 200, 1);
INSERT INTO Room VALUES ('1203', 'VIP', 1000, 10);
INSERT INTO Room VALUES ('1801', 'VIP', 1000, 12);

INSERT INTO Room VALUES ('1002', '비즈니스', 200, 1);
INSERT INTO Room VALUES ('1204', 'VIP', 1000, 10);
INSERT INTO Room VALUES ('1802', 'VIP', 1000, 12);

INSERT INTO Room VALUES ('1003', '비즈니스', 200, null);
INSERT INTO Room VALUES ('1205', 'VIP', 1000, null);
INSERT INTO Room VALUES ('1803', 'VIP', 1000, null);

SELECT * FROM Room;

-- Join
# 여러개의 테이블에서 관계로 연결되어 있는 표현을 하나로 검색하도록 해주는 쿼리

## Inner Join
# FROM 첫번째테이블 INNER JOIN 두번째테이블 ON 조건
# FROM 첫번째테이블 JOIN 두번째테이블 ON 조건
# MySQL 경우 : FROM 첫번째테이블, 두번째테이블 WHERE 조건

SELECT * -- R.room_number AS '방번호', C.name AS '고객이름'
FROM Room R INNER JOIN Custom C
ON C.id = R.custom_id;

SELECT *
FROM Room JOIN Custom;

SELECT *
FROM Room, Custom
WHERE Room.custom_id = Custom.id;

## LEFT JOIN
# FROM 첫번째테이블 LEFT JOIN 두번째테이블 ON 조건
SELECT *
FROM Room LEFT JOIN Custom
ON Room.Custom_id = Custom.id;

INSERT INTO Custom VALUES (20, 'David', 'David@gmail.com', 30, 'New york', 1);
## RIGHT JOIN
# FROM 첫번째테이블 RIGHT JOIN 두번째테이블 ON 조건
SELECT *
FROM Room RIGHT JOIN Custom
ON Room.Custom_id = Custom.id;

-- Sub Query
# 복잡한 Join 문을 조금 더 간결하게 사용할 수 있도록 해주는 쿼리
# SELECT, INSERT, UPDATE, DELETE, SET, DO 에서 사용가능
# FROM, WHERE 절에서 사용가능

# WHERE절 사용
SELECT *
FROM Room
WHERE custom_id IN (
	SELECT id
    FROM Custom
    WHERE name = 'Michle'
);

# ex) IN 연산 + LIKE -> 이럴 때 서브쿼리를 써 줌.
SELECT *
FROM Custom
WHERE id IN (
	SELECT id
    FROM Custom
    WHERE name LIKE 'M%'
    OR name LIKE 'D%'
);

# FROM절 사용
SELECT CustomId
FROM ( # 별칭을 무조건 지정해줘야 한다. 반환되는 필드명으로 select자리에 넣어줘야 된다.
	SELECT id AS CustomId, email AS CustomEmail
    FROM Custom
) C;

## ORDER BY (정렬)
# 특정 필드를 기준으로 오름차순, 내림차순 정렬하여 결과를 반환
SELECT * FROM Namgu
ORDER BY 세대수 DESC;

SELECT * FROM Namgu
ORDER BY 통 DESC, 반 ASC;

-- VIEW
# 복잡한 쿼리문(SELECT)을 미리 작성해두고 재사용 할 수 있도록 해주는 읽기전용의 가상 테이블
# 읽기 전용이기 때문에 테이블의 삽입, 수정, 삭제 작업의 제약을 걸 때 사용 할 수 있음

# CREATE VIEW 뷰이름 AS
# SELECT ~~

CREATE VIEW Join_result AS
SELECT R.room_number AS '방번호', C.name AS '고객이름'
FROM Room R INNER JOIN Custom C
ON C.id = R.custom_id;

SELECT * FROM Join_result
WHERE 방번호 = 1203;

# ALTER VIEW 뷰이름 AS
# SELECT ~~
ALTER VIEW Join_Result AS
SELECT R.room_number AS '방번호', C.name AS '고객이름', C.email AS '고객이메일'
FROM Room R INNER JOIN Custom C
ON C.id = R.custom_id;

SELECT * FROM Join_Result;

# DROP TABLE 뷰이름
DROP VIEW Join_Result;

-------------------------------------------
# 시험
-- 시험
-- 데이터사전 : 메타데이터 같은것들, 임의의 만들어진 테이블을 보는것
-- 작성되어있는 테이블을 볼려면 어떤사전을 검색해야하는가? table 사전 검색
SHOW INDEXES FROM Custom;
SELECT * FROM mysql.user;
-------------------------------------------

-- INDEX
# 테이블의 검색 속도를 향상 시켜주는 기능을 담당하는 요소
# 인덱스가 적용되어있는 필드의 경우 해당 필드를 조건으로 검색을 시도할 때 검색속도가 향상됨
# 인덱스가 적용되어 있는 필드를 수정 할 경우 인덱스도 함께 변경되어 검색 속도에 영향을 미칠 수가 있음

# CREATE INDEX 인덱스명
# ON 테이블명 (필드명, ...);
CREATE INDEX seadaesu_index
ON Namgu (세대수);
-- ↑ 오로지 세대수만을 검색했을때

# SHOW INDEX FROM 테이블명
SHOW INDEX FROM Namgu;

CREATE INDEX seadaesu_index_2
ON Namgu (세대수, 인구수, 통); # 자주 사용하는거를 앞에 다 두는것이 좋음

CREATE UNIQUE INDEX seadaesu_unique_index
ON Namgu (세대수);

----------------------------------------------------------------------------

-- DCL (많이 안쓰임)
# 권한 제어 및 트랜잭션 제어를 담당하는 쿼리문의 집합

# 사용자 권한
CREATE USER 'Developer_user'@'%' IDENTIFIED BY '1234';

-- GRANT
# 사용자에게 권한을 부여하는 쿼리문
# GRANT 권한1, ... ON 데이터베이스.테이블 TO 사용자이름@호스트;
GRANT CREATE, INSERT, UPDATE, SELECT, DELETE
ON HOTEL.* TO 'Developer_user'@'%';

-- REVOKE
# 사용자로부터 권한을 회수하는 쿼리문
# REVOKE 권한1, ... ON 데이터베이스.테이블 FROM 사용자이름@호스트;
REVOKE CREATE ON HOTEL.* FROM 'Developer_user'@'%';

-- COMMIT
# 트랜잭션을 영구적으로 반영하는 쿼리문
COMMIT;

-- ROLLBACK
# 트랜잭션을 취소하고 되돌려 놓는 쿼리문
