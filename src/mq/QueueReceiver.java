package mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by dongzhang on 5/8/17.
 */
public class QueueReceiver {
    public static void main(String[] args) throws Exception{
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = cf.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");

        MessageConsumer consumer = session.createConsumer(destination);

        int i = 0;
        while (i < 3){
            i++;
            TextMessage message = (TextMessage) consumer.receive();
            session.commit();
            System.out.println("收到消息：" + message.getText());
        }
        session.close();
        connection.close();
    }
}
