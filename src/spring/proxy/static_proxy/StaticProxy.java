package spring.proxy.static_proxy;

/**
 * Created by dongzhang on 5/13/17.
 */
public class StaticProxy {
    private RealSubject realSubject = null;
    public StaticProxy(){}
    public void sayHello(){
        //用到的时候才加载，懒加载
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.sayHello();
    }
}
