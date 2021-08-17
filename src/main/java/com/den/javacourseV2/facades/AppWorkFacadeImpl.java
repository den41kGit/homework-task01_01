package com.den.javacourseV2.facades;

import com.den.javacourseV2.input.InputService;
import com.den.javacourseV2.output.OutputService;
import com.den.javacourseV2.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class AppWorkFacadeImpl implements AppWorkFacade {
    @Autowired
    private InputFacade inputFacade;
    @Autowired
    private DataBaseFacade dataBaseFacade;
    @Autowired
    private OutputService outputService;
    @Autowired
    private InputService inputService;
    @Autowired
    private UserService userService;

    @Override
    public void startApp() {
        dataBaseFacade.saveCorrectData(inputFacade.preparationOfCorrectInput());
        while (!outputService.checkForOutput()) {
            dataBaseFacade.saveCorrectData(inputFacade.preparationOfCorrectInput());
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
