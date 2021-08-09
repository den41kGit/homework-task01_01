package com.den.javacourse.dataBase;

import com.den.javacourse.userInformation.User;

import java.util.LinkedHashSet;
import java.util.Set;

public class OrderDataBase implements DataBaseService{
    private static Set <User> usersSet = new LinkedHashSet();
    @Override
    public void saveUser(int id, String name) {
        User user = new User(id, name);
        usersSet.add(user);
    }
    @Override
    public Set <User> getUsersSet() {
        return usersSet;
    }
}
