/* Select all students from class 2a by knowing id = 2 */
SELECT * FROM cr6.student WHERE classID = 2;
/* Select all students from class 2a while not knowing the id */
SELECT idstudent, student.`name`, surname, email, classID FROM cr6.student INNER JOIN cr6.class ON student.classID = class.idclass && class.name = "2a";