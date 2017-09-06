
package framework.yaomy.thread.model;
/**
 * @Description:小狗实体类
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月1日 上午10:02:54
 */
public class Dog {

	private Integer age;
	private String dogName;
	
	public Dog(Integer age, String dogName) {
		this.age = age;
		this.dogName = dogName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	
	
}
