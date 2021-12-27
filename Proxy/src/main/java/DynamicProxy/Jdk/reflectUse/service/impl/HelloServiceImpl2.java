package DynamicProxy.Jdk.reflectUse.service.impl;


import DynamicProxy.Jdk.reflectUse.service.HelloService;

public class HelloServiceImpl2 implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("HelloServiceImpl2=你好："+name);
    }
}
