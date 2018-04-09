package spring.proxy.static_proxy;

/**
 * Created by dongzhang on 5/13/17.
 */
public class RealSubject implements Subject{
    @Override
    public void sayHello() {
        System.out.println("real Hello World");
    }

    @Override
    public void sayGoodbye() {
        System.out.println("real GoodBye World");
    }
}
