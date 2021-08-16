package com.den.javacourseV2.facades;

import com.den.javacourseV2.dataBase.DataBase;
import com.den.javacourseV2.input.InputService;
import com.den.javacourseV2.user.User;
import com.den.javacourseV2.user.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InputFacadeimpl implements InputFacade{
    private final InputService inputService;
    private final UserService userService;
    private final DataBase dataBase;
    @Override
    public void inputProcess() {
        System.out.println("Enter ID and name in format 'id,name'");
        String inputIdWithName = inputService.inputUserName();
        while (!userService.checkName(inputIdWithName)){
            inputIdWithName = inputService.inputUserName();
        }
        String[] processeUsername = userService.processingForDataBase(inputIdWithName);
        User user = new User(Integer.parseInt(processeUsername[0]), processeUsername[1]);
        dataBase.save(user);
    }
}
