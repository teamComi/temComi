/* 파티 모집 분류 */
CREATE TABLE PARTY (
	PA_NUM NUMBER NOT NULL, /* 파티 번호 */
	ME_NUM NUMBER, /* 회원 넘버 */
	PA_TIME DATE NOT NULL, /* 모임 시간 */
	PA_TOTAL_AMOUNT NUMBER NOT NULL, /* 총 금액 */
	PA_DEPOSIT NUMBER NOT NULL, /* 보증금 */
	PA_PER_AMOUNT NUMBER, /* 1인당 금액 */
	PA_CATEGORY VARCHAR2(1000), /* 카테고리 */
	PA_TITLE VARCHAR2(1000) NOT NULL, /* 게시글 제목 */
	PA_CON VARCHAR2(1000) NOT NULL, /* 게시글 내용 */
	PA_ENROLL DATE NOT NULL, /* 등록일자 */
	PA_MOD_DATE DATE, /* 수정일자 */
	PA_DEL_DATE DATE, /* 삭제일자 */
	PA_ACT CHAR NOT NULL, /* 활성화여부 */
	PA_VIEWS NUMBER, /* 조회수 */
	PA_LIKE NUMBER, /* 좋아요수 */
	PA_COM_COUNT NUMBER, /* 댓글수 */
	PA_GENDER_SET CHAR NOT NULL, /* 성별 권한 설정 */
	PA_LOCATION VARCHAR2(1000), /* 위치정보 */
	PA_TOTAL_NUM NUMBER, /* 파티원 인원 수 */
	PA_GENDER_LIMIT CHAR NOT NULL, /* 성별 제한 */
	PH_NUM NUMBER /* 사진 테이블 번호 */
);

COMMENT ON TABLE PARTY IS '파티 모집 분류';

COMMENT ON COLUMN PARTY.PA_NUM IS '파티 번호';

COMMENT ON COLUMN PARTY.ME_NUM IS '회원 넘버';

COMMENT ON COLUMN PARTY.PA_TIME IS '모임 시간';

COMMENT ON COLUMN PARTY.PA_TOTAL_AMOUNT IS '총 금액';

COMMENT ON COLUMN PARTY.PA_DEPOSIT IS '보증금';

COMMENT ON COLUMN PARTY.PA_PER_AMOUNT IS '1인당 금액';

COMMENT ON COLUMN PARTY.PA_CATEGORY IS '카테고리';

COMMENT ON COLUMN PARTY.PA_TITLE IS '게시글 제목';

COMMENT ON COLUMN PARTY.PA_CON IS '게시글 내용';

COMMENT ON COLUMN PARTY.PA_ENROLL IS '등록일자';

COMMENT ON COLUMN PARTY.PA_MOD_DATE IS '수정일자';

COMMENT ON COLUMN PARTY.PA_DEL_DATE IS '삭제일자';

COMMENT ON COLUMN PARTY.PA_ACT IS '활성화여부';

COMMENT ON COLUMN PARTY.PA_VIEWS IS '조회수';

COMMENT ON COLUMN PARTY.PA_LIKE IS '좋아요수';

COMMENT ON COLUMN PARTY.PA_COM_COUNT IS '댓글수';

COMMENT ON COLUMN PARTY.PA_GENDER_SET IS '성별 권한 설정';

COMMENT ON COLUMN PARTY.PA_LOCATION IS '위치정보';

COMMENT ON COLUMN PARTY.PA_TOTAL_NUM IS '파티원 인원 수';

COMMENT ON COLUMN PARTY.PA_GENDER_LIMIT IS '성별 제한';

COMMENT ON COLUMN PARTY.PH_NUM IS '사진 테이블 번호';

ALTER TABLE PARTY
	ADD
		CONSTRAINT PK_PARTY
		PRIMARY KEY (
			PA_NUM
		);

/* 댓글(채팅, 후기) */
CREATE TABLE COMMENTS (
	COM_NUM NUMBER NOT NULL, /* 댓글 번호 */
	PA_NUM NUMBER, /* 파티 번호 */
	COM_PARENT NUMBER NOT NULL, /* 부모 댓글 번호 */
	COM_DEPTH NUMBER, /* 깊이 */
	COM_CON VARCHAR2(1000) NOT NULL, /* 내용 */
	COM_VIEWS NUMBER, /* 조회수 */
	COM_COUNT NUMBER, /* 댓글수 */
	COM_ENROLL DATE, /* 등록일자 */
	COM_MOD_DATE DATE, /* 수정일자 */
	COM_DEL_DATE DATE, /* 삭제일자 */
	COM_PHOTO_NUM NUMBER /* 사진 테이블 번호 */
);

