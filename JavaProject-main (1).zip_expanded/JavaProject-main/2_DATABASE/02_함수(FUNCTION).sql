SELECT EMP_ID, EMP_NAME, SALARY -- 3
FROM EMPLOYEE                   -- 1
WHERE DEPT_CODE IS NOT NULL;    -- 2
-- NULL�� ���� ���� IS NULL �Ǵ� IS NOT NULL�� �ؾ��Ѵ�.

/*
    <ORDER BY��>
    SELECT�� ���� ������ �ٿ� �ۼ�, ����������� ���� �������� �����Ѵ�.
    
    [ǥ����]
    SELECT ��ȸ�� �÷�...
    FROM ��ȸ�� ���̺�
    WHERE ���ǽ�
    ORDER BY ���ı��ص� �÷� | ��Ī | �÷����� [ASC | DESC] [NULLS FIRST | NULLS LAST]
    
    -ASC : ��������(���� ������ �����ؼ� ���� ���� Ŀ���� ��) -> �⺻��
    -DESC : ��������(ū������ �����ؼ� ���� ���� �پ��� ��)
    
    --NULL�� �⺻������ ���� ū������ �з��ؼ� �����Ѵ�.
    --NULLS FIRST : �����ϰ����ϴ� �÷����� NULL�� ���� ��� �ش絥���� �� �տ� ��ġ(DESC�϶� �⺻��)
    --NULLS LAST : �����ϰ����ϳ��� �÷����� NULL�� ���� ��� �ش絥���� �� �������� ��ġ(ASC�϶� �⺻��)
*/

SELECT *
FROM EMPLOYEE
--ORDER BY BONUS; -- �⺻���� ��������
--ORDER BY BONUS DESC; --NULLS FIRST �⺻��
ORDER BY BONUS DESC, SALARY ASC;
--���ı��ؿ� �÷����� ������ ��� �� ���� ������ ���ؼ� �������� ������ �� �ִ�.


--�� ����� �����, ����(���ʽ�����) ��ȸ(�� �� ������ ��������)
SELECT EMP_NAME, SALARY*12 AS "����"
FROM EMPLOYEE
--ORDER BY "����" DESC
ORDER BY 2 DESC; -- �������밡�� ����Ŭ�� ���� 1���� ����

--=================================================================================
/*
    <�Լ� FUNCTION>
    ���޵� �÷����� �޾Ƽ� �Լ��� ������ ����� ��ȯ
    
    -������ �Լ� : N���� ���� �о�鿩�� N���� ������� ����(���ึ�� �Լ����� ����� ��ȯ)
    -�׷��Լ� : N���� ���� �о�鿩�� 1���� ���� ����(�׷��� ��� �׷캰�� �Լ����� ����� ��ȯ)
    
    >> SELECT ���� �������Լ��� �׷��Լ��� �Բ� ������� ����
    -> ��� ���� ������ �ٸ��� ����
    
    >> �Լ��� ����� �� �ִ� ��ġ : SELECT�� WHERE�� ORDER BY�� HAVING��
    
*/

--===============================<������ �Լ�>===================================

/*
    <����ó���Լ�>
    
    *LENGTH(�÷� | '���ڿ�') : �ش� ���ڿ��� ���ڼ��� ��ȯ
    *LENGTHB(�÷� | '���ڿ�') : �ش� ���ڿ��� ����Ʈ ���� ��ȯ
    
    '��' '��' '��' �ѱ��� ���ڴ� 3BYTE
    ������, ����, Ư������ ���ڴ� 1BYTE
*/

SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ')
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME)
FROM EMPLOYEE;

--================================================================

/*
    *INSTR
    ���ڿ��κ��� ���� ������ ������ġ�� ã�Ƽ� ��ȯ
    
    INSTR(�÷� | '���ڿ�', 'ã�����ϴ� ����', ['ã�� ��ġ�� ���۰�, ����']) -> ����� NUMBER
*/
SELECT INSTR('AABAACAABBAA','B') FROM DUAL; --���ʿ� �ִ� ù B�� 3���� ��ġ�� �ִ�.
--ã�� ��ġ ���۰� : 1, ���� 1 => �⺻��
SELECT INSTR('AABAACAABBAA','B',1) FROM DUAL;
SELECT INSTR('AABAACAABBAA','B',-1) FROM DUAL; --�ڿ������� ã�� ��ġ�� ���� ���� �տ������� �о��ش�.
SELECT INSTR('AABAACAABBAA','B',1,2) FROM DUAL; --������ �����Ϸ��� ��ġ�� ���۰��� ǥ���ؾ��Ѵ�.
SELECT INSTR('AABAACAABBAA','B',1,3) FROM DUAL;

