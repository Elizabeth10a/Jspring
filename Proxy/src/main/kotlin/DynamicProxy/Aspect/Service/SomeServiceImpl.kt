package DynamicProxy.Aspect.Service

import DynamicProxy.Aspect.model.User
import org.springframework.stereotype.Component

//通过spring创建对象
@Component("someService")
class SomeServiceImpl : SomeService {
    override fun doSome(name: String, age: Int) {
        //之前输出时间
        println(" -----目标doSome---- ")
        println("$name : $age")

    }

    override fun doOther(name: String, age: Int): String {
        println(" -----目标doOther---- ")
        return "$name : $age"
    }

    override fun doUser(name: String, age: Int): User {
        println(" -----目标doUser---- ")
        return User(name, age)
    }

    override fun doAround(name: String, age: Int): User {
        println(" -----目标doUser---- ")
        return User(name, age)

    }

    override fun doAfterThrowing(x: Int, y: Int) {
        println(x / y)
    }
}