COMMENT ON TABLE COMMENTS IS '댓글(채팅, 후기)';

COMMENT ON COLUMN COMMENTS.COM_NUM IS '댓글 번호';

COMMENT ON COLUMN COMMENTS.PA_NUM IS '파티 번호';

COMMENT ON COLUMN COMMENTS.COM_PARENT IS '부모 댓글 번호';

COMMENT ON COLUMN COMMENTS.COM_DEPTH IS '깊이';

COMMENT ON COLUMN COMMENTS.COM_CON IS '내용';

COMMENT ON COLUMN COMMENTS.COM_VIEWS IS '조회수';

COMMENT ON COLUMN COMMENTS.COM_COUNT IS '댓글수';

COMMENT ON COLUMN COMMENTS.COM_ENROLL IS '등록일자';

COMMENT ON COLUMN COMMENTS.COM_MOD_DATE IS '수정일자';

COMMENT ON COLUMN COMMENTS.COM_DEL_DATE IS '삭제일자';

COMMENT ON COLUMN COMMENTS.COM_PHOTO_NUM IS '사진 테이블 번호';

ALTER TABLE COMMENTS
	ADD
		CONSTRAINT PK_COMMENTS
		PRIMARY KEY (
			COM_NUM
		);

/* 사진 테이블 */
CREATE TABLE PHOTO (
	PH_NUM NUMBER NOT NULL, /* 사진 테이블 번호 */
	PH1 VARCHAR2(1000), /* 사진정보1 */
	PH2 VARCHAR2(1000), /* 사진정보2 */
	PH3 VARCHAR2(1000), /* 사진정보3 */
	PH4 VARCHAR2(1000), /* 사진정보4 */
	PH5 VARCHAR2(1000) /* 사진정보5 */
);

COMMENT ON TABLE PHOTO IS '사진 테이블';

COMMENT ON COLUMN PHOTO.PH_NUM IS '사진 테이블 번호';

COMMENT ON COLUMN PHOTO.PH1 IS '사진정보1';

COMMENT ON COLUMN PHOTO.PH2 IS '사진정보2';

COMMENT ON COLUMN PHOTO.PH3 IS '사진정보3';

COMMENT ON COLUMN PHOTO.PH4 IS '사진정보4';

COMMENT ON COLUMN PHOTO.PH5 IS '사진정보5';

ALTER TABLE PHOTO
	ADD
		CONSTRAINT PK_PHOTO
		PRIMARY KEY (
			PH_NUM
		);

/* Q&A */
CREATE TABLE QA (
	QA_NUM NUMBER NOT NULL, /* Q&A 번호 */
	ME_NUM NUMBER, /* 회원 넘버 */
	QA_TITLE VARCHAR2(1000) NOT NULL, /* 게시글 제목 */
	QA_PWD VARCHAR2(1000), /* 게시글 비번 */
	QA_CON VARCHAR2(1000) NOT NULL, /* 게시글 내용 */
	QA_CATEGORY VARCHAR2(1000), /* 카테고리 */
	QA_ENROLL DATE NOT NULL, /* 등록일자 */
	QA_MOD_DATE DATE, /* 수정일자 */
	QA_DEL_DATE DATE, /* 삭제일자 */
	QA_VIEWS NUMBER, /* 조회수 */
	QA_COM_COUNT NUMBER, /* 댓글수 */
	QA_ADMIN_NUM NUMBER, /* 답변 운영자 번호 */
	QA_REPORT_CON VARCHAR2(1000) NOT NULL, /* 신고내용 */
	QA_ATT_NUM NUMBER, /* 신고할 회원 넘버 */
	QA_ATT_DATE DATE, /* 신고날짜 */
	QA_PHOTO_NUM NUMBER /* 사진 테이블 번호 */
);

COMMENT ON TABLE QA IS 'Q&A';

COMMENT ON COLUMN QA.QA_NUM IS 'Q&A 번호';

COMMENT ON COLUMN QA.ME_NUM IS '회원 넘버';

