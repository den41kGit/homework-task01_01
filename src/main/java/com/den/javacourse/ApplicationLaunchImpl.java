package com.den.javacourse;

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
        if (requestToGetInfoService.request()){
            String name = inputNameForGetID.inputProcessing();
            if(checkUserInDataBase.checkUserName(name)){
                userInformationService.getInfo(name);
            }
        }

    }
}
