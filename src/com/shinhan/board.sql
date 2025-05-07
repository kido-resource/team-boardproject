CREATE TABLE Board (
	board_id	int		NOT NULL,
	title	varchar2(100)		NOT NULL,
	commnet	varchar2(255)		NULL,
	create_date	date		NOT NULL,
	update_date	date		NULL,
	nickname	varchar2(100)		NOT NULL
);

COMMENT ON COLUMN Board.board_id IS '게시글 고유 아이디';

ALTER TABLE Board ADD CONSTRAINT PK_BOARD PRIMARY KEY (
	board_id
);

CREATE SEQUENCE hr.BoardId_seq
	INCREMENT BY 1
	START WITH 1;


INSERT INTO BOARD (NICKNAME, BOARD_ID, TITLE, COMMNET, CREATE_DATE)
VALUES ('hong', BoardId_seq.NEXTVAL, '홍길동', '결국 아버지를 아버지라 부르지 못하였다', SYSDATE);

INSERT INTO BOARD (NICKNAME, BOARD_ID, TITLE, COMMNET, CREATE_DATE)
VALUES ('sung', BoardId_seq.NEXTVAL, '성춘향', '첫만남은 어려워', SYSDATE);


COMMIT;

SELECT BOARD_ID, TITLE, NICKNAME, COMMNET, CREATE_DATE FROM BOARD WHERE BOARD_ID = 21;
SELECT * FROM BOARD