package spring.aop.cardemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangdong on 4/7/18.
 */
public class App {
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Car car=(Car) context.getBean("car");
        car.go();
    }
}
