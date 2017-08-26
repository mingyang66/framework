
package framework.yaomy.thread.pool;

import java.util.concurrent.ThreadPoolExecutor;

import framework.yaomy.log.GGLogger;

/**
 * @Description:线程池
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
		ThreadPoolExecutor pool = GGThreadPoolExecutor.pools.getThreadPool();
		GGLogger.info("是否允许核心线程池中的线程终止："+pool.allowsCoreThreadTimeOut()+",核心线程池大小是："+pool.getCorePoolSize()+"，最大线程池大小是："+pool.getMaximumPoolSize()
		+",线程池中线程的数量是："+pool.getPoolSize()+",线程池中正在执行线程的数量："+pool.getActiveCount()+"，线程池同时运行的线程最大数量是："+pool.getLargestPoolSize()
		+"，队列大小是："+pool.getQueue().size());
		
		GGLogger.info("最大"+pool.getLargestPoolSize()+"队列："+pool.getQueue().size());
		return  pool;
	}
	/**
	 * 提交 任务给线程池
	 * @param task
	 */
	public static void commit(Runnable task){
		getChannel().execute(task);
	}
}
