package com.bobby.peng.gladiator.serialization.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by bobby.peng on 2017/8/28.
 */
public enum SerializeType {

    DefaultJavaSerializer(1, "DefaultJavaSerializer"),
//    HessianSerializer(2, "HessianSerializer"),
    JSONSerializer(3, "JSONSerializer"),
    ProtoStuffSerializer(4, "ProtoStuffSerializer");
//    XmlSerializer(5, "XmlSerializer"),
//    ThriftSerializer(6, "ThriftSerializer");

    private int    id;
    private String serializerType;

    SerializeType(int id, String serializerType) {
        this.id = id;
        this.serializerType = serializerType;
    }

    public static SerializeType findByType(String serializeType) {
        if (StringUtils.isBlank(serializeType)) {
            throw new RuntimeException("SerializeType.findByType param error, serializeType = " + serializeType);
        }

        for (SerializeType serialize : SerializeType.values()) {
            if (serialize.getSerializeType().equals(serializeType)) {
                return serialize;
            }
        }
        throw new RuntimeException("SerializeType.findByType param error, serializeType = " + serializeType);
    }

    public static SerializeType findById(int id) {
        for (SerializeType serialize : SerializeType.values()) {
            if (serialize.getId() == id) {
                return serialize;
            }
        }
        throw new RuntimeException("SerializeType.findByType param error, id = " + id);
    }
    
    public int getId() {
        return id;
    }

    public String getSerializeType() {
        return serializerType;
    }
}
