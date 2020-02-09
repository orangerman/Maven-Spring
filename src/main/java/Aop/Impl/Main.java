package Aop.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("AopImplContext.xml");
        Calculator calculator = ctx.getBean(Calculator.class);
        int result = calculator.add(5, 5);
        System.out.println(result);


        result = calculator.div(100, 12);
        System.out.println(result);


    }
}
