package com.bobby.peng.gladiator.test.consumer;

import com.bobby.peng.gladiator.client.proxy.ConsumerProxy;
import com.bobby.peng.gladiator.common.proxy.ProxyUtils;
import com.bobby.peng.gladiator.test.api.HelloWorld;

/**
 * Created by peng2035 on 2017/8/27.
 */
public class ConsumerTest {

    public static void main(String[] args) {
        HelloWorld helloWorld = ConsumerProxy.proxy(HelloWorld.class,"127.0.0.1", 8090);
        //todo 获取类的字节流 将类保存到硬盘上
        ProxyUtils.generateClassFile(helloWorld.getClass(),"helloWorld");
        System.out.println(helloWorld.sayHello());
    }

}
