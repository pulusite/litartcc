package spring.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by zhangdong on 4/1/18.
 */
public class Factory {
    public static Base getInstance(CglibProxy proxy){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Base.class);
        enhancer.setCallback(proxy);
        Base base=(Base)enhancer.create();
        return base;
    }
}
