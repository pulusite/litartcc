package spring.proxy;

/**
 * Created by dongzhang on 5/13/17.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("------add------");
    }
}
