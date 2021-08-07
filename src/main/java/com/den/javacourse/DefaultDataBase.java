package com.den.javacourse;

import java.util.HashSet;
import java.util.Set;

public class DefaultDataBase implements DataBaseService{
    private static Set usersSet = new HashSet();

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
