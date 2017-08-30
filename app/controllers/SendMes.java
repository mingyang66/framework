package controllers;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import framework.yaomy.config.GGConfigurer;

public class SendMes {
	  private final static String QUEUE_NAME = "hello";
	  
	  public static void main(String[] argv) throws Exception {
		GGConfigurer.load("conf/application.conf");
		
		String HOST = GGConfigurer.getKey("ggmes.host");
		int PORT = GGConfigurer.getInteger("ggmes.port");
		String VHOST = GGConfigurer.getKey("ggmes.vhost");
		String USERNAME = GGConfigurer.getKey("ggmes.username");
		String PASSWORD = GGConfigurer.getKey("ggmes.password");
		System.out.println(GGConfigurer.getDouble("ggmes.host"));
		
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(HOST);
	    factory.setPort(PORT);
	    factory.setUsername(USERNAME);
	    factory.setPassword(PASSWORD);
	    factory.setVirtualHost(VHOST);
	    
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    String message = "Hello World!===========================";
	    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
	    System.out.println(" [x] Sent '" + message + "'");

	    channel.close();
	    connection.close();
	  }
}
