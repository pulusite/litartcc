/**
 * Created by zhangdong on 2017/11/16.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello Dubbo,Hello " + name;
    }

}