
package framework.yaomy.thread.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import framework.yaomy.thread.model.User;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月31日 下午8:16:02
 */
public class ComparableDemo {

	public static void main(String[] args) {
		
		User[] user = new User[3];
		
		user[0] = new User(3, "朝阳3");
		user[1] = new User(1, "朝阳1");
		user[2] = new User(2, "朝阳2");
		for(int i=0;i<3;i++){
			System.out.println(user[i].getPriority()+"======="+user[i].getUsername());
		}
		System.out.println("==================================");
		Arrays.sort(user);
		for(int i=0;i<3;i++){
			System.out.println(user[i].getPriority()+"======="+user[i].getUsername());
		}
		
		System.out.println("/////////////////list/////////////////////");
		List<User> list = new ArrayList<User>();
		list.add(new User(7, "朝阳7"));
		list.add(new User(4, "朝阳4"));
		list.add(new User(8, "朝阳8"));
		Collections.sort(list);
		for(User user1:list){
			System.out.println(user1.getPriority()+"======="+user1.getUsername());
		}
	}
}
