create database Mybatis;

use Mybatis;
create table m_user
(
    id   int primary key,
    name varchar(10) default '',
    pwd  varchar(10) default ''
);
insert into m_user
values (1, 'dd', 'sd');


insert into m_user
values (4, 'a', 's2d');

SELECT *
FROM Mybatis.m_user
order by id;


SELECT *
FROM Mybatis.m_user
order by name;

SELECT *
FROM Mybatis.m_user
where id in (0, 1, 2);


SELECT count(*)
FROM Mybatis.m_user

