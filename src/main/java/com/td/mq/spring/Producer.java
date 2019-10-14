package com.td.mq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 生产者类
 */
@Component
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination textDestination;

    public void sendTextMessage(final String text){
        jmsTemplate.send(textDestination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }
}
