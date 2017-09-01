package framework.yaomy.thread.example;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

import framework.yaomy.thread.model.User;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomingyang
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月27日 上午10:32:48
 */
public class PriorityBlockQueueDemo {

	public static void main(String[] args) {
		PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>();
		for(int i=0; i<12; i++){
			User user = new User(i, "sdf");
	        int max=20;
	        int min=10;
	        Random random = new Random();

	        int n = random.nextInt(max)%(max-min+1) + min;

			user.setPriority(n);
			user.setUsername("李艳第"+i+"天");
			
			queue.add(user);
		}
		
		for(int i=0; i<12; i++){
			User u = queue.poll();
			System.out.println("优先级是："+u.getPriority()+","+u.getUsername());
		}
	}
}
