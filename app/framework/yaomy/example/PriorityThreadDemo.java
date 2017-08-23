
package framework.yaomy.example;

import java.util.concurrent.ThreadPoolExecutor;

import framework.yaomy.thread.pool.GGPriorityTask;
import framework.yaomy.thread.pool.GGThreadPool;
import framework.yaomy.thread.pool.GGThreadPoolBuilder;
import framework.yaomy.thread.pool.GGThreadPoolExecutor;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月23日 下午3:34:05
 */
public class PriorityThreadDemo extends GGPriorityTask{

	private Integer num;
	
	public PriorityThreadDemo(Integer num) {
		this.setPriority(10);
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println("开始执行线程。。。。。。。。。。。。。。。"+num);
		
	}
	public static void main(String[] args) {
		GGThreadPoolBuilder.initThreadPool();
		for(int i=0;i<11000;i++){
			GGThreadPool.commit(new PriorityThreadDemo(i));
			System.out.println(i);
		}
	}
}
