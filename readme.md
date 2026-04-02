# Employee Data Analysis using Java JDBC

This project demonstrates how to perform CRUD operations and basic analysis on employee data stored in a MySQL database using **Java JDBC**. The project reads data from a CSV file and performs various operations like inserting, reading, filtering, deleting, and computing aggregates.

---

## Features

1. Database Table Creation
- Creates an `employee2` table in MySQL with columns:
- `id` (Auto-increment Primary Key)
- `education`
- `joiningYear`
- `city`
- `paymentTier`
- `age`
- `gender`
- `everBenched`
- `experienceInCurrentDomain`
- `leaveOrNot`

2. Insert CSV Data
- Reads `Employee.csv` and inserts all rows into the database using `PreparedStatement`.

3. Read Data
- Fetches all employee data and prints it in the console.

4. Analysis Functions
- Employees per City: Counts the number of employees in each city.
- Average Payment by Education: Computes average payment tier per education level.
- High Experience Employees: Lists employees with more than 5 years of experience.
- Delete Employees: Deletes employees who are benched and on leave, and displays remaining employees.

---
