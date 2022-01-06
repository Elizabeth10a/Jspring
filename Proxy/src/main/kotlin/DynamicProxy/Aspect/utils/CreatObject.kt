package DynamicProxy.Aspect.utils

import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext



class CreatObject {
    var beanPath = "DynamicProxy/Aspect/note.xml"

    constructor()

    constructor(beanPath: String? = null) {
        beanPath?.let { this.beanPath = beanPath }
    }

    fun getSpringInfo() {
        val ac: ApplicationContext = ClassPathXmlApplicationContext(beanPath)

        println("配置文件中的对象数量: ${ac.beanDefinitionCount}")
        ac.beanDefinitionNames.forEach { it ->
            println(it)
        }

    }

    fun useSpring(obj: String): Any {
        //1.获取核心容器对象  此时创建配置文件中的对象
        val ac: ApplicationContext = ClassPathXmlApplicationContext(beanPath)
        return ac.getBean(obj)

    }
}