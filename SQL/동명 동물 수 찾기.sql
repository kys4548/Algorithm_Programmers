select NAME, count(name) as COUNT
from animal_ins
group by name
having COUNT >1
order by name