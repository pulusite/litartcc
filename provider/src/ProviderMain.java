import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by zhangdong on 2018/4/2.
 */
public class ProviderMain {
    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( new String[] { "dubbo-provider.xml" });
        context.start();

        System.out.println("输入任意按键退出 ~ ");
        System.in.read();
        context.close();
    }
}
