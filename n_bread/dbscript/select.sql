select *
from (select rownum rnum, PA_NUM, ME_NUM, PA_TIME, PA_TOTAL_AMOUNT,
           PA_DEPOSIT, PA_PER_AMOUNT, PA_TITLE, PA_CON, PA_ENROLL, 
           PA_MOD_DATE, PA_DEL_DATE, PA_ACT, PA_VIEWS, PA_LIKE, 
           PA_COM_COUNT, PA_GENDER_SET, PA_LOCATION, PA_TOTAL_NUM, 
           PA_GENDER_LIMIT, PH_NUM, CAT_NUM
     from (select * from party
           order by PA_ENROLL desc))
where rnum >= 1 and rnum <= 10;



select *
from (select rownum rnum, COM_NUM, PA_NUM, COM_PARENT, COM_DEPTH,
           COM_CON, COM_VIEWS, COM_COUNT, COM_ENROLL, COM_MOD_DATE, 
           COM_DEL_DATE, COM_PHOTO_NUM
     from (select * from comments where PA_NUM = ?
           order by COM_NUM desc, COM_DEPTH desc))
where rnum >= 1 and rnum <= 10;

alter TABLE comments
ADD    com_like  number;

alter TABLE comments
ADD    me_num  number;
commit;

alter table comments
drop column COM_LIKE;

alter table comments
drop column menum;

select max(com_num)
from comments;

select max(com_num) from comments;


insert into comments values 
((select max(com_num) from comments) + 1, ?, (select max(com_num) from comments) + 1, 
?, ?, ?, ?, sysdate, null, null, null, ?);




-- 댓글 검색 뎁스 1 먼저 10개 검색하고 그에 따른 뎁스 2도 같이 검색
-- 최신순
select *
from comments
left join member using(me_num)
where COM_PARENT in 
(select COM_NUM
from (select rownum rnum, COM_NUM, PA_NUM, COM_PARENT, COM_DEPTH,
           COM_CON, COM_VIEWS, COM_COUNT, COM_ENROLL, COM_MOD_DATE, 
           COM_DEL_DATE, COM_PHOTO_NUM
     from (select * from comments where PA_NUM = 1 and COM_DEPTH = 1
           order by COM_PARENT desc, COM_DEPTH asc, COM_NUM desc)
        
    )
where rnum >= 1 and rnum <= 10)
order by COM_PARENT desc, COM_DEPTH asc, COM_NUM desc;

-- 댓글순
select *
from comments
left join member using(me_num)
where COM_NUM in (
    select COM_NUM
    from(select COM_NUM
        from comments
        where COM_PARENT in 
        (select COM_NUM
        from (select rownum rnum, COM_NUM, PA_NUM, COM_PARENT, COM_DEPTH,
                   COM_CON, COM_VIEWS, COM_COUNT, COM_ENROLL, COM_MOD_DATE, 
                   COM_DEL_DATE, COM_PHOTO_NUM
             from (select * from comments where PA_NUM = 1 and COM_DEPTH = 1
                   order by COM_COUNT desc, COM_PARENT desc, COM_NUM desc)
              )
        where rnum >= 1 and rnum <= 10
        )
    )
)
order by COM_PARENT desc, COM_DEPTH asc, COM_NUM desc;


--공감순
select *
from comments
left join member using(me_num)
where COM_NUM in (
    select COM_NUM
    from(select COM_NUM
        from comments
        where COM_PARENT in 
        (select COM_NUM
        from (select rownum rnum, COM_NUM, PA_NUM, COM_PARENT, COM_DEPTH,
                   COM_CON, COM_VIEWS, COM_COUNT, COM_ENROLL, COM_MOD_DATE, 
                   COM_DEL_DATE, COM_PHOTO_NUM
             from (select * from comments where PA_NUM = 1 and COM_DEPTH = 1
                   order by COM_VIEWS desc, COM_PARENT desc, COM_NUM desc)
              )
        where rnum >= 1 and rnum <= 10
        )
    )
)
order by COM_PARENT desc, COM_DEPTH asc, COM_NUM desc;

update comments set com_views = com_views+1 where COM_NUM = 76;


-- 인서트 순간 댓글의 카운트 올리기
-- 트리거 작성
CREATE OR REPLACE TRIGGER TR_COM_COUNT
AFTER INSERT ON comments
FOR EACH ROW
BEGIN
  UPDATE comments 
  SET COM_COUNT = COM_COUNT + 1
  WHERE COM_NUM = :new.COM_PARENT
  and   :new.com_depth = 2
  and   com_depth = 1;
END;
/
insert into comments 
values(2, 2, 1, 2, '1-1댓글 정말 맛있었어요!', 3, 0, 
sysdate, null, null, 1, null);



insert into payment
values(1, 1, 1, 'Y', 'card', 3000, 0, 10000, 'Y', sysdate, 'N', 'N', 'N');

-- 결제 테이블 저장 순간 파티의 pay_ck가 올라감
CREATE OR REPLACE TRIGGER TR_PA_PAY_CK
AFTER INSERT ON payment
FOR EACH ROW
BEGIN
  UPDATE party 
  SET PA_PAY_CK = PA_PAY_CK + :new.PM_AMOUNT
  WHERE pa_num = :new.pa_num
  and   me_num = :new.me_num;
END;
/

insert into payment
values(1, 1, 1, 'Y', 'card', 3000, 0, 10000, 'Y', sysdate, 'N', 'N', 'N');


-- 검색
select *
from (select rownum rnum, PA_NUM, ME_NUM, PA_TIME, PA_TOTAL_AMOUNT,
           PA_DEPOSIT, PA_PER_AMOUNT, PA_TITLE, PA_CON, PA_ENROLL, 
           PA_MOD_DATE, PA_DEL_DATE, PA_ACT, PA_VIEWS, PA_LIKE, 
           PA_COM_COUNT, PA_GENDER_SET, PA_LOCATION, PA_TOTAL_NUM, 
           PA_GENDER_LIMIT, PH_NUM, CAT_NUM
     from (select * from party
           where PA_TITLE like '%7즐거운 모%'
           or    PA_CON like '%7즐거운 모%'
           or    PA_LOCATION like '%7즐거운 모%'
           or    PA_TIME like '%7즐거운 모%'
           order by PA_ENROLL desc))
where rnum >= 1 and rnum <= 10;

select *
from (select rownum rnum, PA_NUM, ME_NUM, PA_TIME, PA_TOTAL_AMOUNT,
           PA_DEPOSIT, PA_PER_AMOUNT, PA_TITLE, PA_CON, PA_ENROLL, 
           PA_MOD_DATE, PA_DEL_DATE, PA_ACT, PA_VIEWS, PA_LIKE, 
           PA_COM_COUNT, PA_GENDER_SET, PA_LOCATION, PA_TOTAL_NUM, 
           PA_GENDER_LIMIT, PH_NUM, CAT_NUM
     from (select * from party
           where PA_ACT = 'Y' and(
                 PA_TITLE like '%7%'
           or    PA_CON like '%7%'
           or    PA_LOCATION like '%7%'
           or    PA_TIME like '%7%')
           order by PA_ENROLL desc, PA_NUM desc))
where rnum >= 1 and rnum <= 10;


insert into main_category
values (1,'모임',null);
insert into main_category
values (2,'공구',null);
insert into main_category
values (3,'렌탈',null);
insert into main_category
values (4,'게임',null);
insert into main_category
values (5,'OTT',null);
insert into main_category
values (6,'기타',null);




