package com.den.javacourseV2.input;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@Component
public class InputImpl implements InputService{
    @Override
    public String inputUserData() {
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
