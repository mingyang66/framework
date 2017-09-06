
package framework.yaomy.thread.pool;

import play.PlayPlugin;
import framework.yaomy.log.GGLogger;

/**
 * @Description:线程插件
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月23日 下午3:16:00
 */
public class GGThreadPoolPlugin  extends PlayPlugin{
	 public void onApplicationStart() {	
		 GGThreadPoolBuilder.initThreadPool();
		 GGLogger.info("线程池初始化成功...");
	 }
	 public void onApplicationStop() {
		 GGThreadPoolBuilder.destory();
	 }
}
