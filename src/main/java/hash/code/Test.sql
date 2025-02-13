

select num as ConsecutiveNums
from
    (select num,count(1) as n_count
     from Logs
     group by num)t1
where n_count>=3