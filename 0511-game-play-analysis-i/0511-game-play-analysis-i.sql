# Write your MySQL query statement below
SELECT a.player_id, MIN(a.event_date) 
AS first_login 
FROM Activity a 
GROUP BY player_id;