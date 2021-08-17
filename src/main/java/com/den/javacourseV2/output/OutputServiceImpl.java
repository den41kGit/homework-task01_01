package com.den.javacourseV2.output;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@Component
public class OutputServiceImpl implements OutputService{
    @Override
    public boolean checkForOutput() {
        BufferedReader readerRequest = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you want to get a user ID with a specific name?" +
                " Enter \"yes\" or \"no\"");
        String yesOrNo = null;
        try {
            yesOrNo = readerRequest.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!(yesOrNo.equals("yes")) && (!yesOrNo.equals("no"))) {
            System.out.println("Enter \"yes\" or \"no\"");
            try {
                yesOrNo = readerRequest.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (yesOrNo.equals("yes")) {
            return true;
        }
        return  false;
    }
}
