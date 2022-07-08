package com.ljheee.java8.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lijianhua.
 */
public class InternalCollectors {


    public static void main(String[] args) {


        collectorsJoining();

    }

    private static void collectorsJoining() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.stream().collect(Collectors.joining()));//abc
        System.out.println(list.stream().collect(Collectors.joining(",")));//a,b,c

    }
}
