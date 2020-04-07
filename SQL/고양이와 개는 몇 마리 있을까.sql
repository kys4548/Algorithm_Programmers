select animal_type, count(animal_id) as count
from animal_ins
where animal_type IN ('Cat','Dog')
group by animal_type
order by animal_type