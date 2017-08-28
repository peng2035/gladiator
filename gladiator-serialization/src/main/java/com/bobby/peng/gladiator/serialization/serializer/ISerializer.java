package com.bobby.peng.gladiator.serialization.serializer;

/**
 * Created by bobby.peng on 2017/8/28.
 */
public interface ISerializer {

    <T> byte[] serialize(T obj);


    <T> T deserialize(byte[] data, Class<T> clazz);

}
