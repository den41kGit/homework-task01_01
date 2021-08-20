package com.den.javacourseV2;

import com.den.javacourseV2.springFile.SpringConfig;
import com.den.javacourseV2.facades.AppWorkFacade;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        AppWorkFacade start = context.getBean("appWorkFacade", AppWorkFacade.class);
        start.startApp();
    }
}


