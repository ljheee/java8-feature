package com.ljheee.java8.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 大List 切分
 */
public class ListGroup {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(2002);

        for (int i = 0; i < 2002; i++) {
            list.add(String.valueOf(Math.random()));
        }


        List[] subLists = cutGroup(list);

        for (List a : subLists) {
            System.out.println(a.size());
        }

//        customList(list);


    }

    /**
     * 切分 list
     *
     * @param list
     * @return
     */
    private static List[] cutGroup(List<String> list) {

        int groupSize = 500;//TODO 分组大小，可配置
        int total = list.size();

        int n = total / groupSize;
        if (total % groupSize != 0) {
            n += 1;
        }

        List[] result = new List[n];
        int j = 0;
        for (int i = 0; i < total; i += groupSize) {
            if (j == n - 1) {
                result[j] = list.subList(i, total);
            } else {

                result[j++] = list.subList(i, i + groupSize);
            }
        }

        return result;
    }

    /**
     * 模拟RPC接口，
     *
     * @param list 限制每次是500
     */
    public static void customList(List<String> list) {
        list.forEach(System.out::print);
    }


}
