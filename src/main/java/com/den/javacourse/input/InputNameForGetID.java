package com.den.javacourse.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputNameForGetID implements InputService{
    @Override
    public String inputProcessing() {
        BufferedReader readerRequest = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the username you are interested in...");
        String username = null;
        try {
            username = readerRequest.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return username;
    }
}
