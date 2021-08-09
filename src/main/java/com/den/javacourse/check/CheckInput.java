package com.den.javacourse.check;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Scanner;

@RequiredArgsConstructor
@AllArgsConstructor
public class CheckInput implements CheckInputService {
    @Value("${max_name_length}")
    private int maxNameLength;
    @Override
    public boolean checkUserName(String userName) {
        String[] words = userName.split(",");

        if (words.length ==1 || words.length > 2 ){
            System.out.println("You entered incorrect data");
            return false;
        }

        Scanner sc = new Scanner(words[0]);
        if (!sc.hasNextInt()){
            System.out.println("You entered incorrect data");
            return false;
        }

        if(words[1].length() > maxNameLength) {
            System.out.println("You entered incorrect data");
            return false;
        }
        return true;
    }
}
