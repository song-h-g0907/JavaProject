--SELECT * FROM ALL_USERS;


/*  ���� ���� ���
    CREATE USER �����̸� IDENTIFIED BY ��й�ȣ;
    
    GRANT ���� TO ������;
*/

CREATE USER KH IDENTIFIED BY KH;


CREATE USER SONG IDENTIFIED BY SONG;
-- KH������ �ּ����� ������ �ο�(����, �����Ͱ���)
GRANT CONNECT, RESOURCE TO KH;
GRANT CONNECT, RESOURCE TO SONG;