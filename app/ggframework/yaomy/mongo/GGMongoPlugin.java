package ggframework.yaomy.mongo;

import ggframework.yaomy.config.GGConfigurer;
import ggframework.yaomy.log.GGLogger;
import play.PlayPlugin;

public class GGMongoPlugin extends PlayPlugin{

	 public void onApplicationStart() {	
		 GGConfigurer.load("conf/application.conf");
		 GGMongoClientPool.pool.initPool(GGMongoClients.getClients());
		 GGLogger.info("数据库初始化成功...");
	 }
	 public void onApplicationStop() {
		 GGMongoClientPool.pool.destoryPool();
	 }
}
