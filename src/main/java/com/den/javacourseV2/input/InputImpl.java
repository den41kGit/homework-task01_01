package com.den.javacourseV2.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputImpl implements InputService{
    @Override
    public String inputUserName() {
        BufferedReader readerRequest = new BufferedReader(new InputStreamReader(System.in));
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
