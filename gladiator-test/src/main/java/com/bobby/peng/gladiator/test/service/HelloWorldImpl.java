package com.bobby.peng.gladiator.test.service;

import com.bobby.peng.gladiator.test.api.HelloWorld;

/**
 * Created by peng2035 on 2017/8/27.
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello() {
        return "hello";
    }

}
