package spring.aop.cardemo;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by zhangdong on 4/7/18.
 */
public class CarLogger {
    public void beforeRun(){
        System.out.println("car is going to run");
    }

    public void afterRun(){
        System.out.println("car is running");
    }

    public void aroundRun(ProceedingJoinPoint joinpoint){
        System.out.println("car is going to run ");
        try {
            //调用被代理的对象的目标方法，本例中指向Car.go()方法
            joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("car is running");
    }
}
