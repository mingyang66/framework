package framework.yaomy.thread.model;
/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomingyang
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月3日 上午11:41:37
 */
public class Counter {


	protected long count = 0;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
			this.count = this.count + count;
	}
   	

}