COMMENT ON COLUMN QA.QA_TITLE IS '게시글 제목';

COMMENT ON COLUMN QA.QA_PWD IS '게시글 비번';

COMMENT ON COLUMN QA.QA_CON IS '게시글 내용';

COMMENT ON COLUMN QA.QA_CATEGORY IS '카테고리';

COMMENT ON COLUMN QA.QA_ENROLL IS '등록일자';

COMMENT ON COLUMN QA.QA_MOD_DATE IS '수정일자';

COMMENT ON COLUMN QA.QA_DEL_DATE IS '삭제일자';

COMMENT ON COLUMN QA.QA_VIEWS IS '조회수';

COMMENT ON COLUMN QA.QA_COM_COUNT IS '댓글수';

COMMENT ON COLUMN QA.QA_ADMIN_NUM IS '답변 운영자 번호';

COMMENT ON COLUMN QA.QA_REPORT_CON IS '신고내용';

COMMENT ON COLUMN QA.QA_ATT_NUM IS '신고할 회원 넘버';

COMMENT ON COLUMN QA.QA_ATT_DATE IS '신고날짜';

COMMENT ON COLUMN QA.QA_PHOTO_NUM IS '사진 테이블 번호';

ALTER TABLE QA
	ADD
		CONSTRAINT PK_QA
		PRIMARY KEY (
			QA_NUM
		);

/* Q&A 댓글 */
CREATE TABLE QACOMMENTS (
	QA_COM_NUM NUMBER NOT NULL, /* Q&A 댓글 번호 */
	QA_NUM NUMBER, /* Q&A 번호 */
	QA_COM_MEM_NUM NUMBER, /* 회원 넘버 */
	QA_COM_PARENT NUMBER NOT NULL, /* 부모 댓글 번호 */
	QA_COM_DEPTH NUMBER, /* 깊이 */
	QA_COM_CON VARCHAR2(450) NOT NULL, /* 내용 */
	QA_COM_VIEWS NUMBER, /* 조회수 */
	QA_COM_COUNT NUMBER, /* 댓글수 */
	QA_COM_ENROLL DATE, /* 등록일자 */
	QA_COM_MOD_DATE DATE, /* 수정일자 */
	QA_COM_DEL_DATE DATE /* 삭제일자 */
);

COMMENT ON TABLE QACOMMENTS IS 'Q&A 댓글';

COMMENT ON COLUMN QACOMMENTS.QA_COM_NUM IS 'Q&A 댓글 번호';

COMMENT ON COLUMN QACOMMENTS.QA_NUM IS 'Q&A 번호';

COMMENT ON COLUMN QACOMMENTS.QA_COM_MEM_NUM IS '회원 넘버';

COMMENT ON COLUMN QACOMMENTS.QA_COM_PARENT IS '부모 댓글 번호';

COMMENT ON COLUMN QACOMMENTS.QA_COM_DEPTH IS '깊이';

COMMENT ON COLUMN QACOMMENTS.QA_COM_CON IS '내용';

COMMENT ON COLUMN QACOMMENTS.QA_COM_VIEWS IS '조회수';

COMMENT ON COLUMN QACOMMENTS.QA_COM_COUNT IS '댓글수';

COMMENT ON COLUMN QACOMMENTS.QA_COM_ENROLL IS '등록일자';

COMMENT ON COLUMN QACOMMENTS.QA_COM_MOD_DATE IS '수정일자';

COMMENT ON COLUMN QACOMMENTS.QA_COM_DEL_DATE IS '삭제일자';

ALTER TABLE QACOMMENTS
	ADD
		CONSTRAINT PK_QACOMMENTS
		PRIMARY KEY (
			QA_COM_NUM
		);

