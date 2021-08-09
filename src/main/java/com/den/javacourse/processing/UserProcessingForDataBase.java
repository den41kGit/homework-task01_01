package com.den.javacourse.processing;

public class UserProcessingForDataBase implements ProcessingService{

    @Override
    public String[] processing(String stringToProcess) {
        String[] idWithName = stringToProcess.split(",");
        idWithName[0] = idWithName[0].trim();
        idWithName[1] = idWithName[1].trim();
        return idWithName;
    }
}
