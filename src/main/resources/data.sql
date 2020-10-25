DROP TABLE IF EXISTS STUDENT;

CREATE TABLE STUDENT (
    student_id int AUTO_INCREMENT primary key ,
    student_name varchar not null
);

INSERT INTO STUDENT (student_id, student_name)
VALUES
       (1, 'James'),
       (2, 'Maria'),
       (3, 'Anna');