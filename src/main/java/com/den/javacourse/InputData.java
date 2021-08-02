package com.den.javacourse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@AllArgsConstructor
public class InputData implements InputOutputService{

    private final CheckInputDate check;
    @Override
    public void dataProcessing() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter ID an name in format 'id,name'");
        String idWithName = null;
        try {
            idWithName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!check.dataValidation(idWithName)){
            try {
                idWithName = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
