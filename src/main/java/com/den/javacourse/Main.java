package com.den.javacourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        InputData input = context.getBean("input", InputData.class);
        input.dataProcessing();


    }

}
