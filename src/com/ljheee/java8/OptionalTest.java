package com.ljheee.java8;

import java.util.Optional;

/**
 * Created by lijianhua04 on 2018/7/29.
 */
public class OptionalTest {

    public static void main(String args[]){

        OptionalTest tester = new OptionalTest();
        Integer value1 = null;
        Integer value2 = new Integer(5);

        // ofNullable 允许传参时给出 null
        Optional<Integer> a = Optional.ofNullable(value1);

        // 如果传递的参数为null，那么 of 将抛出空指针异常（NullPointerException）
        Optional<Integer> b = Optional.of(value2);
        System.out.println(tester.sum(a,b));
    }



    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // isPresent 用于检查值是否存在

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        // 如果当前返回的是传入的默认值，orElse 将返回它
        Integer value1 = a.orElse(new Integer(0));

        // get 用于获得值，条件是这个值必须存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}
