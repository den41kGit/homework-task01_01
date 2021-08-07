package com.den.javacourse;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class CheckUserInDataBase implements CheckInputService{
    private final DataBaseService dataBaseService;
    @Override
    public boolean checkUserName(String userName) {
        Set <User> userStream = dataBaseService.getUsersSet();
        if(userStream.stream().anyMatch((x) -> x.getName().equals(userName))){
            return true;
        }
        return false;
    }
}
