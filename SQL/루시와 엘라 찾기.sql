select a.animal_id, a.name, a.sex_upon_intake
from animal_ins a
where a.name in ('lucy','ella','pickle','rogan','sabrina','mitty')
order by a.animal_id