/*****************************************
** File:    UpperClass.java
** Project: CSCE 314 Final Project, Fall 2020
** Author:  Qingboyuan Wang, Jinhao Pan, Nisarg Gol, Boyi Shi
** Date:    11/21/20
** Section: 501
** E-mail:  brian_wang@tamu.edu, jeffreypan@tamu.edu, nisarggol@tamu.edu, riceboishi@tamu.edu
**
** This file contains Upperlass class that extends the Person class.
**
**
***********************************************/
package hiearchy;

public class UpperClass extends Person {
//	int numberOfSlaves;
//	int netWorth; 
	public UpperClass(String name, char sex, int age, String id, Job job) {
		super(name, sex, age, id, job);
	//	this.netWorth = netWorth;
	//	this.numberOfSlaves = numSlaves;
	}

	@Override
	public String toString() {
		return "UpperClass [name=" + name + ", sex=" + sex + ", age=" + age + ", id=" + id + ", job=" + job + "]";
	}

}
