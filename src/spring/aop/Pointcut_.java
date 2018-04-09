package spring.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

/**
 * Created by dongzhang on 5/26/17.
 */
public class Pointcut_ implements Pointcut{
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            public boolean matches(Method method, Class<?> aClass) {
                if (method.getName().equals("tar1"))
                    return true;
                return false;
            }

            public boolean isRuntime() {
                return true;
            }

            public boolean matches(Method method, Class<?> aClass, Object... objects) {
                if (method.getName().equals("tar1"))
                    return true;
                return false;
            }
        };
    }
}
