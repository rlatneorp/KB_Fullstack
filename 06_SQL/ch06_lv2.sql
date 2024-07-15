use sqldb;
-- 다음 결과가 나오도록 buytbl에 대한 SQL 문을 각각 작성하세요.
-- group by 로 userID별 그룹을 만들어서 amount의 총 합계를 sum으로 구해줌
select userID '사용자 아이디', sum(amount) '총 구매 개수'
from buytbl
group by userID;
 
-- 각 구매개수 * 가격을 구한 후 총합을 구함
select userID '사용자 아이디', sum(amount*price) '총 구매액'
from buytbl
group by userID;

-- 다음 결과가 나오도록 buytbl에 대한 SQL 문을 각각 작성하세요.
-- 전체 개수의 평균이므로 그룹화가 불필요
select avg(amount) '평균 구매 개수'
from buytbl;

-- userID별로 평균값이 필요하므로 그룹화 필요
select userID, avg(amount) '평균 구매 개수'
from buytbl
group by userID;

-- 가장 키가 큰 사람과 가장 키가 작은 사람을 출력함
-- MAX로는 가장 키가 큰 사람, MIN으로 가장 키가 작은 사람 출력 가능
-- OR을 사용해서 둘 중 하나만 만족해도 출력 가능
use sqldb;
select name, height
from usertbl
where height = (select max(height) from usertbl) or height = (select min(height) from usertbl);

-- 다음 결과가 나오도록 usertbl에 대한 SQL 문을 작성하세요.
select count(mobile1) '휴대폰이 있는 사용자'
from usertbl;

-- buytbl 테이블로 다음을 처리하세요.
-- 사용자별 총 구매액을 출력하세요.
-- oo별이 나오면 group by 예상 가능
select userID 사용자, sum(amount * price) 총구매액
from buytbl
group by userID;

-- 총 구매액이 1000이상인 사용자만 출력하세요.
-- where절은 그룹화하기 전에 필터링하는 작업이다
-- 따라서 그룹화된 데이터에 조건을 추가하려면 having을 사용해야한다.
select userID 사용자, sum(amount * price) 총구매액
from buytbl
group by userID
having sum(amount * price) >= 1000;

-- world 데이터베이스에서 다음 질문을 처리하세요.
-- city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 총합을 구하시오.
use world;
select sum(population)
from city
where countrycode = 'KOR';

-- city 테이블에서 국가코드가 'KOR'인 도시들의 인구수 중 최소값을 구하시오.
-- 단 결과를 나타내는 테이블의 필드는 "최소값"으로 표시하시오.
select min(population) '최소값'
from city
where countrycode = 'KOR';

-- city 테이블에서 국가코드가 'KOR'인 도시들의 평균을 구하시오
select avg(population)
from city
where countrycode = 'KOR';

-- city테이블에서 국가코드가 'KOR'인 도시들의 인구수 중 최대값을 구하시오.
-- 단 결과를 나타내는 테이블의 필드는 "최대값'으로 표시하시오.
select max(population) '최대값'
from city
where countrycode = 'KOR';

-- country 테이블 각 레코드의 Name 칼럼의 글자수를 표시하시오
-- length : 해당 문자열의 길이
select name, length(name)
from country;

-- country 테이블의 나라명(NAme칼럼)을 앞 세글자만 대문자로 표시하시오.
-- upper : 특정 글자를 대문자로 변경
-- mid : 문자열 추출 (문자열,시작위치,길이) 시작 위치는 1부터 시작
select upper(mid(name,1,3)) from country;

-- country 테이블의 기대수명(LifeExpectancy)을 소수점 첫째자리에서 반올림헤서 표시하시오
-- round : 반올림 ( 반올림할 값, 몇째 자리에서 반올림할지)
select name 이름, round(LifeExpectancy,1) 기대수명 from country;
