
package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://jinnianshilongnian.iteye.com/blog/2019547
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月13日 下午4:37:09
 */
public class RealmDemo {
	private static final transient Logger log = LoggerFactory.getLogger(RealmDemo.class);
	public static void main(String[] args) {
		//获取SecurityManager安全管理器工厂类，此处使用shiro.ini文件进行初始化
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("conf/shiro-realm.ini");
		//获取SecurityManager安全管理器实例,并绑定给SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//获取主题
		Subject subject = SecurityUtils.getSubject();
		//创建用户名密码身份验证token(即：用户身份/凭证)
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try{
			//登录，即身份验证
			subject.login(token);
			log.info("登录成功");
		} catch(AuthenticationException e){
			log.info("身份验证失败"+e);
		}
		
		subject.logout();
	}
}
