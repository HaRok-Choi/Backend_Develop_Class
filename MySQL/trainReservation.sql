-- 기차 예약 데이터베이스 생성
CREATE DATABASE train_reservation;
USE train_reservation;

-- 가격 테이블 생성
CREATE TABLE Cost (
	departure_station VARCHAR(50) NOT NULL,
    arrival_station VARCHAR(50) NOT NULL,
    amount INT NOT NULL
);

-- 기차 테이블 생성
# 필수값인지 중복이 아닌지부터 봐야됨
# PRIMARY KEY안에 NOT NULL과 UNIQUE가 포함 되어있다.
CREATE TABLE Train ( # 주
	train_number VARCHAR(10) PRIMARY KEY,
    departure_station VARCHAR(50) NOT NULL,
    departure_time TIME NOT NULL,
    arrival_station VARCHAR(50) NOT NULL,
    arrival_time TIME NOT NULL,
    take_minute TIME NOT NULL,
    type VARCHAR(10) NOT NULL
    # 관계DB의 단점(배열을 표현 못함, 따로 정의 해놓아야 됨)
);

CREATE TABLE Station ( # 주
	station_number INT AUTO_INCREMENT PRIMARY KEY,
	station_name VARCHAR(50) NOT NULL,
    address TEXT NOT NULL UNIQUE,
    tel_number VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE STOP_STATION ( # 테이블, 필드명은 웬만하면 단수형태
	station_name INT NOT NULL,
    train_number VARCHAR(10) NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL
);

CREATE TABLE SEAT (
	# 아래의 3개를 합쳐야 SEAT을 설명 가능, 그래서 3개를 전부 기본키를 잡아야한다. 하지만 3개다 기본키라서 참조가 힘들다 
	seat_code VARCHAR(5) PRIMARY KEY,
	type VARCHAR(10), # 일반실, 특실 타입을 의미
    seat_number VARCHAR(2), # A1, A2 이렇게 있을거임
    train_type VARCHAR(10)
);


