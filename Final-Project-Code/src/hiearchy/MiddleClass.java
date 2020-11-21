/*****************************************
** File:    MiddleClass.java
** Project: CSCE 314 Final Project, Fall 2020
** Author:  Qingboyuan Wang, Jinhao Pan, Nisarg Gol, Boyi Shi
** Date:    11/21/20
** Section: 501
** E-mail:  brian_wang@tamu.edu, jeffreypan@tamu.edu, nisarggol@tamu.edu, riceboishi@tamu.edu
**
** This file contains MiddleClass class that extends the Person class.
**
**
***********************************************/
package hiearchy;

public class MiddleClass extends Person {

	public MiddleClass(String name, char sex, int age, String id, Job job) {
		super(name, sex, age, id, job);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MiddleClass [name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + ", job=" + job + "]";
	}

	
	
	
}
