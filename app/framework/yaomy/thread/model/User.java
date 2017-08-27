package framework.yaomy.thread.model;


/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomingyang
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月27日 上午10:33:48
 */
public class User implements Comparable<User>{

	private Integer priority;
	private String username;
	
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @Description:当前对象和其他对象做比较，当前优先级大就返回-1，优先级小就返回1
	 * 值越小优先级越高
	 * @param TODO
	 * @author yaomingyang
	 * @date 2017年8月27日 上午11:28:10
	 */
	@Override
	public int compareTo(User user) {
//		System.out.println("比较结果"+this.priority.compareTo(user.getPriority()));
		return this.priority.compareTo(user.getPriority());
	}
}
