
package framework.yaomy.thread.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import framework.yaomy.thread.model.Dog;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月1日 上午10:02:41
 */
public class ComparatorDemo {

	public static void main(String[] args) {
		List<Dog> list = new ArrayList<Dog>();
		list.add(new Dog(23, "黑子"));
		list.add(new Dog(13, "麻花"));
		list.add(new Dog(13, "虎子"));
		list.add(new Dog(35, "大白"));
		//按照狗狗年龄升序排列
		Collections.sort(list, new Comparator<Dog>() {

			@Override
			public int compare(Dog dog1, Dog dog2) {
				return dog1.getAge().compareTo(dog2.getAge());
			}
		});
		for(Dog dog:list) {
			System.out.println("狗狗年龄："+dog.getAge()+"==========狗狗名字："+dog.getDogName());
		}
		System.out.println("========================分割线======================================");
		//按照狗狗年龄降序序排列
		Collections.sort(list, new Comparator<Dog>() {

			@Override
			public int compare(Dog dog1, Dog dog2) {
				return dog2.getAge().compareTo(dog1.getAge());
			}
		});
		for(Dog dog:list) {
			System.out.println("狗狗年龄："+dog.getAge()+"==========狗狗名字："+dog.getDogName());
		}
	}
}
