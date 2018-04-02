package mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by dongzhang on 5/8/17.
 */
public class QueueSender {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 3; i++) {
            TextMessage message = session.createTextMessage("message----"+i);
            Thread.sleep(1000);
            producer.send(message);
            System.out.println("发送消息：------"+i);
        }

        session.commit();
        session.close();

        connection.close();
    }
}
