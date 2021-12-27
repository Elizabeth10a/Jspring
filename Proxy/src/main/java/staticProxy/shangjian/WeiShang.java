package staticProxy.shangjian;

import staticProxy.factory.UsbKingFactory;
import staticProxy.service.UsbSell;

public class WeiShang implements UsbSell {
    //代理的是 金士顿，定义目标厂家类
    private UsbKingFactory factory = new UsbKingFactory();
    @Override
    public float sell(int amount) {
        //调用目标方法
        float price = factory.sell(amount);
        //只增加1元
        price = price + 1;
        return price;
    }
}
