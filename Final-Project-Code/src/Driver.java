/*****************************************
** File:    Driver.java
** Project: CSCE 314 Final Project, Fall 2020
** Author:  Qingboyuan Wang, Jinhao Pan, Nisarg Gol, Boyi Shi
** Date:    11/5/20
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
** let’s say C, can read it. Between each checkpoint, system C keeps a running list of all events it has received so that it can
** compute its own checkpoint message to see whether it matches the checkpoint received by A.
**
** As for how we are going to create this “checkpoint”, we are not yet sure yet because we are not that familiar with the syntax.
** Java does not have pointers like C++. If we implemented this in C++, we would simply create a Merkle Tree with the data that
** A has sent to the pipeline, and would then send the root hash as the checkpoint. The last pipe, C would create its own root hash
** and check whether it matches the one sent by A. If they don’t, we can use the merkle tree to quickly determine which particular
** subtree has the problem in log(n) time instead of O(n) time in case we sent a hash list. 

***********************************************/

import java.util.ArrayList;
import java.util.List;

public class Driver
{
	public static void main(String[] args)
	{
		// Initialize leafs in a list
		List<String> tempList = new ArrayList<String>();
		tempList.add("My");
		tempList.add("name");
		tempList.add("is");
		tempList.add("Qingboyuan");
		tempList.add("Wang");

		// Create an instance of merkleTrees
		// Passes in the list
		MerkleTrees merkleTrees = new MerkleTrees(tempList);

		// Construct the Merkle tree with the list input
		merkleTrees.merkle_tree();

		// Print out the hashed tree root
		System.out.println("root : " + merkleTrees.getRoot());
	}
}
