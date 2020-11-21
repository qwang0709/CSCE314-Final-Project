
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

** In our project, we will create a data processing pipeline where messages flow in one direction.
** All the messages that come out of A are processed and transformed to some new value-added structure that is sent
** onto the end of the pipeline. In between are queues to decouple the system. The information we intend to send will
** be an instance of a class that will hold specific information which the pipeline will then change. We have not yet
** decided what kind of class we want to create, but each instance will have a unique ID as one of its attributes that we
** will utilize to hash.
**
** To ensure that all data received and in the correct order, a checkpoint is periodically created by A, summarizing all the
** messages sent since the last checkpoint. It is then passed down the pipeline without being altered so that the last pipe,
** letâ€™s say C, can read it. Between each checkpoint, system C keeps a running list of all events it has received so that it can
** compute its own checkpoint message to see whether it matches the checkpoint received by A.
**
** As for how we are going to create this â€œcheckpointâ€�, we are not yet sure yet because we are not that familiar with the syntax.
** Java does not have pointers like C++. If we implemented this in C++, we would simply create a Merkle Tree with the data that
** A has sent to the pipeline, and would then send the root hash as the checkpoint. The last pipe, C would create its own root hash
** and check whether it matches the one sent by A. If they donâ€™t, we can use the merkle tree to quickly determine which particular
** subtree has the problem in log(n) time instead of O(n) time in case we sent a hash list. 

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

		// Create the Scanner code to gather a float and an integer using the variables
		// already created

		while (true) 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your Class Option: (Example: upper, middle, or lower) ");
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
				
				
				//Checking the whole information (Generics)
				temp.add(person_lower);
				
				List<String> tempList1 = new ArrayList<String>();
				tempList1.add(person_lower.getName());
				tempList1.add(Character.toString(person_lower.getSex()));
				tempList1.add(Integer.toString(person_lower.getAge()));
				tempList1.add(person_lower.getId());
				tempList1.add(person_lower.getJob().getJobName());
				tempList1.add(Double.toString(person_lower.getJob().getWage()));

				// Polymorphsim
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
					if (!(tempRoot.equals(hashes_lower.get(hashes_lower.size() - 1)))) 
					{
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

			} // end of lower

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

			} // end of lower

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

			} // end of upper
			else 
			{
				System.out.println("You have typed an wrong class option!");
			}

		} // end while true
		
		System.out.println("The whole person information (Generics): \n "+temp); 

	}
}
