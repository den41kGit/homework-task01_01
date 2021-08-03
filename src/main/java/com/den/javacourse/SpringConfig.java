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
    public InputFacadeService inputFacadeService(){
        return new InputFacadeImpl(inputService(), checkInputService(), dataBaseService());
    }
    @Bean
    public InputService inputService(){
        return new InputUserName();
    }
    @Bean
    public CheckInputService checkInputService(){
        return new CheckInput();
    }
    @Bean
    public DataBaseService dataBaseService(){
        return new DefaultDataBase();
    }


}
