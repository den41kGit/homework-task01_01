package com.den.javacourseV2.facades;

import com.den.javacourseV2.input.InputService;
import com.den.javacourseV2.output.OutputService;
import com.den.javacourseV2.user.User;
import com.den.javacourseV2.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class AppWorkFacadeImpl implements AppWorkFacade {
    @Autowired
    private InputService inputService;
    @Autowired
    private UserService userService;
    @Autowired
    private OutputService outputService;

    @Override
    public void startApp() {
        do{
                System.out.println("Enter ID and name in format 'id,name'");
                String userData = inputService.inputUserData();
            while (!userService.checkName(userData))
                userData = inputService.inputUserData();
            userService.saveUser(new User(Integer.parseInt( userService.parseUser(userData)[0]),
                                                            userService.parseUser(userData)[1]));
        }while (!outputService.checkForOutputInfo());

        System.out.println("Enter the username you are interested in...");
        String name = inputService.inputUserData();
        while (!userService.containsInDataBase(name)){
            System.out.println("There is no user with this name in the database." +
                    " Please enter a different name.");
            name = inputService.inputUserData();
        }
        userService.displayId(name);
    }
}
