package com.ljheee.java8.stream;


import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Food{
    private long id;
    private double price;
    private int num;

    public Food(long id, double price, int num) {
        this.id = id;
        this.price = price;
        this.num = num;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
public class Java8Stream {


    public static void main(String[] args) {

        List<Food> foods = new ArrayList<>();
        //                  id     price   num
        foods.add(new Food(1,5.5,3));
        foods.add(new Food(2,4.5,8));
        foods.add(new Food(3,56.5,13));
        foods.add(new Food(4,9.5,56));

        // pre java8
        List<Long> result = new ArrayList<>();
        for (Food f: foods) {
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



        foods.stream().map(item->item.getPrice() * item.getNum()).forEach(System.out::print);



        double totalPrice = foods.stream().map(item->item.getPrice() * item.getNum()).reduce((sum,n)->sum+n).get();

        Thread t = new Thread(() -> { System.out.println("Hello from a thread in run");
        }
);

    }







}
