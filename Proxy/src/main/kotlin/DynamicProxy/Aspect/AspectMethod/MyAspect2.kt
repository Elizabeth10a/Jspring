package DynamicProxy.Aspect.AspectMethod

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component


/*-*- coding:utf-8 -*-
 * @Author  : lubu
 * @Time    : 1/6/22
 * @Software: IntelliJ IDEA
 */
@Component("myAspect2")
@Aspect
class MyAspects2 {
    /**
     * 环绕通知方法的定义格式
     *  1.public
     *  2.必须有一个返回值，推荐使用Object
     *  3.方法名称自定义
     *  4.方法有参数，固定的参数 ProceedingJoinPoint
     */

    /**
     * @Around: 环绕通知
     *    属性：value 切入点表达式
     *    位置：在方法的定义什么
     * 特点：
     *   1.它是功能最强的通知
     *   2.在目标方法的前和后都能增强功能。
     *   3.控制目标方法是否被调用执行
     *   4.修改原来的目标方法的执行结果。 影响最后的调用结果
     *
     *  环绕通知，等同于jdk动态代理的，InvocationHandler接口
     *
     *  参数：  ProceedingJoinPoint 就等同于 Method
     *         作用：执行目标方法的
     *  返回值： 就是目标方法的执行结果，可以被修改。
     *
     *  环绕通知： 经常做事务， 在目标方法之前开启事务，执行目标方法， 在目标方法之后提交事务
     */
    @Around(
        value = "execution(DynamicProxy.Aspect.model.User  DynamicProxy.Aspect.Service.SomeServiceImpl.doAround(..))",
    )
    fun doUserAround(pjp: ProceedingJoinPoint): Any {
        println("===环绕通知 目标方法之前 --doUserAround 结束===")
        var res = pjp.proceed()//method.invoke 可以更改位置以及 条件判断是否执行
        println("===环绕通知 目标方法之后 --doUserAround 结束===")
        return res //影响最终返回值

    }

    /**
     * @AfterThrowing:异常通知
     * 属性：1. value 切入点表达式
     * 2. throwinng 自定义的变量，表示目标方法抛出的异常对象。
     *   变量名必须和方法的参数名一样
     * 特点：
     *   1. 在目标方法抛出异常时执行的
     *   2. 可以做异常的监控程序， 监控目标方法执行时是不是有异常。
     *         如果有异常，可以发送邮件，短信进行通知
     *
     * 执行就是：
     * try{
     *      SomeServiceImpl.doSecond(..)
     * }catch(Exception e){
     *          myAfterThrowing(e);
     *                          }
     */
    @AfterThrowing(
        value = "execution(* DynamicProxy.Aspect.Service.SomeServiceImpl.doAfterThrowing(..))",
        throwing = "ex"
    )
    fun doAfterThrowing(ex: Exception) {
        println("===异常通知：方法发生异常时，执行：" + ex.message)
        //发送邮件，短信，通知开发人员
    }
}