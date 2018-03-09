package com.wll.test.Mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqConnection {

	private final static String QUEUE_NAME = "user.queue.send.gift.wll";// 队列名不能重复 之前已有就会失败  
	  
    public static void main(String[] argv) throws Exception {  
  
        /* 使用工厂类建立Connection和Channel，并且设置参数 */  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("118.89.225.85");// MQ的IP  
        factory.setPort(5672);// MQ端口  
        factory.setUsername("admin");// MQ用户名  
        factory.setPassword("czy.13614351220");// MQ密码  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
  
        /* 创建消息队列，并且发送消息 */  
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);  
        String message = "这是消息1";  
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());  
        System.out.println("生产了个'" + message + "'");  
  
        /* 关闭连接 */  
        channel.close();  
        connection.close();  
    }  
}
