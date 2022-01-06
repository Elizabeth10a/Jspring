package DynamicProxy.Jdk.JdkEx.handler;


import DynamicProxy.Jdk.JdkEx.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIndicationHandler implements InvocationHandler {

    //目标对象
    private Object target; //SomeServiceImpl类

    public MyIndicationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用执行这个invoke（）
        System.out.println("----执行MyIndicationHandler中的invoke()--");
        System.out.println("执行method名称："+method.getName());
        String methodName = method.getName();
        Object res = null;

        /*
    2）JoinPoint:连接点 ，连接业务方法和切面的位置。 就某类中的业务方法
	3）Pointcut : 切入点 ，指多个连接点方法的集合。多个方法
	4）目标对象： 给哪个类的方法增加功能， 这个类就是目标对象
	5）Advice:通知，通知表示切面功能执行的时间。*/


        if("doSome".equals(methodName)){ //JoinPoint * n ==》  Pointcut
            ServiceTools.doLog(); //在目标方法之前，输出时间
            //执行目标类的方法，通过Method类实现
            res  = method.invoke(target,args); //SomeServiceImpl.doSome()
            ServiceTools.doTrans(); //在目标方法执行之后，提交事务
        } else {
            res  = method.invoke(target,args); //SomeServiceImpl.doOther()
        }

        //目标方法的执行结果
        return res;
    }
}
