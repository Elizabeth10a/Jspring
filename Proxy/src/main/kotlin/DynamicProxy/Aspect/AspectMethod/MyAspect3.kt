package DynamicProxy.Aspect.AspectMethod

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */
@Component("myAspect3")
@Aspect
class MyAspects3 {

    /**
     * @Pointcut: 定义和管理切入点， 如果你的项目中有多个切入点表达式是重复的，可以复用的。
     *            可以使用@Pointcut
     *    属性：value 切入点表达式
     *    位置：在自定义的方法上面
     * 特点：
     *   当使用@Pointcut定义在一个方法的上面 ，此时这个方法的名称就是切入点表达式的别名。
     *   其它的通知中，value属性就可以使用这个方法名称，代替切入点表达式了
     */


    @Pointcut(
        value = "execution(String DynamicProxy.Aspect.Service.SomeServiceImpl.doOther(..))",
    )
    fun doPointcut() {
        println("===公有部分 doPointcut ===")
    }


    @Before(value = "doPointcut()")
    fun doOtherBefore() {
        println("===公有部分 doPointcut ===")
    }


}