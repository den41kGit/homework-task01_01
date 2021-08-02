package com.den.javacourse;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

public class SimpleDataBase implements DataBaseService{
    private static Set usersSet = new HashSet();

    @Override
    public void saveToDataBase(int id, String name) {
        User user = new User(id, name);
        usersSet.add(user);
     }

    @Override
    public void getDateFromBase() {

    }
}
