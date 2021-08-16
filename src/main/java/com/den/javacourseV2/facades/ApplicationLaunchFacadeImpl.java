package com.den.javacourseV2.facades;

import com.den.javacourseV2.input.InputService;
import com.den.javacourseV2.output.OutputService;
import com.den.javacourseV2.user.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApplicationLaunchFacadeImpl implements ApplicationLaunchFacade{
    private final InputFacade inputFacade;
    private final OutputService outputService;
    private final InputService inputService;
    private final UserService userService;

    @Override
    public void startApp() {
        inputFacade.inputProcess();
        while (!outputService.output()) {
            inputFacade.inputProcess();
        }
        System.out.println("Enter the username you are interested in...");
        String name = inputService.inputUserName();
        if (!userService.containsInDataBase(name)){
            System.out.println("There is no user with this name in the database." +
                    " Please enter a different name.");
            name = inputService.inputUserName();
        }
        userService.displayId(name);
    }
}
