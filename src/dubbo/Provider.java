package dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangdong on 2018/4/8.
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"dubbo-provider.xml"});
        context.start();
        // press any key to exit
        System.in.read();
    }
}
