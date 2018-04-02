import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangdong on 2018/4/2.
 */
public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "dubbo-consumer.xml" });
        context.start();
        DemoService service = (DemoService) context.getBean("demoService");
        System.out.println(service.sayHello("world"));
        context.close();
    }
}
