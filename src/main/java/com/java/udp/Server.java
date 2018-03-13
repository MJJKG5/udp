/**
 * 代码归 MAJUNJIE 所有，任何公司和个人不得擅自使用，我方保留通过法律手段追究责任的权利.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package com.java.udp;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author mjj
 * @version Id:Server.java v 0.1 2018年03月13日 下午2:29 MJJ Exp $
 */
public class Server {

    private final Logger logger = Logger.getLogger(Server.class);

    private final Integer port = 8090;

    /**
     * UDP服务器
     */
    public void udpServer() {
        try {
            // 设置监听端口
            final DatagramSocket socket = new DatagramSocket(port);
            logger.info("服务启动...");

            // 读取客户端数据
            byte[] bytes = new byte[1024];
            final DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

            logger.info("监听开启...");
            // 进程监听、打印请求数据
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            // 监听
                            socket.receive(packet);

                            // 打印请求数据
                            String data = new String(packet.getData());
                            logger.info("请求数据：" + data);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().udpServer();
    }
}
