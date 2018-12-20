package com.ljheee.java8.optional;

/**
 * Created by lijianhua04 on 2018/7/20.
 */
public class User {


    private Integer id;
    private String name;
    private String passwd;


    public User() {
    }

    public User(Integer id, String name, String passwd) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}

