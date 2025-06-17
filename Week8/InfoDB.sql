CREATE DATABASE InfoDB;

USE InfoDB;

CREATE TABLE Departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department_id INT,
    age INT CHECK (age >= 18),
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

CREATE TABLE Courses (
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

CREATE TABLE Enrollments (
    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

INSERT INTO Departments (department_name) VALUES
('IT'),
('CSE'),
('ECE');

INSERT INTO Students (name, email, department_id, age) VALUES
('Abi R', 'abi_2384@gmail.in', 2, 19),
('Bindhu M', 'bind@yahoo.com', 1, 20),
('Charlie K', 'charlie@yahoo.com', 3, 20),
('Dharshan M', 'dharshan216@gmail.com', 2, 19),
('Harish N', 'harishnandha@gmail.in', 3, 21);

INSERT INTO Courses (course_name, department_id) VALUES
('Database Management Systems', 1),
('Operating Systems', 2),
('Introduction to Microcontrollers', 3),
('Design and Analysis of Algorithms', 1);

INSERT INTO Enrollments (student_id, course_id, enrollment_date) VALUES
(1, 1, '2025-06-10'),
(2, 2, '2025-06-12'),
(3, 1, '2025-06-11'),
(3, 4, '2025-06-11'),
(5, 2, '2025-06-12');

SELECT s.student_id, s.name, s.email, d.department_name FROM Students s 
INNER JOIN Departments d ON s.department_id = d.department_id;

SELECT c.course_id, c.course_name, d.department_name FROM Courses c
INNER JOIN Departments d ON c.department_id = d.department_id;

SELECT s.name AS student_name, c.course_name FROM Enrollments e
JOIN Students s ON e.student_id = s.student_id
JOIN Courses c ON e.course_id = c.course_id;

SELECT s.name AS student_name, c.course_name FROM Students s
LEFT JOIN Enrollments e ON s.student_id = e.student_id
LEFT JOIN Courses c ON e.course_id = c.course_id;

UPDATE Students SET email = 'bindhumadhan27@gmail.com'
WHERE student_id = 2;

DELETE FROM Students WHERE student_id = 4;