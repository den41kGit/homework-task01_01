package com.den.javacourse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InputFacadeImpl implements InputFacadeService{
    private final InputService inputService;
    private final CheckInputService checkInputService;
    private final DataBaseService dataBaseService;
    @Override
    public void inputProcess() {
        String name = inputService.inputProcessing();
        while (!checkInputService.checkUserName(name)){
            name = inputService.inputProcessing();
        }
            String[] words = name.split(",");
            words[0] = words[0].trim();
            words[1] = words[1].trim();

            dataBaseService.saveUser(Integer.parseInt(words[0]), words[1]);
    }
}
