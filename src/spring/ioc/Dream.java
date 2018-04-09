package spring.ioc;


/**
 * Created by dongzhang on 5/26/17.
 */
public class Dream {
    private Action action;

    public void chasing(){
        action.execute();
        System.out.println("行动梦想才有可能实现");
    }
}
