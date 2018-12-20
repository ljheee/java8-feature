package com.ljheee.java8.optional;

import java.util.Objects;

/**
 * Created by lijianhua04 on 2018/7/20.
 *
 * Objects（since 1.7） 工具类，提供类很多静态方法
 * https://www.cnblogs.com/quiet-snowy-day/p/6387321.html
 *
 *
 */
public class Main {

    Integer id;


    public void setMethod(Integer id){
        this.id = Objects.requireNonNull(id);
    }

    public static void main(String[] args) {
        User user = new User(1,"qq" ,"qq" );
        User ss = new User(1,"qq" ,"qq" );


        System.out.println(Objects.deepEquals(user ,ss));
        System.out.println(Objects.hash(user));
        System.out.println(Objects.isNull(user));


        new Main().setMethod((Integer)null);
    }

}
