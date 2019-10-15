package com.td.mq.activemq.topic;

import com.td.mq.activemq.ActiveMQUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

/**
 * 生产者，公众号，生产 100 条消息
 */
public class TestProducer2 {

    // 服务地址，端口默认 61616
    private static final String url="tcp://127.0.0.1:61616";
    // 这次发送的消息名称
    private static final String topicName="topic_style";

    public static void main(String[] args) throws JMSException {
        // 0. 先判断端口是否启动了  Active MQ 服务器
        ActiveMQUtil.checkServer();
        // 1.创建 ConnectionFactory，绑定地址
        ConnectionFactory factory=new ActiveMQConnectionFactory(url);
        // 2.创建 Connection
        Connection connection= factory.createConnection();
        // 3.启动连接
        connection.start();
        // 4.创建会话
        Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5.创建一个目标 (主题类型)
        Destination destination=session.createTopic(topicName);
        // 6.创建一个生产者
        MessageProducer producer=session.createProducer(destination);
        // 循环创建 100 条消息
        for (int i = 0; i < 100; i++) {
            // 7.创建消息
            TextMessage textMessage=session.createTextMessage("主题消息-"+i);
            // 8.发送消息
            producer.send(textMessage);
            System.out.println("发送："+textMessage.getText());
        }
        // 9. 关闭连接
        connection.close();
    }
}
