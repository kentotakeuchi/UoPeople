-- Union
-- Union operator is used to return one combined result of multiple SELECT statements.

SELECT Student_ID, Course_ID
FROM Student_Courses
WHERE Year = 2019
UNION
SELECT Student_ID, Course_ID
FROM Student_Courses
WHERE Grade = 'A'

-- Inner Join
-- The inner Join operator is used to return matching records from both tables.

SELECT Student_Name, Grade 
FROM Student 
INNER JOIN Student_Courses 
ON Student.Student_ID = Student_Courses.Student_ID 
WHERE Dept_Name = 'Computer Science';

-- Left Outer Join
-- The left Outer Join operator is used to return all records from the left table and the matching records from the right table.

SELECT Student_Name, Grade 
FROM Student 
LEFT OUTER JOIN Student_Courses 
ON Student.Student_ID = Student_Courses.Student_ID 
WHERE Dept_Name = 'Computer Science' OR Student_Courses.Student_ID IS NULL;

-- The above query gets the students' names and their grades in Computer Science and also gets the names and grades who do not take any courses.

-- Right Outer Join
-- Right Outer Join is used to return all records from the right table and the matching records from the left table.

SELECT Student_Name, Grade 
FROM Student 
RIGHT OUTER JOIN Student_Courses 
ON Student.Student_ID = Student_Courses.Student_ID 
WHERE Dept_Name = 'Business Administration' OR Student.Student_ID IS NULL;

-- The above query gets the students' names and their grades in Business Administration and also gets courses that no students enroll in.

-- Full Outer Join
-- Full Outer Join is used to return all records from both tables.

SELECT Student_Name, Grade 
FROM Student 
FULL OUTER JOIN Student_Courses 
ON Student.Student_ID = Student_Courses.Student_ID;

-- The above query gets all the students' names and their grades including students who do not take any courses.

-- Reference
-- Din, A. I. (2006).  Structured Query Language (SQL): A practical introduction. NCC Blackwell.