
package framework.yaomy.example;

import java.util.concurrent.ThreadPoolExecutor;

import framework.yaomy.log.GGLogger;
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
		GGLogger.info("开始执行线程。。。。。。。。。。。。。。。"+num);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		GGThreadPoolBuilder.initThreadPool();
		for(int i=0;i<1000;i++){
			GGThreadPool.commit(new PriorityThreadDemo(i));
			GGLogger.info("最新提交："+i);
		}
		
	}
}
