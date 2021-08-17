package com.den.javacourseV2;

import com.den.javacourseV2.springFile.SpringConfig;
import com.den.javacourseV2.facades.AppWorkFacade;
import com.den.javacourseV2.facades.AppWorkFacadeImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        AppWorkFacade start = context.getBean("applicationLaunchFacade", AppWorkFacadeImpl.class);
        start.startApp();
    }
}


