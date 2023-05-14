-- I used SQL online tools to execute the SQL statements in my web browser.

-- A) The Company Technical Officer needs reports that contain the following information:

-- 1. The location id, street address, and country of the locations where the company is doing business.
-- The SQL statement:
SELECT location_id, street_address, countries.country_name
FROM locations
INNER JOIN countries
ON locations.country_id = countries.country_id;

-- The output:

-- location_id
-- street_address
-- country_name
-- 1800
-- 147 Spadina Ave
-- Canada
-- 2700
-- Schwanthalerstr. 7031
-- Germany
-- 2400
-- 8204 Arthur St
-- United Kingdom
-- 2500
-- Magdalen Centre, The Oxford Science Park
-- United Kingdom
-- 1700
-- 2004 Charade Rd
-- United States of America
-- 1500
-- 2011 Interiors Blvd
-- United States of America
-- 1400
-- 2014 Jabberwocky Rd
-- United States of America



-- The explanation:
-- In the SQL statement, the INNER JOIN clause is used to join the locations table with countries table based on their country_id.

-- 2. The total number of employees working in each department. 
-- The SQL statement:
SELECT departments.department_id, department_name, COUNT(*) AS total_employees
FROM departments
INNER JOIN employees
ON departments.department_id = employees.department_id
GROUP BY departments.department_id;

-- The output:
-- department_id
-- department_name
-- total_employees
-- 1
-- Administration
-- 1
-- 2
-- Marketing
-- 2
-- 3
-- Purchasing
-- 6
-- 4
-- Human Resources
-- 1
-- 5
-- Shipping
-- 7
-- 6
-- IT
-- 5
-- 7
-- Public Relations
-- 1
-- 8
-- Sales
-- 6
-- 9
-- Executive
-- 3
-- 10
-- Finance
-- 6
-- 11
-- Accounting
-- 2



-- The explanation:
-- In the SQL statement, the INNER JOIN clause is used to join the department's table with the employee's table based on their department_id. The COUNT(*) function is used to count the number of employees working in each department. The GROUP BY clause groups the employees based on their department_id.

-- 3. A list of employees who are working as “Stock Managers”. The output must have the employee id, his/her first name, department id, job id, and job title. 
The SQL statement:
SELECT employees.employee_id, employees.first_name, employees.department_id, employees.job_id, jobs.job_title
FROM employees
INNER JOIN jobs
ON employees.job_id = jobs.job_id
WHERE jobs.job_title = 'Stock Manager';

-- The output:
-- employee_id
-- first_name
-- department_id
-- job_id
-- job_title
-- 120
-- Matthew
-- 5
-- 19
-- Stock Manager
-- 121
-- Adam
-- 5
-- 19
-- Stock Manager
-- 122
-- Payam
-- 5
-- 19
-- Stock Manager
-- 123
-- Shanta
-- 5
-- 19
-- Stock Manager


-- The explanation:
-- In the SQL statement, the INNER JOIN clause is used to join the employee's table with the jobs table based on their job_id. The WHERE clause is used to filter the result to only include the employees whose job titles are Stock Manager.

-- B) The HR Head of the company wants reports containing the following information: 

-- 1. A list of employees (first and last name) who have been working in the company since the year 1999 including the date they were hired. The output must be sorted in descending order of their hiring date and ascending on the first name of the employee. 
-- The SQL statement:
SELECT first_name, last_name, hire_date
FROM employees
WHERE hire_date <= 1999
ORDER BY hire_date DESC, first_name ASC;