/* 회원 */
CREATE TABLE MEMBER (
	ME_NUM NUMBER NOT NULL, /* 회원 넘버 */
	ME_NAME VARCHAR2(20) NOT NULL, /* 이름 */
	ME_ID VARCHAR2(15) NOT NULL, /* 아이디 */
	ME_PWD VARCHAR2(20) NOT NULL, /* 비번 */
	ME_C_PWD NUMBER, /* 비번 입력 카운트 */
	ME_CER CHAR, /* 인증유무 */
	ME_LOGIN_TYPE CHAR, /* 간편회원유무 */
	ME_EMAIL VARCHAR2(40), /* 이메일 */
	ME_PHONE CHAR(13), /* 핸드폰 */
	ME_ADD VARCHAR2(80), /* 주소 */
	ME_GENDER CHAR NOT NULL, /* 성별 */
	ME_B_DAY DATE, /* 생일 */
	ME_ENROLL DATE NOT NULL, /* 가입일 */
	ME_AKA VARCHAR2(15), /* 닉네임 */
	ME_LIKE NUMBER, /* 인기도 */
	ME_PHOTO_ADD VARCHAR2(100), /* 프로필 사진 */
	ME_ADMIN CHAR, /* 관리자 권한 */
	ME_BAN CHAR, /* 정지 여부 */
	ME_POINT NUMBER, /* 포인트 */
	ME_FIR_CATEGORY VARCHAR2(20), /* 대분류 */
	ME_SEC_CATEGORY VARCHAR2(20) /* 소분류 */
);

COMMENT ON TABLE MEMBER IS '회원';

COMMENT ON COLUMN MEMBER.ME_NUM IS '회원 넘버';

COMMENT ON COLUMN MEMBER.ME_NAME IS '이름';

COMMENT ON COLUMN MEMBER.ME_ID IS '아이디';

COMMENT ON COLUMN MEMBER.ME_PWD IS '비번';

COMMENT ON COLUMN MEMBER.ME_C_PWD IS '비번 입력 카운트';

COMMENT ON COLUMN MEMBER.ME_CER IS '인증유무';

COMMENT ON COLUMN MEMBER.ME_LOGIN_TYPE IS '간편회원유무';

COMMENT ON COLUMN MEMBER.ME_EMAIL IS '이메일';

COMMENT ON COLUMN MEMBER.ME_PHONE IS '핸드폰';

COMMENT ON COLUMN MEMBER.ME_ADD IS '주소';

COMMENT ON COLUMN MEMBER.ME_GENDER IS '성별';

COMMENT ON COLUMN MEMBER.ME_B_DAY IS '생일';

COMMENT ON COLUMN MEMBER.ME_ENROLL IS '가입일';

COMMENT ON COLUMN MEMBER.ME_AKA IS '닉네임';

COMMENT ON COLUMN MEMBER.ME_LIKE IS '인기도';

COMMENT ON COLUMN MEMBER.ME_PHOTO_ADD IS '프로필 사진';

COMMENT ON COLUMN MEMBER.ME_ADMIN IS '관리자 권한';

COMMENT ON COLUMN MEMBER.ME_BAN IS '정지 여부';

COMMENT ON COLUMN MEMBER.ME_POINT IS '포인트';

COMMENT ON COLUMN MEMBER.ME_FIR_CATEGORY IS '대분류';

COMMENT ON COLUMN MEMBER.ME_SEC_CATEGORY IS '소분류';

ALTER TABLE MEMBER
	ADD
		CONSTRAINT PK_MEMBER
		PRIMARY KEY (
			ME_NUM
		);

/* 팔로잉 */
CREATE TABLE FOLLOWING (
	ME_NUM NUMBER NOT NULL, /* 회원 넘버 */
	BLOCK CHAR, /* 차단여부 */
	ME_NUM2 NUMBER /* 팔로잉 */
);

COMMENT ON TABLE FOLLOWING IS '팔로잉';

COMMENT ON COLUMN FOLLOWING.ME_NUM IS '회원 넘버';

COMMENT ON COLUMN FOLLOWING.BLOCK IS '차단여부';

COMMENT ON COLUMN FOLLOWING.ME_NUM2 IS '팔로잉';

ALTER TABLE FOLLOWING
	ADD
		CONSTRAINT PK_FOLLOWING
		PRIMARY KEY (
			ME_NUM
		);

/* 쪽지 테이블 */
CREATE TABLE NOTE (
	ME_NUM_RE NUMBER NOT NULL, /* 회원 넘버 (받은사람) */
	NO_CON VARCHAR2(1000) NOT NULL, /* 내용 */
	NO_SEN_TIME DATE, /* 보낸시간 */
	NO_CH CHAR, /* 읽음 여부 */
	ME_NUM_SEN NUMBER NOT NULL /* 보낸사람 */
);

COMMENT ON TABLE NOTE IS '쪽지 테이블';

COMMENT ON COLUMN NOTE.ME_NUM_RE IS '회원 넘버 (받은사람)';

