package com.ljheee.java8.Interface;

/**
 *
 */
public interface EntityInterface {

    int MAX_SERVICE_TIME = 100;

    default void saveEntity() {
        System.out.println("Java8 接口支持带方法体的default、static方法。");
    }

    static void doStatic() {
        System.out.println("Java8 接口支持带方法体的default、static方法。");
    }


}
