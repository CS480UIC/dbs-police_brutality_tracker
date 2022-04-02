SELECT *
FROM police_officers
WHERE (department = 'Chicago')
ORDER BY officer_rank;

SELECT *
FROM victims
WHERE (gender = 'male')
ORDER BY victim_name;



SELECT LOWER(address)
FROM victims;

SELECT COUNT(*)
FROM infractions
WHERE (date = CURDATE());

SELECT force_type
FROM infractions
GROUP BY force_type
HAVING COUNT(*) > 3;



SELECT *
FROM infractions
WHERE EXISTS
(SELECT victim_id FROM victims WHERE address IS NOT NULL);

SELECT *
FROM INFRACTIONS
INNER JOIN victims ON (infraction.victim = victims.victim_id);

SELECT COUNT(*)
FROM (
	SELECT COUNT(*) AS NUM 
	FROM infractions
	GROUP BY force_type
)
WHERE NUM >= 2;
