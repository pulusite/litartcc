package spring.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * Created by dongzhang on 5/26/17.
 */
public class Advisor_ implements PointcutAdvisor{
    public Advice getAdvice() {
        return new AfterAdvice_();
    }

    public boolean isPerInstance() {
        return false;
    }

    public Pointcut getPointcut() {
        return new Pointcut_();
    }
}
