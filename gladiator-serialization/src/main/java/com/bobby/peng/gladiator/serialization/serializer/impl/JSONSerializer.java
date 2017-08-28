package com.bobby.peng.gladiator.serialization.serializer.impl;

import com.alibaba.fastjson.JSON;
import com.bobby.peng.gladiator.serialization.serializer.ISerializer;

/**
 * Created by bobby.peng on 2017/8/28.
 */
public class JSONSerializer implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSON.parseObject(new String(data), clazz);
    }
}
