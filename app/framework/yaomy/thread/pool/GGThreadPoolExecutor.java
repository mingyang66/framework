
package framework.yaomy.thread.pool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:线程池
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月23日 下午3:10:50
 */
public enum GGThreadPoolExecutor {

	pools;
	
	private ThreadPoolExecutor threadPool = null;
	
	void init(ThreadPoolExecutor threadPool){
		this.threadPool = threadPool;
	}

	public ThreadPoolExecutor getThreadPool() {
		return threadPool;
	}
	
	public void destoryThreadPool(){
		if(this.threadPool != null && !this.threadPool.isShutdown()) {
			this.threadPool.shutdown();
		}
	}
}
