package com.den.javacourseV2.dataBase;

import java.util.Set;

public interface DataBase <T>{
    void save(T element);
    Set<T> select();
}
