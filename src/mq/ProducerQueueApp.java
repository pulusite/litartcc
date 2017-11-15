package mq;

/**
 * Created by zhangdong on 2017/11/15.
 */
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

/**
 * Producer 功能描述：ActiveMQ生产者实例
 *
 * @author RickyLee
 * @date 2016/11/3 13:17
 */
public class ProducerQueueApp {

    private static final String BROKER_URL = "tcp://127.0.0.1:61616";
    private static final String SUBJECT = "test-activemq-queue";

    public static void main(String[] args) throws JMSException {
        //初始化连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        //获得连接
        Connection conn = connectionFactory.createConnection();
        //启动连接，因为默认是关闭的
        conn.start();

        //创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建队列
        Destination dest = session.createQueue(SUBJECT);
        //createTopic方法用来创建Topic
        //session.createTopic("TOPIC");

        //通过session可以创建消息的生产者
        MessageProducer producer = session.createProducer(dest);
        for (int i = 0; i < 5; i++) {
            //初始化一个mq消息
            TextMessage message = session.createTextMessage("hello active mq 中文" + i);
            //发送消息
            producer.send(message);
        }

        //关闭mq连接
        conn.close();
    }
}
