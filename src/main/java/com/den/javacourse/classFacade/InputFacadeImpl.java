package com.den.javacourse.classFacade;

import com.den.javacourse.check.CheckInputService;
import com.den.javacourse.dataBase.DataBaseService;
import com.den.javacourse.input.InputService;
import com.den.javacourse.processing.ProcessingService;
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
