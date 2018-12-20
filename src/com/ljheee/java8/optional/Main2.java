package com.ljheee.java8.optional;


import java.util.Optional;

/**
 * Created by lijianhua04 on 2018/7/20.
 *
 *使用 Java 8 Optional 的正确姿势
 * https://blog.csdn.net/wisgood/article/details/52503052
 */
public class Main2 {

    public static String main(String[] args) {

        Optional<User> user = null;


        user.map(u -> u.getName())
                .map(name -> name.toUpperCase())
                .orElse(null);




        if (user.isPresent()) {
            return user.get().getName();
        } else {
            return "null";
        }

    }






}

