package com.den.javacourse;

import java.util.Set;

public interface DataBaseService {
    void saveUser(int id, String name);
    Set getUsersSet();
}
