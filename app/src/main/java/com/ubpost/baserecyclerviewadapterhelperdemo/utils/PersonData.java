package com.ubpost.baserecyclerviewadapterhelperdemo.utils;

import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinychan on 2017/9/19.
 */

public class PersonData {

    public static List<Person> initData_15() {
        List<Person> mDatas = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            Person person = new Person();
            person.setName("name_" + i);
            person.setAge("age_" + i);
            mDatas.add(person);
        }
        return mDatas;
    }

    public static List<Person> initData_50() {
        List<Person> mDatas = new ArrayList<>(50);
        for (int i = 0; i < 50; i++) {
            Person person = new Person();
            person.setName("name_" + i);
            person.setAge("age_" + i);
            mDatas.add(person);
        }
        return mDatas;
    }
}
