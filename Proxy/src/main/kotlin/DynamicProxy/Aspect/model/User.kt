package DynamicProxy.Aspect.model

class User {
    var name: String? = null
    var age = 0

    constructor() {
        println("==User无参构造==")
    }//无参构造

    constructor(name: String) {
        println("==User name构造==")

        this.name = name
    }

    constructor(name: String, age: Int) {
        println("==User name  age构造==")
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "User(name=$name, age=$age)"
    }


}