package com.den.javacourse.springConfig;

import com.den.javacourse.check.CheckInput;
import com.den.javacourse.check.CheckInputService;
import com.den.javacourse.check.CheckUserInDataBase;
import com.den.javacourse.classFacade.ApplicationLaunchFacadeService;
import com.den.javacourse.classFacade.ApplicationLaunchImpl;
import com.den.javacourse.classFacade.InputFacadeImpl;
import com.den.javacourse.classFacade.InputFacadeService;
import com.den.javacourse.dataBase.DataBaseService;
import com.den.javacourse.dataBase.DefaultDataBase;
import com.den.javacourse.input.InputNameForGetID;
import com.den.javacourse.input.InputService;
import com.den.javacourse.input.InputUserName;
import com.den.javacourse.processing.ProcessingService;
import com.den.javacourse.processing.UserProcessingForDataBase;
import com.den.javacourse.request.RequestToGetInfoService;
import com.den.javacourse.request.RequestToGetUserInfo;
import com.den.javacourse.userInformation.UserIdByName;
import com.den.javacourse.userInformation.UserInformationService;
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
        return new UserIdByName(dataBaseService());
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
