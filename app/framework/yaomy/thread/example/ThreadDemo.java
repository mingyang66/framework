package framework.yaomy.thread.example;

import framework.yaomy.thread.model.Counter;
import framework.yaomy.thread.model.UserRunnable;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomingyang
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月3日 上午10:48:50
 */
public class ThreadDemo {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		for(int i=1;i<6;i++){
			counter.setCount(1);
			Thread thread = new Thread(new UserRunnable(counter), "线程"+i);
			thread.start();
		}
	}
}
