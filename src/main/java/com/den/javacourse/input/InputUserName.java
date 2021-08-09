package com.den.javacourse.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUserName implements InputService {
    @Override
    public String inputProcessing() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter ID and name in format 'id,name'");
        String idWithName = null;
        try {
            idWithName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idWithName;
    }
}
