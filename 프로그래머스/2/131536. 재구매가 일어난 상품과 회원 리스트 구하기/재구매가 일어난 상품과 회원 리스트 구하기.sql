-- 코드를 입력하세요

select distinct p.user_id, p.product_id from online_sale p 
join (select user_id, product_id, count(product_id) cnt 
from online_sale 
group by user_id, product_id 
order by user_id, product_id) c
on p.user_id = c.user_id and p.product_id = c.product_id
where c.cnt >= 2
order by p.user_id, p.product_id desc;