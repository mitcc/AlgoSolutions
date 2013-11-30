/*
Given a Weather table, write a SQL query to find all 
dates' Ids with higher temperature compared to its 
previous (yesterday's) dates.

+---------+------------+------------------+
| Id(INT) | Date(DATE) | Temperature(INT) |
+---------+------------+------------------+
|       1 | 2015-01-01 |               10 |
|       2 | 2015-01-02 |               25 |
|       3 | 2015-01-03 |               20 |
|       4 | 2015-01-04 |               30 |
+---------+------------+------------------+
For example, return the following Ids for the above 
Weather table:
+----+
| Id |
+----+
|  2 |
|  4 |
+----+

*/

SELECT W1.Id FROM Weather W1 INNER JOIN Weather W2 
ON TO_DAYS(W1.Date) = TO_DAYS(W2.Date) + 1 AND 
W1.Temperature > W2.Temperature;
