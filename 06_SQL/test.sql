use world;

select * from city
where countrycode = 'kor'
order by population desc;

select name, population
from city
where countrycode = 'kor' and population < (select population from city where id = 2358)
order by population desc;

use employees;
create table users
(select first_name as name, gender from employees);

select * from users;

use world;

select * from city
where countrycode = 'kor';

create table kor_city
(select id,name,district,population from city
where countrycode = 'kor');

select * from kor_city;

use world;

select countrycode, sum(population) as '인구수'
from city
group by countrycode
having sum(population) > 10000000
order by sum(population) desc;