SELECT EMAIL, INSTR(EMAIL,'_',1,1), INSTR(EMAIL,'@') FROM EMPLOYEE;

--------------------------------------------------------------------------------

/*
    *SUBSTR
    ���ڿ����� Ư�� ���ڿ��� �����ؼ� ��ȯ
    
    [ǥ����]
    SUBSTR(STRING, POSITION, [LENGTH])
    - STRING : ����Ÿ�� �÷� | '���ڿ�'
    - POSITION : ���ڿ� ������ ������ġ ��
    - LENTH : ������ ���� ����(�����ϸ� ������)
*/

SELECT SUBSTR('SHOWMETHEMONEY', 7 ) FROM DUAL; --7��° ��ġ���� ������ ����
SELECT SUBSTR('SHOWMETHEMONEY', 5,2 ) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 1,6 ) FROM DUAL;--SHOWME
SELECT SUBSTR('SHOWMETHEMONEY', -8,3 ) FROM DUAL;

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO,8,1) AS "����"
FROM EMPLOYEE;

--������� ������鸸 EMP_NAME, EMP_NO ��ȸ
SELECT EMP_NAME,EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1)='2' OR SUBSTR(EMP_NO,8,1)='4'
ORDER BY EMP_NAME;

--�Լ� ��ø��� ����
--�̸����� ���̵�κ� ����
--�����Ͽ��� �����, �̸���, ���̵� ��ȸ
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;

--------------------------------------------------------------------------------
/*
    *LPAD / RPAD
    ���ڿ��� ��ȸ�� �� ���ϰ��ְ� ��ȸ�ϰ��� �� �� ���
    
    [ǥ����]
    LPAD/RPAD(STRING, ���������� ��ȯ�� ���ڿ��� ����, [�����̰����ϴ� ����])
    
    ���ڿ��� �����̰����ϴ� ���ڸ� ���� �Ǵ� �����ʿ� �ٿ��� ���� N���̸�ŭ ���ڿ��� ��ȯ
    
*/
--20��ŭ�� ���� �� EMAIL�÷����� ���������� �����ϰ� ������ �κ��� �������� ä���
SELECT EMP_NAME, LPAD(EMAIL,20)
FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL,20,'#')
FROM EMPLOYEE;

--������� �����, �ֹε�Ϲ�ȣ ��ȸ("701011-1XXXXXX")
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO,1,(INSTR(EMP_NO,'-')+1)),14,'X')
FROM EMPLOYEE;

--------------------------------------------------------------------------------
/*
    *LTRIM/RTRIM
    ���ڿ����� Ư�� ���ڸ� ������ �������� ��ȯ
    LTRIM/RTRIM(STRING, [�����ϰ����ϴ� ���ڵ�])
    
    ���ڿ��� ���� Ȥ�� �����ʿ��� �����ϰ����ϴ� ���ڵ��� ã�Ƽ� ������ ������ ���ڿ� ��ȯ
    
*/
SELECT RTRIM(LTRIM('          K           H        ')) FROM DUAL;
SELECT LTRIM('ACBABCAABCKKH','ABC') FROM DUAL;

/*
    *TRIM
    ���ڿ��� ��/��/���ʿ� �ִ� ������ ���ڵ��� ������ ������ ���ڿ� ��ȯ
    TRIM([LEADING | TRAILING | BOTH] �����ϰ����ϴ� ���ڿ� FROM ���ڿ�)
*/

SELECT TRIM('          K           H        ') FROM DUAL; --���ʿ��ִ� ���� ����
SELECT TRIM('Z' FROM 'ZZZZKHZZZZZZZZZZZZ') FROM DUAL;

SELECT TRIM (LEADING 'Z' FROM 'ZZZZZZZZZZZZKHZZZZZZZZZZZZZZZ') FROM DUAL; --LTRIM
SELECT TRIM (TRAILING 'Z' FROM 'ZZZZZZZZZZZZKHZZZZZZZZZZZZZZZ') FROM DUAL; --RTRIM

--------------------------------------------------------------------------------

/*
    *LOWER / UPPER / INITCAP
    LOWER : �� �ҹ��ڷ� ������ ���ڿ� ��ȯ
    UPPER : �� �빮�ڷ� ������ ���ڿ� ��ȯ
    INITCAP : ���� ���� ù���ڸ��� �빮�ڷ� ������ ���ڿ� ��ȯ
    
*/

SELECT LOWER('Welcome To My KH') FROM DUAL;
SELECT UPPER('Welcome To My KH') FROM DUAL;
SELECT INITCAP('welcome to my kh') FROM DUAL;


