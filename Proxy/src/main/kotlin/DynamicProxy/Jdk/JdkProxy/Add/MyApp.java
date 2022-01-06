package DynamicProxy.Jdk.JdkProxy.Add;


import DynamicProxy.Jdk.JdkProxy.Add.handler.MyInvocationHandler;
import DynamicProxy.Jdk.JdkProxy.Add.service.GoNeng;
import DynamicProxy.Jdk.JdkProxy.Add.service.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MyApp {

    public static void main(String[] args) {
       // GoNeng gn = new GoNeng();
        //int num = gn.print("销售");
       // System.out.println("num="+num);
        System.out.println("---------");
        GoNeng goNeng = new GoNeng();
        InvocationHandler handler = new MyInvocationHandler(goNeng);

        System.out.println("goNeng.getClass().getInterfaces()="+goNeng.getClass().getInterfaces()[0].getName());
        HelloService proxy = (HelloService) Proxy.newProxyInstance(
                goNeng.getClass().getClassLoader(),
                goNeng.getClass().getInterfaces(),
                handler);

        int num = proxy.print("市场");
        System.out.println("我们期望的 num ==" + num);

    }
}
