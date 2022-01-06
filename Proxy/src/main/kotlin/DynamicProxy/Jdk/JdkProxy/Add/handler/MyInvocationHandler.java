package DynamicProxy.Jdk.JdkProxy.Add.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object target = null;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //我在项目中记录数据库，
        //调用目标方法， 执行print()得到 2
        Object res = method.invoke(target,args); //2
        //需要乘以 2的结果
        if( res != null){
            Integer num = (Integer)res;
            res = num * 2;
        }

        return res;
    }
}
