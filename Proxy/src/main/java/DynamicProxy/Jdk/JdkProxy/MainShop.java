package DynamicProxy.Jdk.JdkProxy;


import DynamicProxy.Jdk.JdkProxy.factory.UsbKingFactory;
import DynamicProxy.Jdk.JdkProxy.handler.MySellHandler;
import DynamicProxy.Jdk.JdkProxy.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainShop {

    public static void main(String[] args) {
        //创建代理对象，使用Proxy
        //1. 创建目标对象
        // UsbKingFacotry  factory = new UsbKingFactory();
        UsbSell factory = new UsbKingFactory();
        //2.创建InvocationHandler对象
        InvocationHandler handler = new MySellHandler(factory);

//        handler.invoke()

        /*

 3. 实现动态代理的步骤：
    1. 创建接口，定义目标类要完成的功能
	 2. 创建目标类实现接口
	 3. 创建InvocationHandler接口的实现类，在invoke方法中完成代理类的功能
	     1.调用目标方法
		  2.增强功能

	 4.使用Proxy类的静态方法，创建代理对象。 并把返回值转为接口类型。

        * 加载器，类接口，*/
        //3.创建代理对象
        UsbSell proxy = (UsbSell) Proxy.newProxyInstance(
                factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);

        //com.sun.proxy.$Proxy0 : 这是jdk动态代理创建的对象类型。
        System.out.println("proxy:" + proxy.getClass().getName());
        //4.通过代理执行方法
        float price = proxy.sell(3);
        System.out.println("通过动态代理对象，调用方法：" + price);
    }
}
