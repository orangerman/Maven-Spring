package Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorLoggingProxy {
    //要代理的对象
    private Calculator target;

    public CalculatorLoggingProxy(Calculator calculator) {
        this.target = calculator;
    }

    public Calculator getLoggingPrroxy() {
        Calculator proxy = null;

        ClassLoader loader = target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{Calculator.class};
        InvocationHandler h = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("The method " + methodName + " begins with" + Arrays.asList(args));
                Object result = method.invoke(target,args);
                System.out.println("The method " + methodName + " ends with " + result);
                return result;
            }
        };
        proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, h);
        return proxy;


    }
}
