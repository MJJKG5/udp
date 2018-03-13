/**
 * 代码归 MAJUNJIE 所有，任何公司和个人不得擅自使用，我方保留通过法律手段追究责任的权利.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package com.java.udp;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author mjj
 * @version Id:Client.java v 0.1 2018年03月13日 上午11:11 MJJ Exp $
 */
public class Client {
    private final Logger logger = Logger.getLogger(Client.class);
    private final String ip = "127.0.0.1";
    private final Integer port = 8090;

    /**
     * UDP客户端
     */
    @Test
    public void udpClient() {
        try {
            // 定义UDP客户端
            DatagramSocket socket = new DatagramSocket();
            logger.info("服务启动...");

            // 定义发送数据
            String sms = "UDP案例测试...";
            byte[] bytes = sms.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName(ip), port);

            // 发送
            socket.send(packet);
            logger.info("发送完成!!!");

            // 关闭
            socket.close();
            logger.info("关闭!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
