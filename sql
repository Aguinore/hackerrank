SELECT id, age, coins_needed, power
FROM Wands w JOIN Wands_Property wp
ON w.code = wp.code
WHERE is_evil = 0 and coins_needed = (
    select min(coins_needed)
    from wands join Wands_Property
    ON Wands.code = Wands_Property.code
    where age = wp.age and power = w.power
    )
ORDER BY power desc, age desc 

https://www.hackerrank.com/challenges/harry-potter-and-wands/problem
