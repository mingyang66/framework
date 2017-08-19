package controllers;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import ggframework.yaomy.config.GGConfigurer;

public class RecvMes {
	 private final static String QUEUE_NAME = "hello";

	  public static void main(String[] argv) throws Exception {
		GGConfigurer.load("conf/application.conf");
		String HOST = GGConfigurer.getKey("ggmes.host");
		int PORT = GGConfigurer.getInteger("ggmes.port");
		String VHOST = GGConfigurer.getKey("ggmes.vhost");
		String USERNAME = GGConfigurer.getKey("ggmes.username");
		String PASSWORD = GGConfigurer.getKey("ggmes.password");
		
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(HOST);
	    factory.setPort(PORT);
	    factory.setUsername(USERNAME);
	    factory.setPassword(PASSWORD);
	    factory.setVirtualHost(VHOST);
	    
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
	          throws IOException {
	        String message = new String(body, "UTF-8");
	        System.out.println(" [x] Received '" + message + "'");
	      }
	    };
	    channel.basicConsume(QUEUE_NAME, true, consumer);
	  }
}
