SELECT * FROM Namgu;

SELECT 구분, 세대수, 면적
FROM Namgu;

SELECT DISTINCT 면적, 구분, 세대수
FROM Namgu;
# 특정한 하나를 구분하고 싶을때는 DISTINCT말고 GROUP BY 써야 됨

SELECT * FROM Namgu WHERE 구분 = '문현2동 ';
SELECT * FROM Namgu WHERE 구성비 = 3;

SELECT * FROM Namgu WHERE 구분 LIKE '문%';
SELECT * FROM Namgu WHERE 구분 LIKE '%현%';

SELECT * FROM Namgu WHERE 세대수 >= 10000;
SELECT * FROM Namgu WHERE 세대수 <= 5000;

SELECT * FROM Namgu WHERE 세대수 <= 10000 AND 세대수 >= 5000;
SELECT * FROM Namgu WHERE 세대수 BETWEEN 5000 AND 10000; # 작은수가 앞에 온다.

SELECT * FROM Namgu WHERE 통 IN (21, 22, 23); # ()안의 인수가 리스트에 있으면 값이 나옴
SELECT * FROM Namgu WHERE 통 NOT IN (21, 22, 23);
# ↑ 자주 쓰이는 것들

# Namgu 테이블에서 인구수가 1만명 이상이면서 18세이상 인구수 1.2만명 이하인 레코드 중 전체 필드 검색
SELECT * FROM Namgu WHERE 인구수 >= 10000 AND 18세이상인구수 <= 12000; 

# Namgu 테이블에서 통이 20 이상이거나 반이 100 이하인 레코드 중 구분, 세대수, 인구 필드를 검색
SELECT 구분, 세대수, 인구수, 통, 반 FROM Namgu WHERE 통 >= 20 OR 반 <= 100;

# Namgu 테이블에서 인구수가 1만명 이상이면서 18세이상 인구수 1.2만명 이하이거나 반이 100이하인 레코드의 전체 필드 검색
SELECT * FROM Namgu WHERE 인구수 >= 10000 AND (18세이상인구수 <= 12000 OR 반 <= 100);

 SELECT * FROM Namgu WHERE 인구수 >= 10000 AND 18세이상인구수 <= 12000 OR 반 <= 100;