package com.den.javacourse;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class GetUserIdByName implements UserInformationService{
    private final DataBaseService dataBaseService;
    @Override
    public void getInfo(String name) {
        Set<User> userStream = dataBaseService.getUsersSet();
        userStream.stream().
                filter(s -> s.getName().equals(name)).
                map(User::getId).
                forEach(System.out::println);
    }
}
