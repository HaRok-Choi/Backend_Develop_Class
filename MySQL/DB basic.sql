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

