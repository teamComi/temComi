select *
from (select rownum rnum, PA_NUM, ME_NUM, PA_TIME, PA_TOTAL_AMOUNT,
           PA_DEPOSIT, PA_PER_AMOUNT, PA_TITLE, PA_CON, PA_ENROLL, 
           PA_MOD_DATE, PA_DEL_DATE, PA_ACT, PA_VIEWS, PA_LIKE, 
           PA_COM_COUNT, PA_GENDER_SET, PA_LOCATION, PA_TOTAL_NUM, 
           PA_GENDER_LIMIT, PH_NUM, CAT_NUM
     from (select * from party
           order by PA_ENROLL desc))
where rnum >= 1 and rnum <= 10;





















