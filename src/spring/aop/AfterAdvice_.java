package spring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by dongzhang on 5/26/17.
 */
public class AfterAdvice_ implements AfterReturningAdvice{
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after "+ target.getClass().getSimpleName() + "." + method.getName() + "()");
    }
}
