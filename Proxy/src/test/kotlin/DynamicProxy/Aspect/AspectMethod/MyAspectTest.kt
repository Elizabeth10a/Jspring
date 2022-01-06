package DynamicProxy.Aspect.AspectMethod

import DynamicProxy.Aspect.Service.NoInterface
import DynamicProxy.Aspect.utils.CreatObject
import DynamicProxy.Aspect.Service.SomeService
import org.junit.jupiter.api.Test

var co = CreatObject()

class MyAspectTest {
    @Test
    fun creatObject() {
        co.getSpringInfo()
    }

    @Test
    fun useSpring() {
        //转成接口
        var implProxy = co.useSpring("someService") as SomeService
//        println(implProxy::class.java.name) //jdk.proxy2.$Proxy22
//        implProxy.doSome("lisi", 23)
        implProxy.doOther("AA", 33)


//        println(implProxy.doAround("as", 54))
//        println(implProxy.doAfterThrowing(4, 2))
//        println(implProxy.doAfterThrowing(4, 0))//发生异常时执行

    }

    @Test
    fun useCglib() {
        //转成接口
        var implProxy = co.useSpring("noInterface") as NoInterface
        implProxy.doSomeThing()
//目标类没有接口，使用cglib动态代理， spring框架会自动应用cglib
//DynamicProxy.Aspect.Service.NoInterface$$EnhancerBySpringCGLIB$$fcd73a38
        println(implProxy.javaClass.name)

//     使用强制使用   cglib   <aop:aspectj-autoproxy proxy-target-class="true"/>

        var implProxy2 = co.useSpring("someService") as SomeService
//        println(implProxy::class.java.name) //jdk.proxy2.$Proxy22
//        implProxy.doSome("lisi", 23)
        implProxy2.doOther("AA", 33)
        println(implProxy.javaClass.name)

    }

}