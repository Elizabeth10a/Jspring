package DynamicProxy.Jdk.reflectUse.service.impl;


import DynamicProxy.Jdk.reflectUse.service.HelloService;

public class HelloServiceImpl  implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("你好："+name);
    }
}
