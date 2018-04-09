package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by dongzhang on 5/26/17.
 */
public class AopDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:aop.xml");
        Target_ target_ = (Target_) applicationContext.getBean("aopDemo_");
        target_.tar1();
        System.out.println("----哈哈哈————");
        target_.tar2();
    }
}
