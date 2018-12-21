package com.ljheee.java8.sort;

import com.ljheee.java8.stream.Food;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lijianhua04 on 2018/12/12.
 */
public class ListSort {

    public static void main(String[] args) {

        List<Food> foods = new ArrayList<>();
        //                  id     price   num
        foods.add(new Food(1, 5.5, 3));
        foods.add(new Food(2, 4.5, 8));
        foods.add(new Food(3, 56.5, 13));
        foods.add(new Food(4, 9.5, 56));


        // 将List 按某个属性排序，形参新的list
        List<Food> newList = foods.stream().sorted(Comparator.comparing(Food::getPrice))
                .collect(Collectors.toList());
        newList.forEach(System.out::println);
    }



}