COMMENT ON COLUMN NOTE.NO_CON IS '내용';

COMMENT ON COLUMN NOTE.NO_SEN_TIME IS '보낸시간';

COMMENT ON COLUMN NOTE.NO_CH IS '읽음 여부';

COMMENT ON COLUMN NOTE.ME_NUM_SEN IS '보낸사람';

ALTER TABLE NOTE
	ADD
		CONSTRAINT PK_NOTE
		PRIMARY KEY (
			ME_NUM_RE
		);

/* 결제 정보 테이블 */
CREATE TABLE PAYMENT (
	PM_NUM NUMBER NOT NULL, /* 결제 번호 */
	ME_NUM NUMBER NOT NULL, /* 회원 넘버 */
	PA_NUM NUMBER NOT NULL, /* 파티 번호 */
	PM_HOST CHAR NOT NULL, /* 파티장 여부 */
	PM_METHOD VARCHAR2(1000) NOT NULL, /* 결제 수단 */
	PM_AMOUNT NUMBER NOT NULL, /* 결제 금액 */
	PM_CREDITS NUMBER NOT NULL, /* 적립금 사용 금액 */
	PM_TOTAL_AMOUNT NUMBER NOT NULL, /* 총결제 금액 */
	PM_DEPOSIT CHAR NOT NULL, /* 거치금 여부 */
	PM_DATE DATE NOT NULL, /* 결제 날짜 */
	PM_AC_VER VARCHAR2(1000) NOT NULL, /* 계좌인증정보 */
	PM_PH_VER VARCHAR2(1000) NOT NULL /* 휴대폰인증정보 */
);

COMMENT ON TABLE PAYMENT IS '결제 정보 테이블';

COMMENT ON COLUMN PAYMENT.PM_NUM IS '결제 번호';

COMMENT ON COLUMN PAYMENT.ME_NUM IS '회원 넘버';

COMMENT ON COLUMN PAYMENT.PA_NUM IS '파티 번호';

COMMENT ON COLUMN PAYMENT.PM_HOST IS '파티장 여부';

COMMENT ON COLUMN PAYMENT.PM_METHOD IS '결제 수단';

COMMENT ON COLUMN PAYMENT.PM_AMOUNT IS '결제 금액';

COMMENT ON COLUMN PAYMENT.PM_CREDITS IS '적립금 사용 금액';

COMMENT ON COLUMN PAYMENT.PM_TOTAL_AMOUNT IS '총결제 금액';

COMMENT ON COLUMN PAYMENT.PM_DEPOSIT IS '거치금 여부';

COMMENT ON COLUMN PAYMENT.PM_DATE IS '결제 날짜';

COMMENT ON COLUMN PAYMENT.PM_AC_VER IS '계좌인증정보';

COMMENT ON COLUMN PAYMENT.PM_PH_VER IS '휴대폰인증정보';

ALTER TABLE PAYMENT
	ADD
		CONSTRAINT PK_PAYMENT
		PRIMARY KEY (
			PM_NUM,
			ME_NUM,
			PA_NUM
		);

/* 파티원 테이블 */
CREATE TABLE TOTALPARTY (
	PA_NUM NUMBER NOT NULL, /* 파티 번호 */
	PA_MEM1 NUMBER, /* 파티원1 */
	PA_MEM2 NUMBER, /* 파티원2 */
	PA_MEM3 NUMBER, /* 파티원3 */
	PA_MEM4 NUMBER, /* 파티원4 */
	PA_MEM5 NUMBER, /* 파티원5 */
	PA_MEM6 NUMBER, /* 파티원6 */
	PA_MEM7 NUMBER, /* 파티원7 */
	PA_MEM8 NUMBER, /* 파티원8 */
	PA_MEM9 NUMBER, /* 파티원9 */
	PA_MEM10 NUMBER /* 파티원10 */
);

COMMENT ON TABLE TOTALPARTY IS '파티원 테이블';

COMMENT ON COLUMN TOTALPARTY.PA_NUM IS '파티 번호';

COMMENT ON COLUMN TOTALPARTY.PA_MEM1 IS '파티원1';

COMMENT ON COLUMN TOTALPARTY.PA_MEM2 IS '파티원2';

COMMENT ON COLUMN TOTALPARTY.PA_MEM3 IS '파티원3';

