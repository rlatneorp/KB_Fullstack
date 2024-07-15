-- 다음과 같이 테이블과 데이터를 준비하세요.
use sqldb;

-- NOT NULL : null이 될 수 없다
-- PRIMARY KEY : 기본키(식별자), 중복되지 않고 null이 될 수 없다
create table stdtbl(
stdName varchar(10) not null primary key,
addr char(4) not null);

create table clubtbl(
clubName varchar(10) not null primary key,
roomNo char(4) not null);

create table stdclubtbl(num int auto_increment not null primary key,
stdName varchar(10) not null,
clubName varchar(10) not null,
foreign key(stdName) references stdtbl(stdName),
foreign key(clubName) references clubtbl(clubName));

-- 다음과 같이 테이블과 데이터를 준비하세요.
insert into stdtbl values ('김범수','경남'), ('성시경','서울'),('조용필','경기'),('은지원','경북'),('바비킴','서울');
insert into clubtbl values ('수영','101호'), ('바둑','102호'),('축구','103호'),('봉사','104호');
insert into stdclubtbl values (null,'김범수','바둑'),(null,'김범수','축구'),(null,'조용필','축구'),
			(null,'은지원','축구'),(null,'은지원','봉사'),(null,'바비킴','봉사');
            
-- 앞에서 정의한 3개의 테이블을 이용해서 다음을 처리하세요.
-- 학생 테이블, 동아리 테이블, 학생 동아리 테이블을 이용해서 학생을 기준으로
-- 학생 이름/지역/가입한 동아리/동아리방을 출력하세요.
select sc.stdName,s.addr,sc.clubName,c.roomNo
from stdtbl s join stdclubtbl sc on(s.stdName = sc.stdName)
			join clubtbl c on(c.clubName = sc.clubName);

-- 동아리를 기준으로 가입한 학생의 목록을 출력하세요
-- 출력정보: clubName, roomNo, stdName, addr
select c.clubName, c.roomNo, s.stdName, s.addr
from clubtbl c join stdclubtbl sc on(c.clubName = sc.clubName)
			join stdtbl s on(sc.stdName = s.stdName); 

-- 다음과 같이 테이블과 데이터를 준비하세요
use sqldb;
create table emptbl(emp char(3), manager char(3), emptel varchar(8));

insert into emptbl values('나사장', null, '0000');
insert into emptbl values('김재무', '나사장', '2222');
insert into emptbl values('김부장', '김재무', '2222-1');
insert into emptbl values('이부장', '김재무', '2222-2');
insert into emptbl values('우대리', '이부장', '2222-2-1');
insert into emptbl values('지사원', '이부장', '2222-2-2');
insert into emptbl values('이영업', '나사장', '1111');
insert into emptbl values('한과장', '이영업', '1111-1');
insert into emptbl values('최정보', '나사장', '3333');
insert into emptbl values('윤차장', '최정보', '3333-1');
insert into emptbl values('이주임', '윤차장', '3333-1-1');

-- 앞에서 추가한 테이블에서 '우대리'의 상관 연락처 정보를 확인하세요.
-- 출력할 정보 : 부하직원,직속상관, 직속상관연락처
-- 동일한 테이블을 두개 만들어서 'join' 시킴 => self join 
select e1.emp, e2.manager, e2.emptel 
from emptbl e1 join emptbl e2 on e1.manager = e2.emp
where e1.emp = '우대리';