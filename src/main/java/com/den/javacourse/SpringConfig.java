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
    public ApplicationLaunchFacadeService applicationLaunchFacadeService(){
        return new ApplicationLaunchImpl(
                inputFacadeService(),
                requestToGetInfoService(),
                inputNameForGetID(),
                checkUserInDataBase(),
                userInformationService()
        );
    }
    @Bean
    public RequestToGetInfoService requestToGetInfoService(){
        return new RequestToGetUserInfo();
    }
    @Bean
    public InputService inputNameForGetID(){
        return new InputNameForGetID();
    }
    @Bean
    public CheckInputService checkUserInDataBase(){
        return new CheckUserInDataBase(dataBaseService());
    }
    @Bean
    public UserInformationService userInformationService(){
        return new GetUserIdByName(dataBaseService());
    }

    @Bean
    public InputFacadeService inputFacadeService(){
        return new InputFacadeImpl(
                inputUserName(),
                checkInput(),
                processingService(),
                dataBaseService()
        );
    }
    @Bean
    public InputService inputUserName(){
        return new InputUserName();
    }
    @Bean
    public CheckInputService checkInput(){
        return new CheckInput();
    }
    @Bean
    public ProcessingService processingService(){ return new UserProcessingForDataBase(); }
    @Bean
    public DataBaseService dataBaseService(){
        return new DefaultDataBase();
    }


}
