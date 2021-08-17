package com.den.javacourseV2.facades;

import com.den.javacourseV2.dataBase.DataBase;
import com.den.javacourseV2.user.User;
import com.den.javacourseV2.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataBaseFacadeImpl implements DataBaseFacade{
    @Autowired
    private UserService userService;
    @Autowired
    private DataBase dataBase;
    @Override
    public void saveCorrectData(String stringForSave) {
        String[] idAndName = userService.processingForDataBase(stringForSave);
        User user = new User(Integer.parseInt(idAndName[0]), idAndName[1]);
        dataBase.save(user);
    }
}