COMMENT ON COLUMN TOTALPARTY.PA_MEM4 IS '파티원4';

COMMENT ON COLUMN TOTALPARTY.PA_MEM5 IS '파티원5';

COMMENT ON COLUMN TOTALPARTY.PA_MEM6 IS '파티원6';

COMMENT ON COLUMN TOTALPARTY.PA_MEM7 IS '파티원7';

COMMENT ON COLUMN TOTALPARTY.PA_MEM8 IS '파티원8';

COMMENT ON COLUMN TOTALPARTY.PA_MEM9 IS '파티원9';

COMMENT ON COLUMN TOTALPARTY.PA_MEM10 IS '파티원10';

ALTER TABLE TOTALPARTY
	ADD
		CONSTRAINT PK_TOTALPARTY
		PRIMARY KEY (
			PA_NUM
		);

/* 환불 정보 테이블 */
CREATE TABLE REFUND (
	ME_NUM NUMBER NOT NULL, /* 회원 넘버 */
	PA_NUM NUMBER NOT NULL, /* 파티 번호 */
	PM_NUM NUMBER NOT NULL, /* 결제 번호 */
	RF_NUM NUMBER NOT NULL, /* 환불 정보 번호 */
	RF_AMOUNT NUMBER, /* 환불 금액 */
	RF_STATUS CHAR, /* 환불 처리 상태 */
	RF_RE_DATE DATE, /* 환불 요청 날짜 */
	RF_DATE DATE, /* 환불 처리 날짜 */
	RF_AC_VER VARCHAR2(1000), /* 계좌인증정보 */
	RF_PH_VER VARCHAR2(1000) /* 휴대폰인증정보 */
);

COMMENT ON TABLE REFUND IS '환불 정보 테이블';

COMMENT ON COLUMN REFUND.ME_NUM IS '회원 넘버';

COMMENT ON COLUMN REFUND.PA_NUM IS '파티 번호';

COMMENT ON COLUMN REFUND.PM_NUM IS '결제 번호';

COMMENT ON COLUMN REFUND.RF_NUM IS '환불 정보 번호';

COMMENT ON COLUMN REFUND.RF_AMOUNT IS '환불 금액';

COMMENT ON COLUMN REFUND.RF_STATUS IS '환불 처리 상태';

COMMENT ON COLUMN REFUND.RF_RE_DATE IS '환불 요청 날짜';

COMMENT ON COLUMN REFUND.RF_DATE IS '환불 처리 날짜';

COMMENT ON COLUMN REFUND.RF_AC_VER IS '계좌인증정보';

COMMENT ON COLUMN REFUND.RF_PH_VER IS '휴대폰인증정보';

ALTER TABLE REFUND
	ADD
		CONSTRAINT PK_REFUND
		PRIMARY KEY (
			ME_NUM,
			PA_NUM,
			PM_NUM
		);

/* 댓글 사진 테이블 */
CREATE TABLE COMPHOTO (
	COM_PHOTO_NUM NUMBER NOT NULL, /* 사진 테이블 번호 */
	COM_PH1 VARCHAR2(1000), /* 사진정보1 */
	COM_PH2 VARCHAR2(1000), /* 사진정보2 */
	COM_PH3 VARCHAR2(1000), /* 사진정보3 */
	COM_PH4 VARCHAR2(1000), /* 사진정보4 */
	COM_PH5 VARCHAR2(1000) /* 사진정보5 */
);

COMMENT ON TABLE COMPHOTO IS '댓글 사진 테이블';

COMMENT ON COLUMN COMPHOTO.COM_PHOTO_NUM IS '사진 테이블 번호';

COMMENT ON COLUMN COMPHOTO.COM_PH1 IS '사진정보1';

COMMENT ON COLUMN COMPHOTO.COM_PH2 IS '사진정보2';

COMMENT ON COLUMN COMPHOTO.COM_PH3 IS '사진정보3';

COMMENT ON COLUMN COMPHOTO.COM_PH4 IS '사진정보4';

COMMENT ON COLUMN COMPHOTO.COM_PH5 IS '사진정보5';

ALTER TABLE COMPHOTO
	ADD
		CONSTRAINT PK_COMPHOTO
		PRIMARY KEY (
			COM_PHOTO_NUM
		);

