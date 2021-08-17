package com.den.javacourseV2.springFile;

import com.den.javacourseV2.dataBase.DataBase;
import com.den.javacourseV2.dataBase.DefaultDataBase;
import com.den.javacourseV2.facades.*;
import com.den.javacourseV2.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.den.javacourseV2")
@PropertySource("classpath:file.properties")
public class SpringConfig {
    @Bean
    public AppWorkFacade applicationLaunchFacade(){
        return new AppWorkFacadeImpl();
    }
    @Bean
    public DataBase<User> dataBase(){
        return new DefaultDataBase();
    }
}
