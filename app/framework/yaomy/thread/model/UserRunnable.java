package framework.yaomy.thread.model;
/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomingyang
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月3日 上午10:50:23
 */
public class UserRunnable implements Runnable{

	private Counter counter = null;
	public UserRunnable(Counter counter) {
		this.counter = counter;
	}
	@Override
	public void run() {
		
		System.out.println("线程："+Thread.currentThread().getName()+",计数器的值是"+counter.getCount());
	}

}
