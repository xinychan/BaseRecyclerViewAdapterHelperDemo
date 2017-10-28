package com.ubpost.baserecyclerviewadapterhelperdemo.utils;

import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.PersonSection;

import java.util.ArrayList;
import java.util.List;

/**
 * 分组布局的实体类
 * 实体类必须继承SectionEntity
 * Created by xinychan on 2017/9/19.
 */

public class PersonSectionData {

    public static List<PersonSection> initData_15() {
        List<PersonSection> mDatas = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            Person person = new Person();
            person.setName("name_" + i);
            person.setAge("age_" + i);
            if (i == 5 || i == 10) {
                //分组的实例
                PersonSection personSection = new PersonSection(true, "Head_" + i);
                personSection.t = person;
                mDatas.add(personSection);
            } else {
                //未分组的实例
                PersonSection personSection = new PersonSection(false, null);
                personSection.t = person;
                mDatas.add(personSection);
            }
        }
        return mDatas;
    }

}
