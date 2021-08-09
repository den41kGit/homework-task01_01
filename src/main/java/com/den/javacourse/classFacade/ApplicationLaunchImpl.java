package com.den.javacourse.classFacade;

import com.den.javacourse.check.CheckInputService;
import com.den.javacourse.input.InputService;
import com.den.javacourse.request.RequestToGetInfoService;
import com.den.javacourse.userInformation.UserInformationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApplicationLaunchImpl implements ApplicationLaunchFacadeService{
    private final InputFacadeService inputFacadeService;
    private final RequestToGetInfoService requestToGetInfoService;
    private final InputService inputNameForGetID;
    private final CheckInputService checkUserInDataBase;
    private final UserInformationService userInformationService;
    @Override
    public void startApp() {
        inputFacadeService.inputProcess();
        while (!requestToGetInfoService.request()) {
            inputFacadeService.inputProcess();
        }
            String name = inputNameForGetID.inputProcessing();
            if (!checkUserInDataBase.checkUserName(name)){
                System.out.println("There is no user with this name in the database." +
                        " Please enter a different name.");
                name = inputNameForGetID.inputProcessing();
            }
            userInformationService.displayInfo(name);
        }
    }

