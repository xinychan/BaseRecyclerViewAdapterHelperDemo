package com.ubpost.baserecyclerviewadapterhelperdemo.bean;

import java.io.Serializable;

/**
 * 实体类
 * Created by xinychan on 2017/9/18.
 */

public class Person implements Serializable {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
