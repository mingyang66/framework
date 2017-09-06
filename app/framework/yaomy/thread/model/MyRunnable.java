
package framework.yaomy.thread.model;

import framework.yaomy.thread.example.NotThreadSafe;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月6日 下午2:11:08
 */
public class MyRunnable implements Runnable{

	private NotThreadSafe notThreadSafe;
	public MyRunnable(NotThreadSafe notThreadSafe) {
		this.notThreadSafe = notThreadSafe;
	}
	@Override
	public void run() {
		this.notThreadSafe.add("你好==");
		System.out.println("==============");
		
	}

}
