package com.den.javacourseV2.dataBase;

import com.den.javacourseV2.dataBase.DataBase;
import com.den.javacourseV2.user.User;

import java.util.LinkedHashSet;
import java.util.Set;

public class OrderDataBase implements DataBase<User> {
    private static Set<User> usersSet = new LinkedHashSet();
    @Override
    public void save(User element) {
        usersSet.add(element);
    }
    @Override
    public Set <User> select() {
        return usersSet;
    }
}
