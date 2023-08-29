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
ADD    menum  number;
commit;


























