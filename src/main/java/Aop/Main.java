package Aop;

public class Main {
    public static void main(String[] args) {
        Calculator target = new CalculatorProxyImpl();
        Calculator proxy = new CalculatorLoggingProxy(target).getLoggingPrroxy();

        int result = proxy.add(5, 5);
        System.out.println("------>" + result);
    }





}
