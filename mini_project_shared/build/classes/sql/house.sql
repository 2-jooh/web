DROP TABLE house;
CREATE TABLE house
(
	id varchar2(10) primary key,
	pattern number(5) NOT NULL,
	location varchar2(50) NOT NULL,
	name varchar2(50) NOT NULL,
	price number(20) NOT NULL
);