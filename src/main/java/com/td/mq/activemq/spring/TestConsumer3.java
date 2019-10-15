package com.td.mq.activemq.spring;

import com.td.mq.activemq.ActiveMQUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.IOException;

/**
 * 消费者测试类，他其实什么都没做。 虽然它什么都没做，但是因为他是运行在 spring 框架下的测试，所以一旦启动，
 * 就会导致一个新的 DefaultMessageListenerContainer 被启动，间接地导致 一个新的 MyMessageListener 被启动。
 * 于是也就充当了消费者的角色了。
 *
 * 其中的 System.in.read(); 是为了这个测试类不退出，可以一直监听用。
 * 与这个类似的， TestProducer 类的启动，也会导致一个 MyMessageListener 被启动，
 * 所以 TestProducer 本身既是一个生产者，也是一个消费者。
 * 于是在一开始的测试 先运行，看到效果，再学习 里，也就有了 两个消费者存在的截图了。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring_jms.xml")
public class TestConsumer3 {
    @Before
    public void checkServer() {
        ActiveMQUtil.checkServer();
    }

    @Test
    public void test(){
        try {
            // 写这个是为了不让当前测试退出。  因为 spring 的配置， MyMessageListener 会自动启动
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}