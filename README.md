# Student Management System (Eclipse Project)

A console-based Java application built using JDBC and MySQL. This application allows users to perform CRUD (Create, Read, Update, Delete) operations on student records.

---

## Features
- **Add Student**: Insert new student records (ID, Name, Course) into the database.
- **View All Students**: Retrieve and display all student records from the database in a list.
- **Update Student**: Modify a student's name by their ID.
- **Delete Student**: Remove a student record from the database by ID.
- **Exit**: Close the application.

---

## Project Structure
- [Student.java](file:///d:/Users/dell/eclipse-workspace/StudentManagementSystemjava/src/com/student/model/Student.java): The model class representing a Student object.
- [StudentDAO.java](file:///d:/Users/dell/eclipse-workspace/StudentManagementSystemjava/src/com/student/dao/StudentDAO.java): Data Access Object containing JDBC CRUD methods (`addStudent`, `viewStudents`, `updateStudent`, `deleteStudent`).
- [DBConnection.java](file:///d:/Users/dell/eclipse-workspace/StudentManagementSystemjava/src/com/student/util/DBConnection.java): Database utility class configuring the MySQL connection.
- [StudentMain.java](file:///d:/Users/dell/eclipse-workspace/StudentManagementSystemjava/src/com/student/main/StudentMain.java): Main entry point with the console-based menu loop.

---

## Prerequisites
Ensure the following are installed and configured:
1. **Java Development Kit (JDK 17 or higher)**
2. **MySQL Server** (Ensure the service is running, e.g., `MySQL80`)
3. **MySQL Connector/J Jar**: Located on your system at:
   `E:\mysql-connector-j-9.7.0\mysql-connector-j-9.7.0\mysql-connector-j-9.7.0.jar`

---

## Setup Instructions

### 1. Database Configuration
By default, the code in [DBConnection.java](file:///d:/Users/dell/eclipse-workspace/StudentManagementSystemjava/src/com/student/util/DBConnection.java) uses:
- **Database**: `studentdb`
- **User**: `root`
- **Password**: `mysql`

To prepare your MySQL database:
```sql
CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50)
);
```

You can run this setup script in MySQL CLI or workbench:
```powershell
& "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -u root -pmysql -e "CREATE DATABASE IF NOT EXISTS studentdb; USE studentdb; CREATE TABLE IF NOT EXISTS student (id INT PRIMARY KEY, name VARCHAR(50), course VARCHAR(50));"
```

---

## Build and Run

### Running via Command Line (PowerShell)

1. **Compile the project**:
   Open a terminal in the project root directory (`d:\Users\dell\eclipse-workspace\StudentManagementSystemjava`) and compile the source files to the `bin` directory:
   ```powershell
   javac -d bin -cp "E:/mysql-connector-j-9.7.0/mysql-connector-j-9.7.0/mysql-connector-j-9.7.0.jar" src/com/student/model/Student.java src/com/student/util/DBConnection.java src/com/student/dao/StudentDAO.java src/com/student/main/StudentMain.java src/module-info.java
   ```

2. **Run the application**:
   Execute the main class with the JDBC driver jar in the classpath:
   ```powershell
   java -cp "bin;E:/mysql-connector-j-9.7.0/mysql-connector-j-9.7.0/mysql-connector-j-9.7.0.jar" com.student.main.StudentMain
   ```

### Running in Eclipse IDE
1. Open Eclipse and click **File > Import...**
2. Choose **General > Existing Projects into Workspace** and click Next.
3. Browse and select the Root directory: `d:\Users\dell\eclipse-workspace\StudentManagementSystemjava`.
4. Ensure the project is checked and click **Finish**.
5. To configure the Database Driver jar:
   - Right-click the project name in Package Explorer -> **Build Path > Configure Build Path...**
   - Under the **Libraries** tab, select **Classpath** and click **Add External JARs...**
   - Locate and select your MySQL Connector jar: `E:\mysql-connector-j-9.7.0\mysql-connector-j-9.7.0\mysql-connector-j-9.7.0.jar`
   - Click **Apply and Close**.
6. Open `src/com/student/main/StudentMain.java`, right-click inside the file, and choose **Run As > Java Application**.