-- The output:
-- first_name
-- last_name
-- hire_date
-- Guy
-- Himuro
-- 1998-11-15
-- Irene
-- Mikkilineni
-- 1998-09-28
-- Jack
-- Livingston
-- 1998-04-23
-- Jonathon
-- Taylor
-- 1998-03-24
-- Jose Manuel
-- Urman
-- 1998-03-07
-- Valli
-- Pataballa
-- 1998-02-05
-- Shelli
-- Baida
-- 1997-12-24
-- Shanta
-- Vollman
-- 1997-10-10
-- Ismael
-- Sciarra
-- 1997-09-30
-- John
-- Chen
-- 1997-09-28
-- Pat
-- Fay
-- 1997-08-17
-- Sigal
-- Tobias
-- 1997-07-24
-- David
-- Austin
-- 1997-06-25
-- Adam
-- Fripp
-- 1997-04-10
-- Britney
-- Everett
-- 1997-03-03
-- Karen
-- Partners
-- 1997-01-05
-- John
-- Russell
-- 1996-10-01
-- Matthew
-- Weiss
-- 1996-07-18
-- Michael
-- Hartstein
-- 1996-02-17
-- Sarah
-- Bell
-- 1996-02-04
-- Alexander
-- Khoo
-- 1995-05-18
-- Payam
-- Kaufling
-- 1995-05-01
-- Den
-- Raphaely
-- 1994-12-07
-- Nancy
-- Greenberg
-- 1994-08-17
-- Daniel
-- Faviet
-- 1994-08-16
-- Hermann
-- Baer
-- 1994-06-07
-- Shelley
-- Higgins
-- 1994-06-07
-- Susan
-- Mavris
-- 1994-06-07
-- William
-- Gietz
-- 1994-06-07
-- Lex
-- De Haan
-- 1993-01-13
-- Bruce
-- Ernst
-- 1991-05-21
-- Alexander
-- Hunold
-- 1990-01-03
-- Neena
-- Kochhar
-- 1989-09-21
-- Jennifer
-- Whalen
-- 1987-09-17
-- Steven
-- King
-- 1987-06-17


-- The explanation:
-- In the SQL statement, the WHERE clause is used to filter the result to include only employees who were hired before the year 2000. The ORDER BY clause is used to sort the result in descending order for hire_date and ascending order for first_name.

-- 2. The average salary of “Programmers”.
-- The SQL statement:
SELECT AVG(salary) AS average_salary
FROM employees
INNER JOIN jobs
ON employees.job_id = jobs.job_id
WHERE job_title = 'Programmer';

-- The output:
-- average_salary
-- 5760


-- The explanation:
-- In the SQL statement, the INNER JOIN is used to join the employees with the jobs table based on the job_id. The WHERE clause is used to filter the result to only include employees whose job title is "Programmer". The AVG() function is used to calculate the average salary of programmers and output as average_salary.

-- 3. The employees who are managed by Employee ID 114. Output must have such Employees’ ID, First name, Last name, his/her Manager ID, and Manager Name. 
-- The SQL statement:
SELECT employees.employee_id, employees.first_name, employees.last_name, employees.manager_id, managers.first_name AS manager_first_name, managers.last_name AS manager_last_name
FROM employees
INNER JOIN employees AS managers
ON employees.manager_id = managers.employee_id
WHERE employees.manager_id = 114;

-- The output:
-- employee_id
-- first_name
-- last_name
-- manager_id
-- manager_first_name
-- manager_last_name
-- 115
-- Alexander
-- Khoo
-- 114
-- Den
-- Raphaely
-- 116
-- Shelli
-- Baida
-- 114
-- Den
-- Raphaely
-- 117
-- Sigal
-- Tobias
-- 114
-- Den
-- Raphaely
-- 118
-- Guy
-- Himuro
-- 114
-- Den
-- Raphaely
-- 119
-- Karen
-- Colmenares
-- 114
-- Den
-- Raphaely



-- The explanation:
-- In the SQL statement, the INNER JOIN clause is used to join the employee's table with itself based on the manager_id. The WHERE clause is used to filter the result to only include employees who are managed by employee_id 114.




-- References
-- Din, A. I. (2006).  Structured Query Language (SQL): A practical introduction. NCC Blackwell.
-- Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M. & Danubianu, M. (2010). Database fundamentals. IBM Canada.

-- 883 words
