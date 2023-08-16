use test;

-- 員工
CREATE TABLE employee(
    employee_id INT(50) PRIMARY KEY auto_increment,
    employee_name  VARCHAR(50) not null,
    employee_email varchar(50) not null,
    employee_gender int not null,
    employee_department varchar(50) not null,
    employee_birth date not null,
    employee_shows int(50) default 0
);

-- 會員
CREATE TABLE member(
    member_id INT(50) PRIMARY KEY auto_increment,
    member_name VARCHAR(30) not null,
    member_password VARCHAR(30) not null 
);

-- 假資料員工
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('家豪', 'google@gmail.com', 1, '通路部門', '1966-06-06');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('志明', 'google@gmail.com', 1, '電子商務部門', '1977-07-07');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('俊傑', 'google@gmail.com', 1, '資訊部門', '1988-08-08');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('承恩', 'google@gmail.com', 1, '產品暨專案部門', '1999-09-09');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('宥廷', 'google@gmail.com', 1, '技術部門', '1968-01-06');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('淑芬', 'google@gmail.com', 0, '美語部門', '1972-06-22');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('淑惠', 'google@gmail.com', 0, '海外留遊學部門', '1979-05-04');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('美玲', 'google@gmail.com', 0, '學習顧問部門', '1985-05-06');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('詠晴', 'google@gmail.com', 0, '創新教育部門', '1996-10-10');
insert into employee
(employee_name, employee_email, employee_gender, employee_department, employee_birth)
values('詩涵', 'google@gmail.com', 0, '人資部門', '1998-12-12');

-- 會員
insert into member
(member_id, member_name, member_password)
values(1,'admin','123456');