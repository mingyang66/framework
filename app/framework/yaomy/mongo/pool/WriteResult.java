
package framework.yaomy.mongo.pool;
/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月21日 下午2:55:02
 */
public class WriteResult {

	private long modifiedCount;
	
	WriteResult(long modifiedCount) {
		this.modifiedCount = modifiedCount;
	}

	public long getModifiedCount() {
		return modifiedCount;
	}
	
}
