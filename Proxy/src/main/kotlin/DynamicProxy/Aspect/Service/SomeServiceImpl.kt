package DynamicProxy.Aspect.Service

import org.springframework.stereotype.Component

//通过spring创建对象
@Component("someService")
class SomeServiceImpl : SomeService {
    open override fun doSome(name: String, age: Int) {
        //之前输出时间
        println(" -----目标doSome---- ")
        println("$name : $age")

    }
}