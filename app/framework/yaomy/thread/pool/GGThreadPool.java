
package framework.yaomy.thread.pool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月23日 下午3:49:17
 */
public class GGThreadPool {
	/**
	 * 
	 * @Description:获取线程池对象
	 * @author yaomy
	 * @date 2017年8月23日 下午3:50:53
	 */
	private static ThreadPoolExecutor getChannel() {
		return  GGThreadPoolExecutor.pools.getThreadPool();
	}
	/**
	 * 提交 任务给线程池
	 * @param task
	 */
	public static void commit(Runnable task){
		getChannel().execute(task);
	}
}
