-- Using the Orders database introduced in Watt (2014) - Appendix C; write the SQL Statements for below cases:

-- 1. Get all the orders placed by a specific customer. CustomerID for this customer is MAGAA
SELECT * FROM [dbo].[tblOrders]
WHERE CustomerID = 'MAGAA';


-- 2. Show customers whose ContactTitle is not Sales Associate. Display CustomerID, CompanyName, Contact Name, and ContactTitle
SELECT CustomerID, CompanyName, ContactName, ContactTitle
FROM [dbo].[tblCustomers]
WHERE ContactTitle <> 'Sales Associate';


-- 3. Show customers who bought products where the EnglishName includes the string “chocolate”. Display CustomerID, CompanyName, ProductID, ProductName, and EnglishName
SELECT DISTINCT c.CustomerID, c.CompanyName, p.ProductID, p.ProductName, p.EnglishName
FROM [dbo].[tblCustomers] c
JOIN [dbo].[tblOrders] o ON c.CustomerID = o.CustomerID
JOIN [dbo].[tblOrderDetails] od ON o.OrderID = od.OrderID
JOIN [dbo].[tblProducts] p ON od.ProductID = p.ProductID
WHERE p.EnglishName LIKE '%chocolate%';


-- 4. Show products which were bought by customers from Italy or USA. ”. Display CustomerID, CompanyName, ShipCountry, ProductID, ProductName, and EnglishName
SELECT DISTINCT c.CustomerID, c.CompanyName, o.ShipCountry, p.ProductID, p.ProductName, p.EnglishName
FROM [dbo].[tblCustomers] c
JOIN [dbo].[tblOrders] o ON c.CustomerID = o.CustomerID
JOIN [dbo].[tblOrderDetails] od ON o.OrderID = od.OrderID
JOIN [dbo].[tblProducts] p ON od.ProductID = p.ProductID
WHERE o.ShipCountry IN ('Italy', 'USA');


-- 5. Show total price of each product in each order. Note that there is not a column named as total price. You should calculate it and create a column named as TotalPrice. Display OrderID, ProductID, ProductName, UnitPrice, Quantity, Discount, and TotalPrice
SELECT od.OrderID, od.ProductID, p.ProductName, od.UnitPrice, od.Quantity, od.Discount,
       (od.UnitPrice * od.Quantity * (1 - od.Discount)) AS TotalPrice
FROM [dbo].[tblOrderDetails] od
JOIN [dbo].[tblProducts] p ON od.ProductID = p.ProductID;


-- 6. Show how many products there are in each category and show the results in ascending order by the total number of products. Display CategoryName, and TotalProducts
-- Since there is no table related to Category, I created a table named tblCategories with CategoryID and CategoryName columns and also created the foreign key relationship between the "tblProducts" and "tblCategories" tables.
CREATE TABLE tblCategories (
    CategoryID int NOT NULL,
    CategoryName nvarchar(50) NOT NULL,
    CONSTRAINT PK_Categories PRIMARY KEY (CategoryID)
);

ALTER TABLE tblProducts
ADD CONSTRAINT FK_Products_Categories FOREIGN KEY (CategoryID)
REFERENCES tblCategories (CategoryID);


SELECT c.CategoryName, COUNT(p.ProductID) AS TotalProducts
FROM [dbo].[tblCategories] c
JOIN [dbo].[tblProducts] p ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryName
ORDER BY TotalProducts ASC;


-- 7. Show the total number of customers in each City. Display Country, City, TotalCustomers
SELECT Country, City, COUNT(CustomerID) AS TotalCustomers
FROM [dbo].[tblCustomers]
GROUP BY Country, City;


-- 8. Show the orders which were shipped late than the actual required date. Display OrderID, OrderDate, RequiredDate, and ShippedDate
SELECT OrderID, OrderDate, RequiredDate, ShippedDate
FROM [dbo].[tblOrders]
WHERE ShippedDate > RequiredDate;


-- References
-- Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M. & Danubianu, M. (2010).
-- Database fundamentals. IBM Canada.
-- Watt, A., & Eng, N. (2014). Database design,  2nd ed. BCcampus, BC Open Textbook Project.
-- Retrieved from https://opentextbc.ca/dbdesign01