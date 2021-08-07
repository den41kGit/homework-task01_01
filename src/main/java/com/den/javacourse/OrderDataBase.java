package com.den.javacourse;

import java.util.LinkedHashSet;
import java.util.Set;

public class OrderDataBase implements DataBaseService{
    private static Set usersSet = new LinkedHashSet();
    @Override
    public void saveUser(int id, String name) {
        User user = new User(id, name);
        usersSet.add(user);
    }
    @Override
    public Set getUsersSet() {
        return usersSet;
    }
}
