use sakila;

select * from actor_info;

select * from buytbl;
select userID, sum(amount)
from buytbl
group by userID;

select userID, GROUP_CONCAT(prodName SEPARATOR ',')
from buytbl
group by userID;

 
