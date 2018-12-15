package com.ljheee.java8.stream;

/**
 * Created by lijianhua04 on 2018/12/12.
 */
public class Food {
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

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
