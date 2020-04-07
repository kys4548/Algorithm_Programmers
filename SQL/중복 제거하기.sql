select count(name)
from (
select *
from animal_ins
group by name) as A