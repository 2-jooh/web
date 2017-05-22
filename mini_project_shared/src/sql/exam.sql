

drop table member
create table member(  
  member_id varchar2(50) primary key,
  member_password varchar2(50) not null,
  member_name varchar2(50) not null,
  member_phone_number varchar2(50) not null,
  member_email varchar2(50) not null, 
  member_point number(10) not null
)
INSERT INTO member VALUES('jang', '1234', '김장규', '010-1234-1234', 'jang@naver.com', 2000)
INSERT INTO member VALUES('jinwoo', '1111', '이진우', '010-3434-3434', 'jw@naver.com', 2000)
INSERT INTO member VALUES('juhyun', '1212', '이주현', '010-9999-8888', 'juhyun2@naver.com', 2000)
INSERT INTO member VALUES('ljy', '7777', '이진영', '010-4546-8787', 'jinyoung@naver.com', 2000)
INSERT INTO member VALUES('hyung', '3636', '김형주', '010-5555-6666', 'hj@naver.com', 2000)





drop table house
create table house(
 house_id  varchar2(10) primary key,
 house_type varchar2(10) not null,
 house_name varchar2(50) not null,
 house_location varchar2(50) not null,
 house_price number(20) not null
 )
INSERT INTO house VALUES('001', '호텔', '판교호텔', '성남', 80000);
INSERT INTO house VALUES('002', '모텔', '고급모텔', '수원', 30000);
INSERT INTO house VALUES('003', '펜션', '행복펜션', '제주', 80000);
INSERT INTO house VALUES('004', '펜션', '럭키펜션', '강릉', 80000);
INSERT INTO house VALUES('005', '호텔', '예스호텔', '서울', 80000);
INSERT INTO house VALUES('006', '모텔', '행운모텔', '안양', 80000);
INSERT INTO house VALUES('007', '모텔', '동쪽모텔', '동해', 80000);

 





INSERT INTO reservation VALUES(1, '2017-11-01', '2017-11-03', '2017-05-04', 'juhyun', '001');
drop table Reservation
create table Reservation(
   rent_no	 number(8) primary key,
   start_rent_date Date not null,
   end_rent_date Date not null,
   rent_time Date not null,
   member_id varchar2(50) ,
   house_id varchar2(10) ,
  constraint R_member_id_fk foreign key(member_id) references member,
  constraint R_house_id_fk foreign key(house_id) references house
)
create sequence rent_no increment by 1 start with 1;
select rent_no.nextval from dual
drop sequence rent_no;

insert into Reservation values(rent_no.nextval,to_date('20031201', 'yyyy-mm-dd'),to_date('20040101', 'yyyy-mm-dd'),to_date('20050101102030', 'yyyy-mm-dd-hh-mi-ss'),'jang','001');
insert into Reservation values(rent_no.nextval,to_date('20040501', 'yyyy-mm-dd'),to_date('20070301', 'yyyy-mm-dd'),to_date('20030101402030', 'yyyy-mm-dd-hh-mi-ss'),'jinwoo','002');
insert into Reservation values(rent_no.nextval,to_date('20050501', 'yyyy-mm-dd'),to_date('20050801', 'yyyy-mm-dd'),to_date('20040101302030', 'yyyy-mm-dd-hh-mi-ss'),'juhyun','003');
insert into Reservation values(rent_no.nextval,to_date('20040105', 'yyyy-mm-dd'),to_date('20040801', 'yyyy-mm-dd'),to_date('20050101101030', 'yyyy-mm-dd-hh-mi-ss'),'hyung','004');
insert into Reservation values(rent_no.nextval,to_date('20030101', 'yyyy-mm-dd'),to_date('20040601', 'yyyy-mm-dd'),to_date('20040101204030', 'yyyy-mm-dd-hh-mi-ss'),'ljy','005');




drop table Picture
create table picture(
   picture_no number(20) primary key,   
   picture_name varchar2(50) not null,
   house_id varchar2(10),
   constraint P_house_id_fk foreign key(house_id) references house
)
INSERT INTO picture VALUES (1, 'pic1.jpg', '001'); --판교호텔 사진들
INSERT INTO picture VALUES (2, 'pic2.jpg', '001');
INSERT INTO picture VALUES (3, 'pic3.jpg', '001'); 
INSERT INTO picture VALUES (4, 'pic1.jpg', '002'); --고급모텔 사진들 
INSERT INTO picture VALUES (5, 'pic2.jpg', '002');
INSERT INTO picture VALUES (6, 'pic3.jpg', '002');



select *
from member;


delete from member
where member_id='java'



































  