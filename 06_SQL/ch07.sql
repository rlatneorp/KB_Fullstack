use sqldb;
-- sqldb 데이터베이스에서 다음 조건을 처리하세요
-- 사용자별로 구매 이력을 출력함 => buytbl과 usertbl 모두 필요
select name u , prodName b
from buytbl b join usertbl u on b.userID = u.userID;
-- 모든 컬럼을 출력함 => select *
select *
from buytbl join usertbl using(userID);
-- 구매 이력이 없는 정보는 출력하지 않음 => inner join (join)은 두 테이블에 모두 정보가 존재해야 출력된다.
-- join시 보통 테이블의 별칭을 정해준다
-- on뒤에는 어떤 컬럼을 기준으로 합쳐줄지를 적어준다
select * 
from buytbl join usertbl using(userID);

-- 앞의 결과에서 userID가 'JYP'인 데이터만 출력하세요.
select * 
from buytbl join usertbl using(userID)
where userID = "jyp";

-- sqldb 데이터베이스에서 다음 조건을 처리하세요.
-- 각 사용자별로 구매 이력을 출력하세요.
select userId, prodName 
from buytbl;
-- 연결 컬럼은 UserID로 함 => on b.userId = u.userID
select name, prodName 
from buytbl join usertbl using(userId);
-- 결과를 userID를 기준으로 오름차순으로 정렬함
select name, prodName 
from buytbl join usertbl using(userId)
order by userID;
-- 구매이력이 없는 사용자도 출력하세요 => outer join
select name, prodName 
from buytbl right join usertbl using(userId)
order by userID;

-- userId, name, prodName, addr, 연락처를 다음과 같이 출력함
select userId, name, prodName, addr, concat(mobile1, mobile2) 연락처
from usertbl left join buytbl using(userId)
order by userID;


-- sqldb의 사용자를 모두 조회하되 전화가 없는 사람은 제외하고 출력하세요.
select name
from usertbl
where mobile1 is not null;

select *
from usertbl
where name not in (select name from usertbl where mobile1 is null);

-- sqldb의 사용자를 모두 조회하되 전화가 없는 사람만 출력하세요.
select *
from usertbl
where mobile1 is null;

select *
from usertbl
where name in (select name from usertbl where mobile1 is null);