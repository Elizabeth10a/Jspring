use Mybatis;

# 销售表
create table if not exists sale
(
    id   int primary key auto_increment,
    gid  int not null,
    nums int
);

# 商品表
create table if not exists goods
(
    id     int primary key auto_increment,
    name   varchar(11),
    amount int not null,
    price  float
);

insert into goods value (1, '笔记本', 100, 5000);
insert into goods value (2, '手机', 100, 3000)