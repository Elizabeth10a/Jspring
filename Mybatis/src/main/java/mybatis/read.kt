package mybatis

/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 12/21/21
 * @Software: IntelliJ IDEA
 */

/*
*
*
*
 mybatis框架
   一个框架，早期叫做ibatis,  代码在github。
   mybatis是 MyBatis SQL Mapper Framework for Java （sql映射框架）
   1）sql mapper :sql映射
         可以把数据库表中的一行数据  映射为 一个java对象。
	 一行数据可以看做是一个java对象。操作这个对象，就相当于操作表中的数据

   2） Data Access Objects（DAOs） : 数据访问 ， 对数据库执行增删改查。


 mybatis提供了哪些功能：
  1. 提供了创建Connection ,Statement, ResultSet的能力 ，不用开发人员创建这些对象了
  2. 提供了执行sql语句的能力， 不用你执行sql
  3. 提供了循环sql， 把sql的结果转为java对象， List集合的能力
	  while (rs.next()) {
		Student stu = new Student();
		stu.setId(rs.getInt("id"));
		stu.setName(rs.getString("name"));
		stu.setAge(rs.getInt("age"));
		//从数据库取出数据转为 Student 对象，封装到 List 集合
		stuList.add(stu);
	  }
  4.提供了关闭资源的能力，不用你关闭Connection, Statement, ResultSet


 开发人员做的是： 提供sql语句
 最后是： 开发人员提供sql语句--mybatis处理sql---开发人员得到List集合或java对象（表中的数据）

 总结：
  mybatis是一个sql映射框架，提供的数据库的操作能力。增强的JDBC,
  使用mybatis让开发人员集中精神写sql就可以了，不必关心Connection,Statement,ResultSet
  的创建，销毁，sql的执行。

* */
