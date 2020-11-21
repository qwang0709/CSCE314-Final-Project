
/*****************************************
** File:    Driver.java
** Project: CSCE 314 Final Project, Fall 2020
** Author:  Qingboyuan Wang, Jinhao Pan, Nisarg Gol, Boyi Shi
** Date:    11/21/20
** Section: 501
** E-mail:  brian_wang@tamu.edu, jeffreypan@tamu.edu, nisarggol@tamu.edu, riceboishi@tamu.edu
**
** This file contains the main driver program for our Final Project.
** This program displays the root hash generated from input leaf nodes
** in the format specified in the project description.
******************************************

**Preliminary Project Application and Description

**		In our project, we will create an application that enabled users in a game to see if the avatars’ data, or information, 
** has been modified, which could potentially be a red flag for information leak of their avatars. 
**		There are three general types of avatars: lower, middle and upper classes. And each avatar contains a name, age, sex, 
** ID, his/her job name and his/her wage. If an avatar’s personal information has been modified, it would result in i
** nconsistent hash roots of the Merkle tree. And the nodes or leaves of the Merkle tree are each individual string that 
** contains each a piece of one member’s personal information.
**		For example, if there is an avatar in lower classes with the information: name => ‘John Doe’, age =>’20’, sex=>’m’, 
** ID=>’123abc’, job name=>’Police’, wage=>’4000’. Then the player or actually a hacker comes in and changed your avatar’s
**  wage ‘4000’ to ‘0’ in order to gain unfair advantages when you battle with each other. Then our application would give 
**  you a warning that your avatar’s information has been modified. 
**		And at the point you want to quit our application, it will give you a whole list containing all the change histories of 
** your avatar’s information in every classes.
**		There are Inheritance, Abstraction, Collections, Generics and Stubs used in this code.

***********************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import hiearchy.Job;
import hiearchy.Person;
import hiearchy.LowerClass;
import hiearchy.MiddleClass;
import hiearchy.UpperClass;

public class Driver 
{
	public static void main(String[] args) 
	{
		boolean boo = true;
		String class_option = "";
		String name = "";
		String id = "";
		String job_name = "";
		int age = 0;
		char sex = ' ';
		double wage = 0.0;
		List<String> hashes_lower = new ArrayList<String>();
		List<String> hashes_middle = new ArrayList<String>();
		List<String> hashes_upper = new ArrayList<String>();
		
		//Checking the whole information (Generics)
		List<Person> temp = new ArrayList<Person>();

		while (true) 
		{
			// Create the Scanner 
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your Class Option: (Example: upper, middle, or lower) ");
			
			// Can only proceed with a chosen class option
			class_option = sc.next();
			
			if (class_option.equals("lower")) 
			{
				System.out.println("Please enter your name: ");
				name = sc.next();
				System.out.println("Please enter your age: ");
				age = sc.nextInt();
				System.out.println("Please enter your sex (Put 'm' for male and 'f' for female): ");
				sex = sc.next().charAt(0);
				System.out.println("Please enter your id: ");
				id = sc.next();
				System.out.println("Please enter your job name: ");
				job_name = sc.next();
				System.out.println("Please enter your wage: ");
				wage = sc.nextDouble();

				Job job_lower = new Job(job_name, wage);
				// Initalize 
				LowerClass person_lower = new LowerClass(name, sex, age, id, job_lower);
				
				
				// Adding lower class object to generics list 
				temp.add(person_lower);
				
				//Creating each tree leaf, that is, the each piece of info
				List<String> tempList1 = new ArrayList<String>();
				tempList1.add(person_lower.getName());
				tempList1.add(Character.toString(person_lower.getSex()));
				tempList1.add(Integer.toString(person_lower.getAge()));
				tempList1.add(person_lower.getId());
				tempList1.add(person_lower.getJob().getJobName());
				tempList1.add(Double.toString(person_lower.getJob().getWage()));

				// Calling the toString function (polymorphsim)
				System.out.println(person_lower.toString());

				// Make a person's info a merkle tree
				MerkleTrees merkleTrees_test = new MerkleTrees(tempList1);

				// Create and display the root hash
				merkleTrees_test.createRoot();
				String tempRoot = merkleTrees_test.getRoot();
				System.out.println("The root hash is: " + tempRoot);

				// Check if the root hash changes compared to the previous one
				if (hashes_lower.isEmpty()) 
				{
					System.out.println("This is the first hash root in lower class!");
					hashes_lower.add(tempRoot);
				} 
				else 
				{
					// If the new hash root is not equal to the previous one
					if (!(tempRoot.equals(hashes_lower.get(hashes_lower.size() - 1)))) 
					{
						// Adding it to the list first then inform the user
						hashes_lower.add(tempRoot);
						System.out.println("Warning: Your personal info has been modified in lower class!!");
					} 
					else 
					{
						System.out.println("Your personal info is secure in lower class :)");
					}

				}

				System.out.println("Do you wish to continue? (true, false)");
				boo = sc.nextBoolean();
				if (!boo) 
				{
					sc.close();
					break;
				}

			} 
			// end of lower class
			
			// The below two else-if statements implemtned the same way as the first one.

			else if (class_option.equals("middle")) 
			{
				System.out.println("Please enter your name: ");
				name = sc.next();
				System.out.println("Please enter your age: ");
				age = sc.nextInt();
				System.out.println("Please enter your sex (Put 'm' for male and 'f' for female): ");
				sex = sc.next().charAt(0);
				System.out.println("Please enter your id: ");
				id = sc.next();
				System.out.println("Please enter your job name: ");
				job_name = sc.next();
				System.out.println("Please enter your wage: ");
				wage = sc.nextDouble();

				Job job_middle = new Job(job_name, wage);

				MiddleClass person_middle = new MiddleClass(name, sex, age, id, job_middle);
				
				temp.add(person_middle);

				List<String> tempList1 = new ArrayList<String>();
				tempList1.add(person_middle.getName());
				tempList1.add(Character.toString(person_middle.getSex()));
				tempList1.add(Integer.toString(person_middle.getAge()));
				tempList1.add(person_middle.getId());
				tempList1.add(person_middle.getJob().getJobName());
				tempList1.add(Double.toString(person_middle.getJob().getWage()));

				// Polymorphsim
				System.out.println(person_middle.toString());

				// Make a person's info a merkle tree
				MerkleTrees merkleTrees_test = new MerkleTrees(tempList1);

				// Create and display the root hash
				merkleTrees_test.createRoot();
				String tempRoot = merkleTrees_test.getRoot();
				System.out.println("The root hash is: " + tempRoot);

				// Check if the root hash changes compared to the previous one
				if (hashes_middle.isEmpty()) 
				{
					System.out.println("This is the first hash root in middle class!");
					hashes_middle.add(tempRoot);
				} 
				else 
				{
					if (!(tempRoot.equals(hashes_middle.get(hashes_middle.size() - 1)))) 
					{
						hashes_middle.add(tempRoot);
						System.out.println("Warning: Your personal info in middle class has been modified!!");
					} 
					else 
					{
						System.out.println("Your personal info in middle class is secure :)");
					}

				}

				System.out.println("Do you wish to continue? (true, false)");
				boo = sc.nextBoolean();
				if (!boo) 
				{
					sc.close();
					break;
				}

			} 
			// end of middle class

			else if (class_option.equals("upper")) 
			{
				System.out.println("Please enter your name: ");
				name = sc.next();
				System.out.println("Please enter your age: ");
				age = sc.nextInt();
				System.out.println("Please enter your sex (Put 'm' for male and 'f' for female): ");
				sex = sc.next().charAt(0);
				System.out.println("Please enter your id: ");
				id = sc.next();
				System.out.println("Please enter your job name: ");
				job_name = sc.next();
				System.out.println("Please enter your wage: ");
				wage = sc.nextDouble();

				Job job_upper = new Job(job_name, wage);

				UpperClass person_upper = new UpperClass(name, sex, age, id, job_upper);
				
				temp.add(person_upper);

				List<String> tempList1 = new ArrayList<String>();
				tempList1.add(person_upper.getName());
				tempList1.add(Character.toString(person_upper.getSex()));
				tempList1.add(Integer.toString(person_upper.getAge()));
				tempList1.add(person_upper.getId());
				tempList1.add(person_upper.getJob().getJobName());
				tempList1.add(Double.toString(person_upper.getJob().getWage()));

				// Polymorphsim
				System.out.println(person_upper.toString());

				// Make a person's info a merkle tree
				MerkleTrees merkleTrees_test = new MerkleTrees(tempList1);

				// Create and display the root hash
				merkleTrees_test.createRoot();
				String tempRoot = merkleTrees_test.getRoot();
				System.out.println("The root hash is: " + tempRoot);

				// Check if the root hash changes compared to the previous one
				if (hashes_upper.isEmpty()) 
				{
					System.out.println("This is the first hash root in upper class!");
					hashes_upper.add(tempRoot);
				} 
				else 
				{
					if (!(tempRoot.equals(hashes_upper.get(hashes_upper.size() - 1)))) 
					{
						hashes_upper.add(tempRoot);
						System.out.println("Warning: Your personal info in upper class has been modified!!");
					} 
					else 
					{
						System.out.println("Your personal info in upper class is secure :)");
					}

				}

				System.out.println("Do you wish to continue? (true, false)");
				boo = sc.nextBoolean();
				if (!boo) 
				{
					sc.close();
					break;
				}

			} 
			// end of upper class
			else 
			{
				System.out.println("You have typed an wrong class option!");
			}

		} 
		// end while true
		
		System.out.println("The whole person information (Generics): \n "+temp); 

	}
}
