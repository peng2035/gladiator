package com.bobby.peng.gladiator.test.provider;

import com.bobby.peng.gladiator.server.proxy.ProviderProxy;
import com.bobby.peng.gladiator.test.service.HelloWorldImpl;

import java.io.IOException;

/**
 * Created by peng2035 on 2017/8/27.
 */
public class ProviderTest {

    public static void main(String[] args) throws IOException {
        ProviderProxy.provide(new HelloWorldImpl(), 8090);
    }

}
