select ai.animal_id, ai.animal_type, ai.name
from animal_ins ai left join animal_outs ao on ai.animal_id = ao.animal_id
where ao.datetime is not null and ai.sex_upon_intake like 'intact%'  and 
        (ao.sex_upon_outcome like 'spayed%' or ao.sex_upon_outcome like 'neutered%')
order by ai.animal_id