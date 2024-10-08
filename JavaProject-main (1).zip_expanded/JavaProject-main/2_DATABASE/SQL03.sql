--1.
SELECT STUDENT_NAME AS "학생이름",STUDENT_ADDRESS AS "주소지"
FROM TB_STUDENT
ORDER BY STUDENT_NAME;

--2.
SELECT STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN ='Y'
ORDER BY STUDENT_SSN DESC;

--3.
SELECT STUDENT_NAME,STUDENT_NO,STUDENT_ADDRESS
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_ADDRESS,1,3) IN ('경기도','강원도') AND EXTRACT(YEAR FROM ENTRANCE_DATE)<2000
ORDER BY STUDENT_NAME;

--4.
SELECT PROFESSOR_NAME,PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME = '법학과')
ORDER BY PROFESSOR_SSN;

--5.
SELECT STUDENT_NO,POINT
FROM TB_GRADE
LEFT JOIN TB_STUDENT USING(STUDENT_NO)
WHERE TERM_NO='200402' AND CLASS_NO='C3118100'
ORDER BY POINT DESC,STUDENT_NO ASC;

--6.
SELECT STUDENT_NO,STUDENT_NAME, DEPARTMENT_NAME
FROM TB_STUDENT
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
ORDER BY STUDENT_NAME ASC;

--7.
SELECT CLASS_NAME,DEPARTMENT_NAME
FROM TB_CLASS
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO);

--8.
SELECT CLASS_NAME,PROFESSOR_NAME
FROM TB_CLASS
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO);

--9.
SELECT CLASS_NAME,PROFESSOR_NAME
FROM TB_CLASS
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR P USING(PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON P.DEPARTMENT_NO=D.DEPARTMENT_NO
WHERE CATEGORY='인문사회';

--10.
SELECT STUDENT_NO,STUDENT_NAME,ROUND(AVG(POINT),1)
FROM TB_GRADE
LEFT JOIN TB_STUDENT USING(STUDENT_NO)
WHERE DEPARTMENT_NO=(SELECT DEPARTMENT_NO
                      FROM TB_DEPARTMENT
                      WHERE DEPARTMENT_NAME = '음악학과')
GROUP BY STUDENT_NO,STUDENT_NAME;

--11.
SELECT DEPARTMENT_NAME,STUDENT_NAME,PROFESSOR_NAME
FROM TB_STUDENT S
LEFT JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
LEFT JOIN TB_DEPARTMENT D ON(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE STUDENT_NO='A313047';

--12.
SELECT STUDENT_NAME,TERM_NO AS "TERM_NAME"
FROM TB_GRADE G
LEFT JOIN TB_CLASS C USING(CLASS_NO)
JOIN TB_STUDENT S USING(STUDENT_NO)
WHERE SUBSTR(TERM_NO,1,4)='2007' AND CLASS_NAME = '인간관계론';

--13.
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
LEFT JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE CLASS_NO IN (SELECT CLASS_NO
                  FROM TB_CLASS
                  LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
                  WHERE PROFESSOR_NO IS NULL)
     AND CATEGORY = '예체능';
     
--14.
SELECT STUDENT_NAME AS "학생이름",NVL(PROFESSOR_NAME,'지도교수 미지정')AS "지도교수" 
FROM TB_STUDENT S
LEFT JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO)
WHERE S.DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_DEPARTMENT
                       WHERE DEPARTMENT_NAME = '서반아어학과')