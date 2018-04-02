package spring.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangdong on 4/1/18.
 */
public class CglibProxy implements MethodInterceptor{
    public Object intercept(Object object, Method method, Object[] args,MethodProxy proxy) throws Throwable{
        System.out.println("before--------");
        proxy.invokeSuper(object,args);
        System.out.println("after---------");
        return null;
    }
}
