package com.den.javacourseV2.dataBase;

import com.den.javacourseV2.user.User;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;
@Component
public class OrderDataBase implements DataBase<User> {
    private static final Set<User> usersSet = new LinkedHashSet<>();
    @Override
    public void save(User element) {
        usersSet.add(element);
    }
    @Override
    public Set <User> select() {
        return usersSet;
    }
}
