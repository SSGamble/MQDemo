package com.td.mq.activemq;

import cn.hutool.core.util.NetUtil;
import javax.swing.*;

/**
 * 工具类
 */
public class ActiveMQUtil {

    public static void main(String[] args) {
        checkServer();
    }

    /**
     * 判断 activemq 服务器是否启动
     */
    public static void checkServer() {
        if(NetUtil.isUsableLocalPort(8161)) {
            JOptionPane.showMessageDialog(null, "ActiveMQ 服务器未启动 ");
            System.exit(1);
        }
    }
}