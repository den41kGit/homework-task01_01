package com.den.javacourseV2;

import com.den.javacourseV2.springFile.SpringConfig;
import com.den.javacourseV2.facades.ApplicationLaunchFacade;
import com.den.javacourseV2.facades.ApplicationLaunchFacadeImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        ApplicationLaunchFacade start = context.getBean("applicationLaunchFacade", ApplicationLaunchFacadeImpl.class);
        start.startApp();
    }
}


