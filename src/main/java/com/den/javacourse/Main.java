package com.den.javacourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        ApplicationLaunchFacadeService start = context.getBean(
                "applicationLaunchFacadeService", ApplicationLaunchImpl.class
        );
        start.startApp();

    }
}
