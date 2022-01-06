package DynamicProxy.Aspect.AspectMethod

import DynamicProxy.Aspect.model.User
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import java.util.*


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */
@Component("myAspect")
@Aspect
class MyAspect {
    /**
     * 定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     * 1.公共方法 public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法可以有参数，也可以没有参数。
     *   如果有参数，参数不是自定义的，有几个参数类型可以使用。
     */


    /**
     * 定义方法，方法是实现切面功能的。
     * 方法的定义要求：
     * 1.公共方法 public
     * 2.方法没有返回值
     * 3.方法名称自定义
     * 4.方法可以有参数，也可以没有参数。
     * 如果有参数，参数不是自定义的，有几个参数类型可以使用。
     */
    /**
     * @Before: 前置通知注解
     * 属性：value ，是切入点表达式，表示切面的功能执行的位置。
     * 位置：在方法的上面
     * 特点：
     * 1.在目标方法之前先执行的
     * 2.不会改变目标方法的执行结果
     * 3.不会影响目标方法的执行。
     */
    @Before(value = "execution(void DynamicProxy.Aspect.Service.SomeServiceImpl.doSome(..))")
    fun doSomeBefore() {
        println("-=前置通知， 切面功能：在目标方法之前输出执行时间：" + Date())
    }

    /**
     * 指定通知方法中的参数 ： JoinPoint
     * JoinPoint:业务方法，要加入切面功能的业务方法
     *    作用是：可以在通知方法中获取方法执行时的信息， 例如方法名称，方法的实参。
     *    如果你的切面功能中需要用到方法的信息，就加入JoinPoint.
     *    这个JoinPoint参数的值是由框架赋予， 必须是第一个位置的参数
     */

    @Before(value = "execution(void DynamicProxy.Aspect.Service.SomeServiceImpl.doSome(..))")
    //JoinPoint 参数第一
    fun doSomeBefore2(jp: JoinPoint) {
        println("--前置通知， 切面功能：在目标方法之前输出执行时间：" + Date())
        println("--前置通知 方法签名：${jp.signature}")
        println("--前置通知 方法名称：${jp.signature.name}")
        jp.args.forEach { it -> println("--前置通知 参数名称：$it") }


    }

    /**
     * 最后总会被执行 ，一般用来 资源清除
     */
    //defer
    @After(value = "execution(void DynamicProxy.Aspect.Service.SomeServiceImpl.doOther(..))")
    fun doSomeAfter() {
        println("===最终通知 总是会被执行")
    }

    @AfterReturning(
        value = "execution(String DynamicProxy.Aspect.Service.SomeServiceImpl.doOther(..))",
        returning = "res"
    )
    fun doSomeAfterReturning(res: Any) {
        // Object res:是目标方法执行后的返回值，根据返回值做你的切面的功能处理

        println("AfterReturning res : $res")
        println("===后置处理 AfterReturning --doSome 结束===")
//        Val cannot be reassigned
    }

    @AfterReturning(
        value = "execution(DynamicProxy.Aspect.model.User  DynamicProxy.Aspect.Service.SomeServiceImpl.doUser(..))",
        returning = "res"
    )
    fun doUserAfterReturning(res: Any) {
        // Object res:是目标方法执行后的返回值，根据返回值做你的切面的功能处理
        println("===AfterReturning res : $res")
        User("S", 1) as User
    }


}