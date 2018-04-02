package mq;

import org.apache.activemq.broker.BrokerService;

/**
 * Created by dongzhang on 5/8/17.
 */
public class BrokerInner {
    public static void main(String[] args) throws Exception{
        BrokerService broker = new BrokerService();
        broker.setUseJmx(true);
        broker.addConnector("");
        broker.start();
    }
}
