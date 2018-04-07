package spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import spring.ioc.Action;

/**
 * Created by dongzhang on 5/26/17.
 */
public class ApplicationContext_ {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:ioc.xml");
        System.out.println("sum:"+applicationContext.getBeanDefinitionCount());
        ((Action)applicationContext.getBean("action")).execute();
    }
}
