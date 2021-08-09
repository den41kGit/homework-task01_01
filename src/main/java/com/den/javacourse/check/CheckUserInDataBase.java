package com.den.javacourse.check;

import com.den.javacourse.userInformation.User;
import com.den.javacourse.dataBase.DataBaseService;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class CheckUserInDataBase implements CheckInputService{
    private final DataBaseService dataBaseService;
    @Override
    public boolean checkUserName(String userName) {
        Set <User> userStream = dataBaseService.getUsersSet();
        return (userStream.stream().anyMatch((x) -> x.getName().equals(userName)));
    }
}
