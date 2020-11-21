/*****************************************
** File:    Job.java
** Project: CSCE 314 Final Project, Fall 2020
** Author:  Qingboyuan Wang, Jinhao Pan, Nisarg Gol, Boyi Shi
** Date:    11/21/20
** Section: 501
** E-mail:  brian_wang@tamu.edu, jeffreypan@tamu.edu, nisarggol@tamu.edu, riceboishi@tamu.edu
**
** This file contains the Job class.
**
**
***********************************************/
package hiearchy;

public class Job {
	String name = "Unknown";
	double wage = 0;
	
	public 	Job (String name, double wage) {
		this.name = name;
		this.wage = wage;
	}
	
	
	public String getJobName() {
		return name;
	}
	public double getWage() {
		return wage;
	}
	public void changeJob(String name) {
		this.name = name;
	}
	public void setWage(double wage) {
		this.wage = wage;
	} 
	
	public void increaseWage() {
		this.wage += 1;
	}

	
}