/* Q&A 사진 테이블 */
CREATE TABLE QAPHOTO (
	QA_PHOTO_NUM NUMBER NOT NULL, /* 사진 테이블 번호 */
	QA_PHOTO_PH1 VARCHAR2(1000), /* 사진정보1 */
	QA_PHOTO_PH2 VARCHAR2(1000), /* 사진정보2 */
	QA_PHOTO_PH3 VARCHAR2(1000), /* 사진정보3 */
	QA_PHOTO_PH4 VARCHAR2(1000), /* 사진정보4 */
	QA_PHOTO_PH5 VARCHAR2(1000) /* 사진정보5 */
);

COMMENT ON TABLE QAPHOTO IS 'Q&A 사진 테이블';

COMMENT ON COLUMN QAPHOTO.QA_PHOTO_NUM IS '사진 테이블 번호';

COMMENT ON COLUMN QAPHOTO.QA_PHOTO_PH1 IS '사진정보1';

COMMENT ON COLUMN QAPHOTO.QA_PHOTO_PH2 IS '사진정보2';

COMMENT ON COLUMN QAPHOTO.QA_PHOTO_PH3 IS '사진정보3';

COMMENT ON COLUMN QAPHOTO.QA_PHOTO_PH4 IS '사진정보4';

COMMENT ON COLUMN QAPHOTO.QA_PHOTO_PH5 IS '사진정보5';

ALTER TABLE QAPHOTO
	ADD
		CONSTRAINT PK_QAPHOTO
		PRIMARY KEY (
			QA_PHOTO_NUM
		);

/* 팔로워 */
CREATE TABLE FOLLOWERS (
	ME_NUM NUMBER NOT NULL, /* 회원 넘버 */
	BLOCK CHAR, /* 차단여부 */
	ME_NUM2 NUMBER /* 팔로워 */
);

COMMENT ON TABLE FOLLOWERS IS '팔로워';

COMMENT ON COLUMN FOLLOWERS.ME_NUM IS '회원 넘버';

COMMENT ON COLUMN FOLLOWERS.BLOCK IS '차단여부';

COMMENT ON COLUMN FOLLOWERS.ME_NUM2 IS '팔로워';

ALTER TABLE FOLLOWERS
	ADD
		CONSTRAINT PK_FOLLOWERS
		PRIMARY KEY (
			ME_NUM
		);

/* 종합 신고 테이블 */
CREATE TABLE REPORT (
	RE_NUM NUMBER NOT NULL, /* 종합 신고 테이블 번호 */
	ME_NUM NUMBER, /* 회원 넘버 */
	RE_CATEGORY VARCHAR2(50), /* 카테고리 */
	RE_TABLE_NUMBER NUMBER, /* 테이블 번호 */
	RE_CON VARCHAR2(500) NOT NULL, /* 신고내용 */
	RE_ATT_NUM NUMBER, /* 신고할 회원 넘버 */
	RE_ATT_TIME DATE NOT NULL, /* 신고날짜 */
	RE_ADMIN_NUM NUMBER, /* 신고처리(관리자) */
	RE_PROCE_TIME DATE /* 신고처리 날짜 */
);

COMMENT ON TABLE REPORT IS '종합 신고 테이블';

COMMENT ON COLUMN REPORT.RE_NUM IS '종합 신고 테이블 번호';

COMMENT ON COLUMN REPORT.ME_NUM IS '회원 넘버';

COMMENT ON COLUMN REPORT.RE_CATEGORY IS '카테고리';

COMMENT ON COLUMN REPORT.RE_TABLE_NUMBER IS '테이블 번호';

COMMENT ON COLUMN REPORT.RE_CON IS '신고내용';

COMMENT ON COLUMN REPORT.RE_ATT_NUM IS '신고할 회원 넘버';

COMMENT ON COLUMN REPORT.RE_ATT_TIME IS '신고날짜';

COMMENT ON COLUMN REPORT.RE_ADMIN_NUM IS '신고처리(관리자)';

COMMENT ON COLUMN REPORT.RE_PROCE_TIME IS '신고처리 날짜';

ALTER TABLE REPORT
	ADD
		CONSTRAINT PK_REPORT
		PRIMARY KEY (
			RE_NUM
		);

ALTER TABLE PARTY
	ADD
		CONSTRAINT FK_PHOTO_TO_PARTY
		FOREIGN KEY (
			PH_NUM
		)
		REFERENCES PHOTO (
			PH_NUM
		);

