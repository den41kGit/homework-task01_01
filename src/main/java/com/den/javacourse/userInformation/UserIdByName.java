package com.den.javacourse.userInformation;

import com.den.javacourse.dataBase.DataBaseService;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class UserIdByName implements UserInformationService{
    private final DataBaseService dataBaseService;
    public void displayInfo(String name) {
        Set<User> userStream = dataBaseService.getUsersSet();
        userStream.stream().
                filter(s -> s.getName().equals(name)).
                map(User::getId).
                forEach(System.out::println);
    }
}
