
package framework.yaomy.thread;
/**
 * @Description:优先级线程
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月23日 下午3:27:29
 */
public class GGPriorityTask implements Comparable<GGPriorityTask>, Runnable{

	private Integer priority;
	
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * 
	 * @Description:当前线程的优先级如果想小于传入对象的优先级返回-1
	 * @author yaomy
	 * @date 2017年8月23日 下午3:53:42
	 */
	@Override
	public int compareTo(GGPriorityTask o) {
		return o.getPriority().compareTo(this.priority);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
