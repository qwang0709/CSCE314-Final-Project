/*****************************************
** File:    Person.java
** Project: CSCE 314 Final Project, Fall 2020
** Author:  Qingboyuan Wang, Jinhao Pan, Nisarg Gol, Boyi Shi
** Date:    11/21/20
** Section: 501
** E-mail:  brian_wang@tamu.edu, jeffreypan@tamu.edu, nisarggol@tamu.edu, riceboishi@tamu.edu
**
** This file contains Person abstract class that initilizes this class.
**
**
***********************************************/
package hiearchy;

public abstract class Person {
	String name;
	String id;
	char sex; 
	int age;
	// User-defined class 
	Job job;
	
	public Person(String name, char sex, int age, String id, Job job) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.id = id;
		this.job = job;
	}
	
	// Getters
	public Job getJob() {
		return job;
	}
	public String getName() {
		return name;
	}
	public char getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public String getId() {
		return id;
	}
	
	// Setters
	public void setJob(Job job) {
		this.job = job;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public abstract String toString();
}
