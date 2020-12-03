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

import hiearchy.Person;
//import hiearchy.LowerClass;
import hiearchy.Slave;
import hiearchy.Yeomen;
//import hiearchy.MiddleClass;
import hiearchy.Blacksmith;
import hiearchy.Bureucrat;
import hiearchy.Clergy;
import hiearchy.Merchant;
//import hiearchy.UpperClass;

public class Driver 
{
	public static void main(String[] args) 
	{
		boolean boo = true;
		String class_option = "";
		String name = "";
		String id = "";
		// String job_name = "";
		int age = 0;
		char sex = ' ';
		// double wage = 0.0;
		List<String> hashes_lower_salve = new ArrayList<String>();
		List<String> hashes_lower_yeomen = new ArrayList<String>();
		List<String> hashes_middle_blacksmith = new ArrayList<String>();
		List<String> hashes_middle_merchant = new ArrayList<String>();
		List<String> hashes_upper_bur = new ArrayList<String>();
		List<String> hashes_upper_clr = new ArrayList<String>();

		// Checking the whole information (Generics)
		List<Person> temp = new ArrayList<Person>();

		while (true) 
		{
			// Create the Scanner
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the class you want your avatar to be in: (Example: upper, middle, or lower) ");

			// Can only proceed with a chosen class option
			class_option = sc.next();

			if (class_option.equals("lower") || class_option.equals("middle") || class_option.equals("upper")) 
			{
				System.out.println("Please enter the avatar's name: ");
				name = sc.next();
				System.out.println("Please enter the avatar's age: ");
				age = sc.nextInt();
				System.out.println("Please enter the avatar's sex (Put 'm' for male and 'f' for female): ");
				sex = sc.next().charAt(0);
				System.out.println("Please enter the avatar's id: ");
				id = sc.next();
				// System.out.println("Please enter your job name: ");
				// job_name = sc.next();
				// System.out.println("Please enter your wage: ");
				// wage = sc.nextDouble();

				// Creating each tree leaf, that is, the each piece of info
				List<String> tempList = new ArrayList<String>();

				if (class_option.equals("lower")) 
				{
					String opt_lower;
					String color;
					int debt;
					int service;
					System.out.println("Please enter your job for lower class ('slave' or 'yeomen'): ");
					opt_lower = sc.next();

					if (opt_lower.equals("slave")) 
					{

						System.out.println("Enter slave's color: ");
						color = sc.next();
						System.out.println("Enter slave's debt: ");
						debt = sc.nextInt();
						System.out.println("Enter slave's years of service: ");
						service = sc.nextInt();

						// Initilize slave object
						Slave slv = new Slave(name, sex, age, id, debt, service, color);

						// Adding lower class object to generics list
						temp.add(slv);

						tempList.add(slv.getName());
						tempList.add(Character.toString(slv.getSex()));
						tempList.add(Integer.toString(slv.getAge()));
						tempList.add(slv.getId());
						tempList.add(Integer.toString(slv.getDebt()));
						tempList.add(Integer.toString(slv.getSev()));

						// Calling the toString function (polymorphsim)
						System.out.println(slv.toString());

						// Make a person's info a merkle tree
						MerkleTrees merkleTrees_test = new MerkleTrees(tempList);

						// Create and display the root hash
						merkleTrees_test.createRoot();
						String tempRoot = merkleTrees_test.getRoot();
						System.out.println("The root hash is: " + tempRoot);

						// Check if the root hash changes compared to the previous one
						if (hashes_lower_salve.isEmpty()) 
						{
							System.out.println("This is the first hash root in lower class => Slave !");
							hashes_lower_salve.add(tempRoot);
						} 
						else 
						{
							// If the new hash root is not equal to the previous one
							if (!(tempRoot.equals(hashes_lower_salve.get(hashes_lower_salve.size() - 1)))) 
							{
								// Adding it to the list first then inform the user
								hashes_lower_salve.add(tempRoot);
								System.out.println(
										"Warning: Your personal info has been modified in lower class => Slave !!");
							} 
							else 
							{
								System.out.println("Your personal info is secure in lower class => Slave :)");
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
					// end slave

					else if (opt_lower.equals("yeomen")) 
					{

						System.out.println("Enter Yeoman's debt: ");
						debt = sc.nextInt();
						System.out.println("Enter Yeoman's years of service: ");
						service = sc.nextInt();

						// Initilize Yeomen object
						Yeomen ymn = new Yeomen(name, sex, age, id, debt, service);

						// Adding lower class object to generics list
						temp.add(ymn);

						tempList.add(ymn.getName());
						tempList.add(Character.toString(ymn.getSex()));
						tempList.add(Integer.toString(ymn.getAge()));
						tempList.add(ymn.getId());
						tempList.add(Integer.toString(ymn.getDebt()));
						tempList.add(Integer.toString(ymn.getSev()));

						// Calling the toString function (polymorphsim)
						System.out.println(ymn.toString());

						// Make a person's info a merkle tree
						MerkleTrees merkleTrees_test = new MerkleTrees(tempList);

						// Create and display the root hash
						merkleTrees_test.createRoot();
						String tempRoot = merkleTrees_test.getRoot();
						System.out.println("The root hash is: " + tempRoot);

						// Check if the root hash changes compared to the previous one
						if (hashes_lower_yeomen.isEmpty()) 
						{
							System.out.println("This is the first hash root in lower class  => Yeomen !");
							hashes_lower_yeomen.add(tempRoot);
						} 
						else 
						{
							// If the new hash root is not equal to the previous one
							if (!(tempRoot.equals(hashes_lower_yeomen.get(hashes_lower_yeomen.size() - 1)))) 
							{
								// Adding it to the list first then inform the user
								hashes_lower_yeomen.add(tempRoot);
								System.out.println(
										"Warning: Your Avatar's info has been modified in lower class => Yeomen !!");
							} 
							else 
							{
								System.out.println("Your personal info is secure in lower class => Yeomen :)");
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
					// end yeoman
				}
				// end of lower class

				else if (class_option.equals("middle")) 
				{
					String opt_middle;
					int money;
					int num_svt;
					System.out.println("Please enter your job for lower class ('blacksmith' or 'merchant'): ");
					opt_middle = sc.next();

					if (opt_middle.equals("blacksmith")) 
					{
						// Initilize slave object
						Blacksmith bsm = new Blacksmith(name, sex, age, id);

						// Adding lower class object to generics list
						temp.add(bsm);

						tempList.add(bsm.getName());
						tempList.add(Character.toString(bsm.getSex()));
						tempList.add(Integer.toString(bsm.getAge()));
						tempList.add(bsm.getId());

						// Calling the toString function (polymorphsim)
						System.out.println(bsm.toString());

						// Make a person's info a merkle tree
						MerkleTrees merkleTrees_test = new MerkleTrees(tempList);

						// Create and display the root hash
						merkleTrees_test.createRoot();
						String tempRoot = merkleTrees_test.getRoot();
						System.out.println("The root hash is: " + tempRoot);

						// Check if the root hash changes compared to the previous one
						if (hashes_middle_blacksmith.isEmpty()) 
						{
							System.out.println("This is the first hash root in middle class => Blacksmith !");
							hashes_middle_blacksmith.add(tempRoot);
						} 
						else 
						{
							// If the new hash root is not equal to the previous one
							if (!(tempRoot.equals(hashes_middle_blacksmith.get(hashes_middle_blacksmith.size() - 1)))) 
							{
								// Adding it to the list first then inform the user
								hashes_middle_blacksmith.add(tempRoot);
								System.out.println(
										"Warning: Your personal info has been modified in middle class => Blacksmith !!");
							} 
							else 
							{
								System.out.println("Your personal info is secure in middle class => Blacksmith :)");
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
					// end of blksmith

					else if (opt_middle.equals("merchant")) 
					{
						System.out.println("Enter Merchant's money owned: ");
						money = sc.nextInt();
						System.out.println("Enter Merchant's number of servants: ");
						num_svt = sc.nextInt();

						// Initilize slave object
						Merchant mct = new Merchant(name, sex, age, id, num_svt, money);

						// Adding lower class object to generics list
						temp.add(mct);

						tempList.add(mct.getName());
						tempList.add(Character.toString(mct.getSex()));
						tempList.add(Integer.toString(mct.getAge()));
						tempList.add(mct.getId());
						tempList.add(Integer.toString(mct.getMoney()));
						tempList.add(Integer.toString(mct.getServant()));

						// Calling the toString function (polymorphsim)
						System.out.println(mct.toString());

						// Make a person's info a merkle tree
						MerkleTrees merkleTrees_test = new MerkleTrees(tempList);

						// Create and display the root hash
						merkleTrees_test.createRoot();
						String tempRoot = merkleTrees_test.getRoot();
						System.out.println("The root hash is: " + tempRoot);

						// Check if the root hash changes compared to the previous one
						if (hashes_middle_merchant.isEmpty()) 
						{
							System.out.println("This is the first hash root in middle class => Merchant !");
							hashes_middle_merchant.add(tempRoot);
						} 
						else 
						{
							// If the new hash root is not equal to the previous one
							if (!(tempRoot.equals(hashes_middle_merchant.get(hashes_middle_merchant.size() - 1)))) 
							{
								// Adding it to the list first then inform the user
								hashes_middle_merchant.add(tempRoot);
								System.out.println(
										"Warning: Your personal info has been modified in middle class => Merchant !!");
							} 
							else 
							{
								System.out.println("Your personal info is secure in middle class => Merchant :)");
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
					// end of merchant
				}
				// end middle
				else if (class_option.equals("upper")) 
				{
					String opt_upper;
					String faith;

					int money;
					int num_svt;
					System.out.println("Please enter your job for lower class ('bureucrat' or 'clergy'): ");
					opt_upper = sc.next();

					if (opt_upper.equals("bureucrat")) 
					{
						System.out.println("Enter Bureucrat's money owned: ");
						money = sc.nextInt();
						System.out.println("Enter Bureucrat's number of servants: ");
						num_svt = sc.nextInt();

						// Initilize slave object
						Bureucrat brt = new Bureucrat(name, sex, age, id, num_svt, money);

						// Adding lower class object to generics list
						temp.add(brt);

						tempList.add(brt.getName());
						tempList.add(Character.toString(brt.getSex()));
						tempList.add(Integer.toString(brt.getAge()));
						tempList.add(brt.getId());
						tempList.add(Integer.toString(brt.getMoney()));
						tempList.add(Integer.toString(brt.getServant()));

						// Calling the toString function (polymorphsim)
						System.out.println(brt.toString());

						// Make a person's info a merkle tree
						MerkleTrees merkleTrees_test = new MerkleTrees(tempList);

						// Create and display the root hash
						merkleTrees_test.createRoot();
						String tempRoot = merkleTrees_test.getRoot();
						System.out.println("The root hash is: " + tempRoot);

						// Check if the root hash changes compared to the previous one
						if (hashes_upper_bur.isEmpty()) 
						{
							System.out.println("This is the first hash root in upper class => Bureucrat !");
							hashes_upper_bur.add(tempRoot);
						} 
						else 
						{
							// If the new hash root is not equal to the previous one
							if (!(tempRoot.equals(hashes_upper_bur.get(hashes_upper_bur.size() - 1)))) 
							{
								// Adding it to the list first then inform the user
								hashes_upper_bur.add(tempRoot);
								System.out.println(
										"Warning: Your personal info has been modified in upper class => Bureucrat !!");
							} 
							else 
							{
								System.out.println("Your personal info is secure in upper class => Bureucrat :)");
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
					// end of bureucrat

					else if (opt_upper.equals("clergy")) 
					{

						System.out.println("Enter Clergy's money owned: ");
						money = sc.nextInt();
						System.out.println("Enter Clergy's number of servants: ");
						num_svt = sc.nextInt();
						System.out.println("Enter Clergy's name of faith: ");
						faith = sc.next();

						// Initilize slave object
						Clergy cly = new Clergy(name, sex, age, id, num_svt, money, faith);

						// Adding lower class object to generics list
						temp.add(cly);

						tempList.add(cly.getName());
						tempList.add(Character.toString(cly.getSex()));
						tempList.add(Integer.toString(cly.getAge()));
						tempList.add(cly.getId());
						tempList.add(Integer.toString(cly.getMoney()));
						tempList.add(Integer.toString(cly.getServant()));
						tempList.add(cly.getFaith());

						// Calling the toString function (polymorphsim)
						System.out.println(cly.toString());

						// Make a person's info a merkle tree
						MerkleTrees merkleTrees_test = new MerkleTrees(tempList);

						// Create and display the root hash
						merkleTrees_test.createRoot();
						String tempRoot = merkleTrees_test.getRoot();
						System.out.println("The root hash is: " + tempRoot);

						// Check if the root hash changes compared to the previous one
						if (hashes_upper_clr.isEmpty()) 
						{
							System.out.println("This is the first hash root in upper class => Clergy !");
							hashes_upper_clr.add(tempRoot);
						} 
						else 
						{
							// If the new hash root is not equal to the previous one
							if (!(tempRoot.equals(hashes_upper_clr.get(hashes_upper_clr.size() - 1)))) 
							{
								// Adding it to the list first then inform the user
								hashes_upper_clr.add(tempRoot);
								System.out.println(
										"Warning: Your personal info has been modified in upper class => Clergy !!");
							} 
							else 
							{
								System.out.println("Your personal info is secure in upper class => Clergy :)");
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
					// end of clergy

				}
			}

			// end upper

			else 
			{
				System.out.println("The input class information is incorrect, please see the instruction!");
				sc.close();
				break;
			}
			// end all cases

		}
		// end while true

		System.out.println("The whole person information (Generics): \n " + temp);

	}
}