--------------------------------------------------------------------------------

/*
    *CONCAT
    ���ڿ� �ΰ� ���޹޾� �ϳ��� ��ģ �� ��ȯ
    CONCAT(STRING1, STRING2)
*/
SELECT CONCAT('������','ABC') FROM DUAL;
SELECT '������' || 'ABC' FROM DUAL;

--------------------------------------------------------------------------------

/*
    *REPLACE
    Ư�����ڿ����� Ư���κ��� �ٸ� �κ����� ��ü
    REPLACE(���ڿ�, ã�� ���ڿ�, �����ҹ��ڿ�)
*/
SELECT EMAIL, REPLACE(EMAIL,'KH.or.kr','gmail.com')
FROM EMPLOYEE;

--------------------------------------------------------------------------------

/*
    <���� ó�� �Լ�>
    
    *ABS
    ������ ���밪�� �����ִ� �Լ�
*/

SELECT ABS(-10), ABS(-6.3) FROM DUAL;

--------------------------------------------------------------------------------

/*
    *MOD
    �� ���� ���� ���������� ��ȯ
    MOD(NUMBER,NUMBER)
*/
SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10.9,3) FROM DUAL;

--------------------------------------------------------------------------------

/*
    *ROUND
    �ݿø��� ����� ��ȯ
    ROUND(NUMBER, [��ġ])
*/
SELECT ROUND(123.456) FROM DUAL; -- �⺻�ڸ����� �Ҽ��� ù��° �ڸ����� �ݿø�
SELECT ROUND(123.456,2) FROM DUAL; -- ����� ������ ���� �Ҽ��� �ڷ� ��ĭ�� �̵�
SELECT ROUND(123.456,-1) FROM DUAL; -- ������ ������ ���� �Ҽ��� ���ڸ��� �̵�

/*
    *CEIL
    �ø�ó���� ���� �Լ�
    
    CEIL(NUMBER)
*/

SELECT CEIL(123.456) FROM DUAL;

/*
    *TRUNC
    ����ó���� ���� �Լ�
    
    TRUNC(NUMBER, [��ġ])
*/

SELECT TRUNC(123.456) FROM DUAL;
SELECT TRUNC(123.456,1) FROM DUAL;
SELECT TRUNC(123.456,-1) FROM DUAL;

-----------------------------����----------------------------------
--�˻��ϰ����ϴ� ����
--JOB_CODE�� J7�̰ų� J6�̸鼭 SALARY���� 200���� �̻��̰�
--BONUS�� �ְ� �����̴�
--�̸�, �ֹε�Ϲ�ȣ, �����ڵ�, �μ��ڵ�, �޿�, ���ʽ��� ��ȸ�ϰ�ʹ�.
SELECT EMP_NAME,EMP_NO,JOB_CODE,DEPT_CODE,SALARY,BONUS
FROM EMPLOYEE
WHERE (JOB_CODE IN('J7','J6')) AND (SALARY>=2000000) AND (BONUS IS NOT NULL) 
        AND (SUBSTR(EMP_NO,8,1) IN ('2','4'));

--------------------------------------------------------------------------------

/*
    <��¥ ó�� �Լ�>
    
*/


-- *SYSDATE : �ý����� ���� ��¥ �� �ð��� ��ȯ
SELECT SYSDATE FROM DUAL;

-- *MONTHS_BETWEEN : �� ��¥ ������ ���� ��
--������� �����, �Ի���, �ٹ��ϼ�, �ٹ�������
SELECT EMP_NAME , HIRE_DATE, FLOOR(SYSDATE - HIRE_DATE), CEIL(MONTHS_BETWEEN(SYSDATE,HIRE_DATE))
FROM EMPLOYEE;

-- *ADD_MONTHS : Ư�� ��¥�� NUMBER�������� ���ؼ� ��ȯ
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL;

--�ٷ��� ���̺��� �����, �Ի���, �Ի��� 3������ ��¥ ��ȸ
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE,3)
FROM EMPLOYEE;

-- *NEXT_DAY(DATE, ����(���� | ����)) : Ư����¥ ���� ���� ����� ������ ��¥�� ��ȯ
SELECT NEXT_DAY(SYSDATE,'�����')FROM DUAL;

-- 1: ��, 7: ��
SELECT NEXT_DAY(SYSDATE,'7')FROM DUAL;


-- *LAST_DAY(DATE) : �ش���� �Ӹ����� ��¥ ���ؼ� ��ȯ
SELECT LAST_DAY(SYSDATE) FROM DUAL;

