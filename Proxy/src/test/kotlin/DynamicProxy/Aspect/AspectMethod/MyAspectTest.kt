package DynamicProxy.Aspect.AspectMethod

import DynamicProxy.Aspect.Service.CreatObject
import DynamicProxy.Aspect.Service.SomeService
import DynamicProxy.Aspect.Service.SomeServiceImpl
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
        println(implProxy::class.java.name) //jdk.proxy2.$Proxy22
        implProxy.doSome("lisi", 23)
    }

}