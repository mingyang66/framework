
package shiro;

import java.util.Arrays;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * 单个Realm配置
 * @Description:域，Shiro从从Realm获取安全数据（如用户、角色、权限）
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月13日 下午6:03:43
 */
public class MyRealm2 implements Realm{

	/**
	 * 
	 * @Description:返回唯一的Realm名字
	 * @author yaomy
	 * @date 2017年9月13日 下午6:04:21
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "myrealm2";
	}

	/**
	 * 
	 * @Description:判断此Realm是否支持此token
	 * @author yaomy
	 * @date 2017年9月13日 下午6:04:43
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		// 仅支持UsernamePasswordToken类型的token
		return token instanceof UsernamePasswordToken;
	}

	/**
	 * 
	 * @Description:根据token获取认证信息
	 * @author yaomy
	 * @date 2017年9月13日 下午6:05:20
	 */
	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		String username = (String)token.getPrincipal();//用户名（认证）
		String password = new String((char[])token.getCredentials());//用户密码（凭证）
		
		if(!username.equals("zhang")){
			throw new UnknownAccountException();
		}
		if(!password.equals("123")){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
