package Aop.Impl;


import jdk.nashorn.internal.scripts.JO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;


@Order(2)
@Component
@Aspect
public class LoggingAspect {

    /**
     * 定义一个方法，用于声明切入点表达式，一般低，该方法不再需要填入其他方法
     * 使用@Ponint来声明切入点表达式
     */
    @Pointcut("execution(public int Aop.Impl.Calculator.*(int,int ))")
    public void declareJointPointExpression() {

    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method: " + methodName + " begins with " + args);
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");

    }

    /**
     * 返回通知
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "declareJointPointExpression()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {

        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }


    /**
     * 在目标方法出现异常时会执行的代码
     * 可以访问到异常对象；且可以指定出现特定异常时才出现通知代码 比如NullPointException ex
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "declareJointPointExpression()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("The method " + methodName + " occurs exception " + ex);
    }

//    /**
//     * 环绕通知需要携带ProceedingJoinPoint类型的参数
//     * 类似于动态dialing的全过程，这个类型的参数可以决定是否执行目标方法
//     * 且必须有返回值，返回值即为目标方法的返回值
//     * @param pjd
//     */
//    @Around("execution(public int Aop.Impl.Calculator.*(int,int ))")
//    public Object aroundMethod(ProceedingJoinPoint pjd)  {
//        Object result = null;
//        String methodName = pjd.getSignature().getName();
//        try {
//            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
//            result = pjd.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return result;
//
//    }
}
