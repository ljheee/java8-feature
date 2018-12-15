package com.ljheee.java8.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class Java8Stream {


    public static void main(String[] args) {

        List<Food> foods = new ArrayList<>();
        //                  id     price   num
        foods.add(new Food(1, 5.5, 3));
        foods.add(new Food(2, 4.5, 8));
        foods.add(new Food(3, 56.5, 13));
        foods.add(new Food(4, 9.5, 56));

        // pre java8
        List<Long> result = new ArrayList<>();
        for (Food f : foods) {
            result.add(f.getId());
        }


        //java8 stream
        List<Long> collect = foods.parallelStream().map(each -> each.getId()).collect(toList());

        foods.stream().filter(each -> each.getPrice() > 5.0).map(e -> e.getId()).collect(toList());


        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(null);
        nums.add(3);
        nums.add(null);
        nums.add(5);
        long count = nums.stream().filter(num -> num != null).count();


        foods.stream().map(item -> item.getPrice() * item.getNum()).forEach(System.out::print);

        //计算 商品价格总和
        double totalPrice = foods.stream().map(item -> item.getPrice() * item.getNum()).reduce((sum, n) -> sum + n).get();

        Thread t = new Thread(() -> {
            System.out.println("Hello from a thread in run");
        }
        );

        listToMap();
    }


    public static void listToMap(){
        List<Food> foods = new ArrayList<>();
        foods.add(new Food(1, 5.5, 3));
        foods.add(new Food(2, 4.5, 8));
        foods.add(new Food(1, 56.5, 13));
        foods.add(new Food(2, 9.5, 56));

        //按ID  分组
        Map<Long, List<Food>> listMap = foods.stream().collect(Collectors.groupingBy(Food::getId));
        System.out.println();
        listMap.get(2L).forEach(System.out::println);



        Map<Long, Double> id_price_Map = foods.stream().collect(Collectors.toMap(Food::getId,item->item.getPrice()));



    }



}