/*
    *EXTRACT : Ư�� ��¥�κ��� ��|��|�� ���� �����ؼ� ��ȯ�ϴ� �Լ�
    
    [ǥ����]
    E
    EXTRACT(YEAR FROM DATE) : ������ ����
    EXTRACT(MONTH FROM DATE) : ���� ����
    EXTRACT(DAY FROM DATE) : �ϸ� ����
*/

-- ����� �����, �Ի�⵵, �Ի��, �Ի����� ��ȸ
SELECT EMP_NAME, EXTRACT(YEAR FROM HIRE_DATE) AS "�Ի�⵵",EXTRACT(MONTH FROM HIRE_DATE) AS "�Ի��",EXTRACT(DAY FROM HIRE_DATE) AS "�Ի���"
FROM EMPLOYEE
ORDER BY 2, 3, 4;

--------------------------------------------------------------------------------

/*
    [����ȯ �Լ�]
    *TO_CHAR : ����Ÿ�� �Ǵ� ��¥ Ÿ���� ���� ����Ÿ������ ��ȯ�����ִ� �Լ�
    
    [ǥ����]
    TO_CHAR(���� | ����, [����])
    
*/
-- ���� -> ����
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(12, '99999') FROM DUAL; -- 9�� �ڸ�����ŭ ���� Ȯ��, ������ ����
SELECT TO_CHAR(12, '00000') FROM DUAL; -- 0�� �ڸ�����ŭ ���� Ȯ��, ��ĭ�� 0���� ä��
SELECT TO_CHAR(2000000, 'L99999999') FROM DUAL; --���� ������ ������ ���� ȭ����� ��Ÿ��

SELECT TO_CHAR(3500000, 'L9,999,999') FROM DUAL;


--��¥Ÿ�� -> ����Ÿ��
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'PM HH:MI:SS') FROM DUAL; -- AM, PM � ���� ����ϰ� ������ �����ִ� ���̱⿡ �����ϰ� ��Ÿ��
SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY DY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON, YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY"��" MM"��" DD"��" DAY DY') FROM DUAL;

--������� �̸�, �Ի糯¥(0000�� 00�� 00��) ��ȸ
SELECT EMP_NAME,TO_CHAR(HIRE_DATE,'YYYY"��" MM"��" DD"��"') AS �Ի��� FROM EMPLOYEE;

--�⵵�� ���õ� ����
SELECT TO_CHAR(SYSDATE,'YYYY'),
         TO_CHAR(SYSDATE,'YY'),
         TO_CHAR(SYSDATE,'RRRR') --RR���� ���� �����Ѵ� -> 50�� �̻��� +100 
FROM DUAL;


SELECT HIRE_DATE, TO_CHAR(HIRE_DATE,'YY'),TO_CHAR(HIRE_DATE,'RR') FROM EMPLOYEE;

--���� ���õ� ����
SELECT TO_CHAR(SYSDATE,'MM'),TO_CHAR(SYSDATE,'MON'),TO_CHAR(SYSDATE,'MONTH') FROM DUAL;

--�ϰ� ���õ� ����
SELECT TO_CHAR(SYSDATE,'DDD'),  -- ������ �̹��⵵�� ���° �ϼ�
       TO_CHAR(SYSDATE,'DD'),   -- ���� ����
       TO_CHAR(SYSDATE,'D')     -- ���� -> ����
FROM DUAL;

--���ϰ� ���õ� ����
SELECT TO_CHAR(SYSDATE, 'DAY'),
       TO_CHAR(SYSDATE, 'DY')
FROM DUAL;

--------------------------------------------------------------------------------

/*
    TO_DATE : ����Ÿ�� �Ǵ� ����Ÿ���� ��¥Ÿ������ �����ϴ� �Լ�
    
    TO_DATE(���� | ����, [����]) -> DATE
*/

SELECT TO_DATE(20100101) FROM DUAL;
SELECT TO_DATE(240807) FROM DUAL; --50�� �̸��� �ڵ����� 20XX���� ���� 50�� �̻��� 19XX���� �����ȴ�.

SELECT TO_DATE(020505) FROM DUAL;

--------------------------------------------------------------------------------

/*
    TO_NUMBER : ����Ÿ���� �����͸� ����Ÿ������ ��ȯ�����ִ� �Լ�
    
    [ǥ����]
    TO_NUMBER(����, [����])
*/
SELECT TO_NUMBER('05123456789') FROM DUAL;




--------------------------------------------------------------------------------

/*
    [NULL ó�� �Լ�]
    
*/

--* NVL(�÷�, �ش��÷��� NULL�� ��� ������ ��)
SELECT EMP_NAME, NVL(BONUS,0)
FROM EMPLOYEE;

