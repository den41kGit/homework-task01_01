package com.den.javacourseV2.facades;

import com.den.javacourseV2.input.InputService;
import com.den.javacourseV2.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InputFacadeimpl implements InputFacade{
    @Autowired
    private InputService inputService;
    @Autowired
    private UserService userService;
    @Override
    public String preparationOfCorrectInput() {
        System.out.println("Enter ID and name in format 'id,name'");
        String inputIdWithName = inputService.inputUserName();
        while (!userService.checkName(inputIdWithName)){
            inputIdWithName = inputService.inputUserName();
        }
        return inputIdWithName;
    }
}
