package DynamicProxy.Aspect.AspectMethod

import DynamicProxy.Aspect.Service.CreatObject
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
        val impl = co.useSpring("someService") as SomeServiceImpl
        impl.doSome("lisi", 23)
    }

}