-- �� ����� �̸�, ���ʽ����� ���� ��ȸ
SELECT EMP_NAME, (SALARY + (SALARY *NVL(BONUS, 0)))*12
FROM EMPLOYEE;

-- * NVL2(�÷�, ��ȯ��1, ��ȯ��2)
--��ȯ��1 : �ش� �÷��� ������ ��� ������ ��
--��ȯ��2 : �ش� �÷��� NULL�� ��� ������ ��

SELECT EMP_NAME , BONUS, NVL2(BONUS, 'O','X')
FROM EMPLOYEE;

-- *NULLIF(�񱳴��1, �񱳴��2)
-- �� ���� ��ġ�ϸ� NULL ��ġ���� ������ �񱳴��1 ��ȯ
SELECT NULLIF('123','123') FROM DUAL;
SELECT NULLIF('123','456') FROM DUAL;


--------------------------------------------------------------------------------

/*
    [�����Լ�]
    *DECODE(���ϰ����ϴ� ���(�÷�, �����, �Լ���), �񱳰�1, �����1, �񱳰�2, �����2...)
    
*/

--���, �����, �ֹι�ȣ, ����
SELECT EMP_ID, EMP_NAME, EMP_NO,DECODE(SUBSTR(EMP_NO,8,1),'1','��','2','��','3','��','4','��', '�ܰ���') AS ����
FROM EMPLOYEE;

--������ ����, �����޿�, �λ�� �޿� ��ȸ * �� ���޺��� �λ��ؼ� ��ȸ
--J7�� ����� �޿��� 10%�λ� (SALARY *1.1)
--J6�� ����� �޿��� 15%�λ� (SALARY *1.15)
--J5�� ����� �޿��� 20%�λ� (SALARY *1.2)
--�׿� ������� �޿��� 5%�λ� (SALARY *1.05)

SELECT EMP_NAME, SALARY AS "�λ���", DECODE(JOB_CODE,'J7',(SALARY *1.1),'J6',(SALARY *1.15),'J5',(SALARY *1.2),(SALARY *1.05)) AS �λ���
FROM EMPLOYEE;


/*
    *CASE WHEN THEN
    
    CASE
        WHEN ���ǽ� 1 THEN �����1
        WHEN ���ǽ� 2 THEN �����2
        ...
        ELSE �����
    END
*/

SELECT EMP_NAME, SALARY, CASE WHEN SALARY >= 5000000 THEN '���' WHEN SALARY >= 3500000 THEN '�߱�' ELSE '�ʱ�' END
FROM EMPLOYEE;


--------------------------------------------------------------------------------
-- 1. SUM(����Ÿ���÷�) : �ش��÷� ������ �� �հ踦 ���ؼ� ��ȯ���ִ� �Լ�

--�ٷ������̺��� ������� �� �޿��� ���ض�
SELECT SUM(SALARY)
FROM EMPLOYEE;

--���ڻ������ �� �޿�
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO,8,1) IN ('1','3');

--�μ��ڵ尡 D5�� ������� �� ����(�޿� *12)
SELECT SUM(SALARY*12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';


--2. AVG(NUMBER) : �ش� �÷������� ����� ���ؼ� ��ȯ
SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

--3. MIN(���Ÿ�԰���) : �ش� �÷��� �� ���� ���� ���� ���ؼ� ��ȯ
SELECT MIN(EMP_NAME),MIN(SALARY), MIN(HIRE_DATE)
FROM EMPLOYEE;

--4. MAX(���Ÿ�԰���) : �ش� �÷��� �� ���� ū ���� ���ؼ� ��ȯ
SELECT MAX(EMP_NAME),MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

--5. COUNT(* | �÷� | DISTINCT �÷�) : �ش� ���ǿ� �´� ���� ������ ���� ��ȯ
--COUNT(*) : ��ȸ�� ����� ��� ���� ������ ���� ��ȯ
--COUNT(�÷�) : ������ �ش� �÷����� NULL�� �ƴ� �͸� ���� ���� ���� ��ȯ
--COUNT(DISTINCT �÷�) : �ش� �÷��� �ߺ��� ������ �� ���� ������ ��ȯ

--��ü ��� �� 
SELECT COUNT(*) FROM EMPLOYEE;

SELECT COUNT(*) FROM EMPLOYEE WHERE SUBSTR(EMP_NO,8,1) IN ('2','4');

--���ʽ��� �޴� �����
SELECT COUNT(*)
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

SELECT COUNT(BONUS)
FROM EMPLOYEE;

--���� ������� �� ��� �μ��� �����Ǿ� �ִ����� ���ض�
SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;

