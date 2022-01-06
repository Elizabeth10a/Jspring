package DynamicProxy.Aspect.AspectMethod

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import java.util.*


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */
@Component("myAspects")
@Aspect
class MyAspects {
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
        println("前置通知， 切面功能：在目标方法之前输出执行时间：" + Date())
    }

    @Before(value = "execution(void DynamicProxy.Aspect.Service.SomeServiceImpl.doSome(..))")
    fun doSomeBefore2() {
        println("前置通知2， 切面功能：在目标方法之前输出执行时间：" + Date())
    }
}