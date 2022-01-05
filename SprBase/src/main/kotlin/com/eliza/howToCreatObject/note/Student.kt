package com.eliza.howToCreatObject.note

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import javax.annotation.Resource


/**
 * @Component: 创建对象的， 等同于<bean>的功能
 *     属性：value 就是对象的名称，也就是bean的id值，
 *          value的值是唯一的，创建的对象在整个spring容器中就一个
 *     位置：在类的上面
 *
 *  @Component(value = "myStudent")等同于
 *   <bean id="myStudent" class="com.bjpowernode.ba01.Student" />
 *
 *  spring中和@Component功能一致，创建对象的注解还有：
 *  1.@Repository（用在持久层类的上面） : 放在dao的实现类上面，
 *               表示创建dao对象，dao对象是能访问数据库的。
 *  2.@Service(用在业务层类的上面)：放在service的实现类上面，
 *              创建service对象，service对象是做业务处理，可以有事务等功能的。
 *  3.@Controller(用在控制器的上面)：放在控制器（处理器）类的上面，创建控制器对象的，
 *              控制器对象，能够接受用户提交的参数，显示请求的处理结果。
 *  以上三个注解的使用语法和@Component一样的。 都能创建对象，但是这三个注解还有额外的功能。
 *  @Repository，@Service，@Controller是给项目的对象分层的。
 *
 *
 */

//省略value
//@Component("myStudent")

//不指定对象名称，由spring提供默认名称: 类名的首字母小写
@Component("student")
class Student {
    var name: String = ""

    /*
    @Value
    * 简单类型赋值:
    *   1 ,属性定义上面,无需set
        2, set 方法上面
     */
    @Value("12")
    private var age: Int = 0

    /**
     * 引用类型
     * @Autowired: spring框架提供的注解，实现引用类型的赋值。
     * spring中通过注解给引用类型赋值，使用的是自动注入原理 ，支持byName, byType

     *  默认byType,首先要有 Desk 的对象, 配置文件中写 <bean> 也行
     *  位置：1）在属性定义的上面，无需set方法， 推荐使用
     *       2）在set方法的上面
     */
/*
    @Autowired
     *   属性：required ，是一个boolean类型的，默认true
     *       required = true：表示引用类型赋值失败，程序报错，并终止执行。
     *       required = false：引用类型如果赋值失败， 程序正常执行，引用类型是null
*/
    /*
    * byName
       *  1.在属性上面加入@Autowired
       *  2.在属性上面加入@Qualifier(value="bean的id") ：表示使用指定名称的bean完成赋值。
  */
    @Autowired(required = true)
    @Qualifier("desk")//byName  指定名称的对象
    lateinit var desk: Desk

    /**
     * 引用类型
     * @Resource: 来自jdk中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
     *            使用的也是自动注入原理，支持byName， byType .默认是byName
     *  位置： 1.在属性定义的上面，无需set方法，推荐使用。
     *        2.在set方法的上面
     */
    /*
    * byName -> byType
    * */
    @Resource(name = "homeWork")//指定使用 byName
    lateinit var homeWork: HomeWork


    constructor() {
        println("student 无参构造")
    }

    constructor(name: String, age: Int) {
        println("student name  age")
        this.name = name
        this.age = age
    }

    constructor(name: String, age: Int, desk: Desk) {
        println("student name  age desk")

        this.name = name
        this.age = age
        this.desk = desk
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age, desk=$desk, homeWork=$homeWork)"
    }


}