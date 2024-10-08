DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(30) NOT NULL UNIQUE,
    USER_PWD VARCHAR2(30) NOT NULL,
    USER_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    AGE NUMBER,
    EMAIL VARCHAR2(20),
    PHONE CHAR(13),
    ADDRESS VARCHAR2(30),
    HOBBY VARCHAR2(20),
    ENROLL_DATE DATE
);
CREATE SEQUENCE SEQ_USERNO;
ALTER TABLE MEMBER RENAME COLUMN UESR_ID TO USER_ID; 
ALTER TABLE MEMBER MODIFY GENDER VARCHAR2(5);
SELECT * FROM MEMBER;
