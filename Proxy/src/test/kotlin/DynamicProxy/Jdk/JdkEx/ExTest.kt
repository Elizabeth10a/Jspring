package DynamicProxy.Jdk.JdkEx

import DynamicProxy.Jdk.JdkEx.handler.MyIndicationHandler
import DynamicProxy.Jdk.JdkEx.service.SomeService
import DynamicProxy.Jdk.JdkEx.service.impl.SomeServiceImpl
import org.junit.jupiter.api.Test
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy


class ExTest {


    @Test
    fun useJdkProxy() {
        val target: SomeService = SomeServiceImpl()
        //创建InvocationHandler对象
        val handler: InvocationHandler = MyIndicationHandler(target)
        //使用Proxy创建代理
        val proxy = Proxy.newProxyInstance(
            target.javaClass.classLoader,
            target.javaClass.interfaces, handler
        ) as SomeService
        println("proxy======" + proxy.javaClass.name)
        //通过代理执行方法，会调用handler中的invoke（）
        //通过代理执行方法，会调用handler中的invoke（）
        proxy.doSome()
        println("==================================================")
//        proxy.doOther()
    }


    @Test
    fun useProxy3() {


    }
}