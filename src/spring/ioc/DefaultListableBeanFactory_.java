package spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import spring.ioc.Action;

/**
 * Created by dongzhang on 5/26/17.
 */
public class DefaultListableBeanFactory_ {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("ApplicationContext.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
        System.out.println("num:"+defaultListableBeanFactory.getBeanDefinitionCount());
        ((Action)defaultListableBeanFactory.getBean("action")).execute();
    }
}