ALTER TABLE PARTY
	ADD
		CONSTRAINT FK_MEMBER_TO_PARTY
		FOREIGN KEY (
			ME_NUM
		)
		REFERENCES MEMBER (
			ME_NUM
		);

ALTER TABLE COMMENTS
	ADD
		CONSTRAINT FK_PARTY_TO_COMMENTS
		FOREIGN KEY (
			PA_NUM
		)
		REFERENCES PARTY (
			PA_NUM
		);

ALTER TABLE COMMENTS
	ADD
		CONSTRAINT FK_COMPHOTO_TO_COMMENTS
		FOREIGN KEY (
			COM_PHOTO_NUM
		)
		REFERENCES COMPHOTO (
			COM_PHOTO_NUM
		);

ALTER TABLE QA
	ADD
		CONSTRAINT FK_QAPHOTO_TO_QA
		FOREIGN KEY (
			QA_PHOTO_NUM
		)
		REFERENCES QAPHOTO (
			QA_PHOTO_NUM
		);

ALTER TABLE QA
	ADD
		CONSTRAINT FK_MEMBER_TO_QA
		FOREIGN KEY (
			ME_NUM
		)
		REFERENCES MEMBER (
			ME_NUM
		);

ALTER TABLE QACOMMENTS
	ADD
		CONSTRAINT FK_QA_TO_QACOMMENTS
		FOREIGN KEY (
			QA_NUM
		)
		REFERENCES QA (
			QA_NUM
		);

ALTER TABLE FOLLOWING
	ADD
		CONSTRAINT FK_MEMBER_TO_FOLLOWING
		FOREIGN KEY (
			ME_NUM
		)
		REFERENCES MEMBER (
			ME_NUM
		);

ALTER TABLE FOLLOWING
	ADD
		CONSTRAINT FK_FOLLOWING_TO_FOLLOWING
		FOREIGN KEY (
			ME_NUM2
		)
		REFERENCES FOLLOWING (
			ME_NUM
		);

ALTER TABLE NOTE
	ADD
		CONSTRAINT FK_MEMBER_TO_NOTE
		FOREIGN KEY (
			ME_NUM_RE
		)
		REFERENCES MEMBER (
			ME_NUM
		);

ALTER TABLE NOTE
	ADD
		CONSTRAINT FK_NOTE_TO_NOTE
		FOREIGN KEY (
			ME_NUM_SEN
		)
		REFERENCES NOTE (
			ME_NUM_RE
		);

ALTER TABLE PAYMENT
	ADD
		CONSTRAINT FK_MEMBER_TO_PAYMENT
		FOREIGN KEY (
			ME_NUM
		)
		REFERENCES MEMBER (
			ME_NUM
		);

ALTER TABLE PAYMENT
	ADD
		CONSTRAINT FK_PARTY_TO_PAYMENT
		FOREIGN KEY (
			PA_NUM
		)
		REFERENCES PARTY (
			PA_NUM
		);

ALTER TABLE TOTALPARTY
	ADD
		CONSTRAINT FK_PARTY_TO_TOTALPARTY
		FOREIGN KEY (
			PA_NUM
		)
		REFERENCES PARTY (
			PA_NUM
		);

ALTER TABLE REFUND
	ADD
		CONSTRAINT FK_PAYMENT_TO_REFUND
		FOREIGN KEY (
			PM_NUM,
			ME_NUM,
			PA_NUM
		)
		REFERENCES PAYMENT (
			PM_NUM,
			ME_NUM,
			PA_NUM
		);

ALTER TABLE FOLLOWERS
	ADD
		CONSTRAINT FK_MEMBER_TO_FOLLOWERS
		FOREIGN KEY (
			ME_NUM
		)
		REFERENCES MEMBER (
			ME_NUM
		);

ALTER TABLE FOLLOWERS
	ADD
		CONSTRAINT FK_FOLLOWERS_TO_FOLLOWERS
		FOREIGN KEY (
			ME_NUM2
		)
		REFERENCES FOLLOWERS (
			ME_NUM
		);

ALTER TABLE REPORT
	ADD
		CONSTRAINT FK_MEMBER_TO_REPORT
		FOREIGN KEY (
			ME_NUM
		)
		REFERENCES MEMBER (
			ME_NUM
		);