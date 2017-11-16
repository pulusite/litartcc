package rpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangdong on 2017/11/16.
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:F:/github/litartcc/src/resources/dubbo-consumer.xml");
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println(hello);
    }
}