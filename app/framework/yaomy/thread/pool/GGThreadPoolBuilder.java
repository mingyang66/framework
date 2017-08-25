
package framework.yaomy.thread.pool;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import framework.yaomy.config.GGConfigurer;

/**
 * @Description:线程池初始化
 * 合理的使用线程池能够带来3个很明显的好处：
 * 1.降低资源消耗：通过重用已经创建的线程来降低线程创建和销毁的消耗
 * 2.提高响应速度：任务到达时不需要等待线程创建就可以立即执行。
 * 3.提高线程的可管理性：线程池可以统一管理、分配、调优和监控。
 * 
 * 核心线程池和最大线程大小
 * 一个ThreadPoolExecutor将会根据核心线程池和最大线程大小的边界自动的调整线程池大小，如果正在运行的线程数比核心线程池小，
 * 即使其它的工作线程空闲着也将会创建一个新的线程来处理新的任务，如果正在运行的线程大于核心线程池小于最大线程，只有在队列满的时候才会创建新的线程。
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月23日 下午2:53:11
 */
public class GGThreadPoolBuilder {

	public static void initThreadPool(){
		//核心线程池大小
		int corePoolSize = GGConfigurer.getInteger("ggthreadpool.coresize", Runtime.getRuntime().availableProcessors()*2);
		//线程池最大容量大小
		int maximumPoolSize = GGConfigurer.getInteger("ggthreadpool.maxsize", corePoolSize*2);
		//线程池空闲时，线程存活的时间
		int keepAliveTime = 60;
		//队列大小
		int queue_size = GGConfigurer.getInteger("ggthreadpool.queuesize", 10000);
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
				corePoolSize, 
				maximumPoolSize, 
				keepAliveTime, 
				TimeUnit.SECONDS, 
				/**
				 * 优先级队列必须是实现Comparable接口，队列通过这个接口的compare方法确定对象的priority。
				 * 当前和其他对象比较，如果compare方法返回负数，那么在队列里面的优先级就比较搞
				 */
				new PriorityBlockingQueue<Runnable>(queue_size)); 
		
		GGThreadPoolExecutor.pools.init(threadPool);
	}
	public static void destory() {
		GGThreadPoolExecutor.pools.destoryThreadPool();
	}
}
