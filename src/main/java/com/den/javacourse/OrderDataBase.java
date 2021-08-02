package com.den.javacourse;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class OrderDataBase implements DataBaseService{
    private static Set usersSet = new TreeSet();

    @Override
    public void saveToDataBase(int id, String name) {
        User user = new User(id, name);
        usersSet.add(user);
    }

    @Override
    public void getDateFromBase() {

    }
}
