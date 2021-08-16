package com.den.javacourseV2.springFile;

import com.den.javacourseV2.dataBase.DataBase;
import com.den.javacourseV2.dataBase.DefaultDataBase;
import com.den.javacourseV2.facades.ApplicationLaunchFacade;
import com.den.javacourseV2.facades.ApplicationLaunchFacadeImpl;
import com.den.javacourseV2.facades.InputFacade;
import com.den.javacourseV2.facades.InputFacadeimpl;
import com.den.javacourseV2.input.InputImpl;
import com.den.javacourseV2.input.InputService;
import com.den.javacourseV2.output.OutputImpl;
import com.den.javacourseV2.output.OutputService;
import com.den.javacourseV2.user.User;
import com.den.javacourseV2.user.UserImpl;
import com.den.javacourseV2.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.den.javacourseV2")
@PropertySource("classpath:file.properties")
public class SpringConfig {
    @Bean
    public ApplicationLaunchFacade applicationLaunchFacade(){
        return new ApplicationLaunchFacadeImpl(inputFacade(), outputService(), inputService(), userService() );
    }
    @Bean
    public OutputService outputService(){
        return new OutputImpl();
    }

    @Bean
    public InputFacade inputFacade(){
        return new InputFacadeimpl(inputService(), userService(), dataBase());
    }
    @Bean
    public InputService inputService(){
        return new InputImpl();
    }
    @Bean
    public UserService userService(){
        return new UserImpl(dataBase());
    }
    @Bean
    public DataBase<User> dataBase(){
        return new DefaultDataBase();
    }
}
