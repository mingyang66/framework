
package framework.yaomy.thread.example;

import framework.yaomy.thread.model.MyRunnable;


/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月6日 下午1:59:02
 */
public class NotThreadSafe {

	private StringBuilder sb = new StringBuilder();
	public void add(String text){
		this.sb.append(text);
	}
	
	public static void main(String[] args) {
		
		NotThreadSafe sharedInstance = new NotThreadSafe();
		new Thread(new MyRunnable(sharedInstance)).start();
		new Thread(new MyRunnable(sharedInstance)).start();
	}
}
