package com.den.javacourseV2.dataBase;

import com.den.javacourse.dataBase.DataBaseService;

import java.util.LinkedHashSet;
import java.util.Set;

public class OrderDataBase<E> implements DataBaseService<E> {
    private static Set usersSet = new LinkedHashSet();
    @Override
    public void save(E element) {
        usersSet.add(element);
    }
    @Override
    public Set <E> select() {
        return usersSet;
    }
}
