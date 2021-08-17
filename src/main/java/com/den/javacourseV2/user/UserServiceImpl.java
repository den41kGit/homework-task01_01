package com.den.javacourseV2.user;


import com.den.javacourseV2.dataBase.DataBase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService{
    @Value("${max_name_length}")
    private int maxNameLength;
    @Autowired
    private DataBase dataBase;

    @Override
    public boolean checkName(String inputStr) {
        String[] words = inputStr.split(",");
        if (words.length ==1 || words.length > 2 ){
            System.out.println("You entered incorrect data");
            return false;
        }
        try {
            Integer.parseInt(words[0]);
        }
        catch (NumberFormatException e) {
            System.out.println("You entered incorrect data");
            return false;
        }
        if(words[1].length() > maxNameLength) {
            System.out.println("You entered incorrect data");
            return false;
        }
        return true;
    }

    @Override
    public boolean containsInDataBase(String name) {
        Set<User> userStream = dataBase.select();
        return (userStream.stream().anyMatch((x) -> x.getName().equals(name)));
    }

    @Override
    public String[] processingForDataBase(String stringToProcess) {
        String[] idWithName = stringToProcess.split(",");
        idWithName[0] = idWithName[0].trim();
        idWithName[1] = idWithName[1].trim();
        return idWithName;
    }

    @Override
    public void displayId(String name) {
        Set<User> userStream = dataBase.select();
        userStream.stream().
                filter(s -> s.getName().equals(name)).
                map(User::getId).
                forEach(System.out::println);
    }
}
