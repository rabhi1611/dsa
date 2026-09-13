# Write your MySQL query statement below

with temp_table as (
    select *,
    dense_rank() over (order by score desc) as `rank`
    from Scores
)

select score, `rank`
from temp_table;