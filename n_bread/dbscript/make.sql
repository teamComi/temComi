-- 카테고리 별 뷰
CREATE OR REPLACE VIEW VIEW_PA_CA_MEET
AS
SELECT *
FROM PARTY
WHERE PA_CATEGORY = '모임'
order by PA_TITLE;

-- 최신 순으로 나열
CREATE OR REPLACE VIEW VIEW_PA_CA_MEET
AS
SELECT *
FROM PARTY
order by PA_ENROLL;