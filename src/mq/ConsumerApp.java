package mq;

/**
 * Created by zhangdong on 2017/11/15.
 */
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
/**
 * ConsumerApp 功能描述：ActiveMQ消费者实例
 */
public class ConsumerApp implements MessageListener {
    private static final String BROKER_URL = "tcp://127.0.0.1:61616";
    private static final String SUBJECT = "test-activemq-queue";

    public static void main(String[] args) throws JMSException {
        //初始化ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        //创建mq连接
        Connection conn = connectionFactory.createConnection();
        //启动连接
        conn.start();

        //创建会话
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //通过会话创建目标
        Destination dest = session.createQueue(SUBJECT);
        //创建mq消息的消费者
        MessageConsumer consumer = session.createConsumer(dest);

        //初始化MessageListener
        ConsumerApp me = new ConsumerApp();

        //给消费者设定监听对象
        consumer.setMessageListener(me);
    }

    public void onMessage(Message message) {
        TextMessage txtMessage = (TextMessage)message;
        try {
            System.out.println("get message " + txtMessage.getText());
        } catch (JMSException e) {
            System.out.println("error {}"+e);
        }
    }
}