package com.den.javacourse.dataBase;

import com.den.javacourse.userInformation.User;

import java.util.Set;

public interface DataBaseService {
    void saveUser(int id, String name);
    Set <User> getUsersSet();
}
