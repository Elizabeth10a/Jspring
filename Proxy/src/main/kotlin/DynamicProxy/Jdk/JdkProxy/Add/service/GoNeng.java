package DynamicProxy.Jdk.JdkProxy.Add.service;

public class GoNeng implements HelloService {
    @Override
    public int print(String name) {
        System.out.println("其它人写好的个功能方法");
        return 2;
    }
}
