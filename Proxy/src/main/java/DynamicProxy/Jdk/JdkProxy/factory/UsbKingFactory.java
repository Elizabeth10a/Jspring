package DynamicProxy.Jdk.JdkProxy.factory;


import DynamicProxy.Jdk.JdkProxy.service.UsbSell;

//目标类
public class UsbKingFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        //目标方法
        System.out.println("UsbKingFactory 目标类中，执行sell目标方法");
        return 85.0f;
    }

    @Override
    public void print() {

    }
}
