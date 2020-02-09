package Aop.Impl;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(public int Aop.Impl.Calculator.*(int,int ))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method: " + methodName + " begins with " + args);
    }
}
