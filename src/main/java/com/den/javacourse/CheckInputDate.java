package com.den.javacourse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
@RequiredArgsConstructor
@AllArgsConstructor

public class CheckInputDate implements CheckCorrectProcessingService {
    @Value("${max_name_length}")
    private int maxNameLength;
    @Autowired
    private final DataBaseService dB;

    @Override
    public boolean dataValidation(String date) {

        String[] words = date.split(",");

        if (words.length ==1 || words.length > 2 ){
            System.out.println("You entered incorrect data");
            return false;
        }
        else{
            words[0] = words[0].trim();
            words[1] = words[1].trim();
        }

        Scanner sc = new Scanner(words[0]);
        if (!sc.hasNextInt()){
            System.out.println("You entered incorrect data");
            return false;
        }
        int id = Integer.parseInt(words[0]);

        if(words[1].length() > maxNameLength) {
            System.out.println("You entered incorrect data");
            return false;
        }
        String name = words[1];

        dB.saveToDataBase(id, name);

        return true;
    }
}
