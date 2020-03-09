# Restapi-springboot

Project with CRUD operations using Springboot application


# MySQL (query.sql)

CREATE DATABASE stmgdb;
USE stmgdb;

CREATE TABLE userDetail (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(10) NOT NULL,
  email VARCHAR(200) NOT NULL,
  created_on TIMESTAMP,
  created_by VARCHAR(100),
  modified_on TIMESTAMP,
  modified_by VARCHAR(100),
  is_deleted BOOLEAN
);

CREATE TABLE student (
  id INT AUTO_INCREMENT PRIMARY KEY,
  studentNo VARCHAR(10) NOT NULL,
  studentname VARCHAR(50) NOT NULL,
  studyYear INT(2) NOT NULL,
  email VARCHAR(200) NOT NULL,
  address VARCHAR(500),
  phoneNo VARCHAR(13),
  created_on TIMESTAMP,
  created_by VARCHAR(100),
  modified_on TIMESTAMP,
  modified_by VARCHAR(100),
  is_deleted BOOLEAN
);

SET time_zone='+00:00';

INSERT INTO userDetail VALUES
(NULL,'User1','user1@test.com',NOW(),'admin',
NOW(), '', false),
(NULL,'User2','user2@test.com',NOW(),'admin',
NOW(), '', false),
(NULL,'User3','user3@test.com',NOW(),'admin',
NOW(), '', false);

SELECT * FROM userDetail;

INSERT INTO student VALUES
(NULL,'ST20200101','Andy',01,'Andy@test.com','London','+447000000001',NOW(),'admin',
NOW(), '', false),
(NULL,'ST20200102','Cindy',01,'Cindy@test.com','Hatfield','+447000000002',NOW(),'admin',
NOW(), '', false),
(NULL,'ST20200103','Dev',02,'Dev@test.com','Glasgow','+447000000003',NOW(),'admin',
NOW(), '', false);

COMMIT;

SELECT * FROM student;
