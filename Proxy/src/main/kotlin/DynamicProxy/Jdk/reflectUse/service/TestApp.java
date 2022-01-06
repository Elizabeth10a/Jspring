package DynamicProxy.Jdk.reflectUse.service;


import DynamicProxy.Jdk.reflectUse.service.HelloService;
import DynamicProxy.Jdk.reflectUse.service.impl.HelloServiceImpl;
import DynamicProxy.Jdk.reflectUse.service.impl.HelloServiceImpl2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestApp {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //HelloService service = new HelloServiceImpl();
        //service.sayHello("张三");

        //使用反射机制执行sayHello方法。 核心Method（类中的方法）
        HelloService h1 = new HelloServiceImpl();
        //获取sayHello名称对于的Method类对象
        Method method = HelloService.class.getMethod("sayHello", String.class);
        //通过Method可以执行sayHello方法调用


        /*
           invoke是Method类中的一个方法。表示执行方法的调用
           参数：
            1. Object ， 表示对象的，要执行这个对象的方法
            2. Object... args ， 方法执行时的参数值
           返回值：
             Object：方法执行后的返回值
         */


        //表达的意思就是 执行target对象sayHello,参数是李四
        HelloService h2 = new HelloServiceImpl2();
        // 执行service2对象method（sayHello）方法，参数是“李四”
        Object ret2 = method.invoke(h2, "李四");
        Object ret1 = method.invoke(h1 , "李四");


    }
}
