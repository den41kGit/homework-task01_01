package com.den.javacourseV2.dataBase;

import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public interface DataBase <T>{
    void save(T element);
    Set<T> select();
}
