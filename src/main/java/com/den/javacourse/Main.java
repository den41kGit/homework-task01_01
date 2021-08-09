package com.den.javacourse;

import com.den.javacourse.classFacade.ApplicationLaunchFacadeService;
import com.den.javacourse.classFacade.ApplicationLaunchImpl;
import com.den.javacourse.springConfig.SpringConfig;
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
