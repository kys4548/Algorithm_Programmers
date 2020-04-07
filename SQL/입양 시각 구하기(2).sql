select hour(datetime) as hour, count(*)
from animal_outs
group by hour
having hour between 0 and 23