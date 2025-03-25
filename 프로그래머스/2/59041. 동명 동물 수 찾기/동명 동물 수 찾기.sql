-- 코드를 입력하세요
select name, count(*) from animal_ins 
group by name
having name is not null and count(*) >= 2
order by name;