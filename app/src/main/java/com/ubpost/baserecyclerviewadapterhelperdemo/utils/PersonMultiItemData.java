package com.ubpost.baserecyclerviewadapterhelperdemo.utils;

import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.PersonMultiItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinychan on 2017/9/19.
 */

public class PersonMultiItemData {

    public static List<PersonMultiItem> initData_15() {
        List<PersonMultiItem> mDatas = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            Person person = new Person();
            person.setName("name_" + i);
            person.setAge("age_" + i);
            if (i % 3 == 0) {
                PersonMultiItem personMultiItem = new PersonMultiItem(PersonMultiItem.SMALL, person);
                mDatas.add(personMultiItem);
            } else {
                PersonMultiItem personMultiItem = new PersonMultiItem(PersonMultiItem.BIG, person);
                mDatas.add(personMultiItem);
            }
        }
        return mDatas;
    }

}
