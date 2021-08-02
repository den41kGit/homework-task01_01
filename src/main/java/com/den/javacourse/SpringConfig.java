package com.den.javacourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.den.javacourse")
@PropertySource("classpath:file.properties")
public class SpringConfig {

    @Bean
    public InputData input(){
        return new InputData(checkInputDate());
    }
    @Bean
    public CheckInputDate checkInputDate(){
        return new CheckInputDate(dataBaseService());
    }
    @Bean
    public DataBaseService dataBaseService(){
        return new SimpleDataBase();
    }
}
