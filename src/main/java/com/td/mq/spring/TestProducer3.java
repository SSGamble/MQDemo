package com.td.mq.spring;

import com.td.mq.ActiveMQUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试生产者，发送 100 条消息
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_jms.xml")
public class TestProducer3 {

    @Autowired
    private Producer producer;

    @Before
    public void checkServer() {
        ActiveMQUtil.checkServer();
    }

    @Test
    public void testSend() {
        for (int i = 0; i < 100; i++) {
            producer.sendTextMessage("消息 " + i);
        }
    }
}