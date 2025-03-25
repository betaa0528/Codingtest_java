-- 코드를 입력하세요
select name, count(*) from animal_ins 
having name is not null and count(*) >= 2
group by name
order by name;
