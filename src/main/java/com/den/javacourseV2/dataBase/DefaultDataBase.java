package com.den.javacourseV2.dataBase;

import com.den.javacourseV2.user.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
@Primary
public class DefaultDataBase implements DataBase<User>{
    private static final Set<User> usersSet = new HashSet<>();

    @Override
    public void save(User element) {
        usersSet.add(element);
    }

    @Override
    public Set<User> select() {
        return usersSet;
    }
}
