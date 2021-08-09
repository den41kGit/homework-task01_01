package com.den.javacourse.dataBase;

import com.den.javacourse.userInformation.User;

import java.util.HashSet;
import java.util.Set;

public class DefaultDataBase implements DataBaseService{
    private static Set <User> usersSet = new HashSet();

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
