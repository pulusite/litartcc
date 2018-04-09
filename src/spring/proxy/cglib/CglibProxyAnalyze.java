package spring.proxy.cglib;

/**
 * Created by zhangdong on 4/1/18.
 */
public class CglibProxyAnalyze {
    public static void main(String[] args) {
        CglibProxy proxy=new CglibProxy();
        Base base=Factory.getInstance(proxy);
        base.add();
    }
}
