/* Suppose that a website contains two tables, the 
 * Customers table and the Orders table. Write a 
 * SQL query to find all customers who never order 
 * anything.
 * 
 * Table: Customers.
 * 
 * +----+-------+
 * | Id | Name  |
 * +----+-------+
 * | 1  | Joe   |
 * | 2  | Henry |
 * | 3  | Sam   |
 * | 4  | Max   |
 * +----+-------+
 * Table: Orders.
 * 
 * +----+------------+
 * | Id | CustomerId |
 * +----+------------+
 * | 1  | 3          |
 * | 2  | 1          |
 * +----+------------+
 * Using the above tables as example, return the 
 * following:
 * 
 * +-----------+
 * | Customers |
 * +-----------+
 * | Henry     |
 * | Max       |
 * +-----------+
 */

SELECT Name FROM Customers C LEFT JOIN Orders O ON 
C.Id = O.CustomerId WHERE CustomerId IS NULL;

/****************************************************/

SELECT Name FROM Customers C WHERE C.Id 
NOT IN (SELECT CustomerId FROM Orders O);

/****************************************************/

SELECT Name FROM Customers C LEFT JOIN Orders O ON 
C.id = O.CustomerId WHERE O.Id IS NULL;

/****************************************************/

SELECT Name FROM Customers C WHERE NOT EXISTS (SELECT 
CustomerId FROM Orders O WHERE O.CustomerId = C.Id);
