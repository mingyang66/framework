
package framework.yaomy.thread.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import framework.yaomy.thread.model.Dog;
import framework.yaomy.thread.model.Student2;

/**
 * @Description:集合工具类
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月1日 下午1:21:18
 */
public class CollectionsDemo {

	public static void main(String[] args) {
//		//向存在的集合中添加元素
//		List<String> list = new ArrayList<String>();
//		//一次添加一个元素
//		Collections.addAll(list, "asd");
//		System.out.println(list);
//		//一次添加多个元素
//		Collections.addAll(list, "23","12");
//		System.out.println(list);
		
//		User user = new User(4, "花猫");
//		List<User> users = new ArrayList<User>();
//		users.add(new User(34, "黑猫"));
//		users.add(new User(1, "白猫"));
//		users.add(new User(23, "梨猫"));
//		users.add(new User(4, "花猫"));
//		users.add(new User(6, "紫猫"));
//		Collections.sort(users);//自然排序
//		//二进制算法超找
//		int index = Collections.binarySearch(users, user);
//		System.out.println(index);
		
//		Dog dog = new Dog(23, "梨狗");
		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog(1, "白狗"));
		dogs.add(new Dog(4, "花狗"));
		dogs.add(new Dog(6, "紫狗"));
		dogs.add(new Dog(23, "梨狗"));
		dogs.add(new Dog(34, "黑狗"));
//		//二进制算法超找
//		int index = Collections.binarySearch(dogs, dog, new Comparator<Dog>() {
//
//			@Override
//			public int compare(Dog dog1, Dog dog2) {
//				return dog1.getAge().compareTo(dog2.getAge());
//			}
//		});
//		System.out.println("索引"+index);
		
		
		
	}
}

