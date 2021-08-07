package com.den.javacourse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InputFacadeImpl implements InputFacadeService{
    private final InputService inputUserName;
    private final CheckInputService checkInputService;
    private final ProcessingService processingService;
    private final DataBaseService dataBaseService;
    @Override
    public void inputProcess() {
        String inputIdWithName = inputUserName.inputProcessing();
        while (!checkInputService.checkUserName(inputIdWithName)){
            inputIdWithName = inputUserName.inputProcessing();
        }
            String processeUsername[] = processingService.processing(inputIdWithName);
            dataBaseService.saveUser(Integer.parseInt(processeUsername[0]), processeUsername[1]);
    }
}
