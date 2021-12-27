create database Mybatis;

use Mybatis;
create table m_user
(
    id   int primary key,
    name varchar(10) default '',
    pwd  varchar(10) default ''
);
insert into m_user
values (0, 'a', 'a');

SELECT *
FROM Mybatis.m_user
order by id;

