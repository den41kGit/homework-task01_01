package com.den.javacourseV2.dataBase;

import java.util.HashSet;
import java.util.Set;

public class DefaultDataBase<E> implements DataBase<E>{
    private static final Set usersSet = new HashSet();

    @Override
    public void save(E element) {
        usersSet.add(element);
    }

    @Override
    public Set<E> select() {
        return usersSet;
    }
}
