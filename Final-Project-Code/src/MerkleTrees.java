/*****************************************
** File:    MerkleTrees.java
** Project: CSCE 314 Final Project, Fall 2020
** Author:  Qingboyuan Wang, Jinhao Pan, Nisarg Gol, Boyi Shi
** Date:    11/5/20
** Section: 501
** E-mail:  brian_wang@tamu.edu, jeffreypan@tamu.edu, nisarggol@tamu.edu, riceboishi@tamu.edu
**
** This file contains the program that generates the Merkle tree for our Final Project.
** This program constructs the tree and return the root hash generated to main driver program.
**
**
***********************************************/

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class MerkleTrees 
{
	List<String> txList; // A list of leaf nodes
	String root; // Merkle tree root
	//-------------------------------------------------------
	// Name: MerkleTrees
	// PreCondition:  The text list is valid.
	// PostCondition: Create an instance of txList and initialize 
	// string 'root' with null. 
	//---------------------------------------------------------
	
	// CONSTRUCTOR
	public MerkleTrees(List<String> txList) 
	{
		this.txList = txList;
		root = " " ;
	}
	
	//-------------------------------------------------------
	// Name: merkle_tree
	// PreCondition:  The text list is not empty or null.
	// PostCondition: Construct the tree
	//---------------------------------------------------------
	
	// CREATES HASH
	public void createRoot() 
	{
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < this.txList.size(); i++) 
			{ tempList.add(this.txList.get(i)); }
		

		List<String> newTxList = getNewList(tempList);
		while (newTxList.size() != 1) 
			{ newTxList = getNewList(newTxList); }

		this.root = newTxList.get(0);
	}
	// RETURNS HASH 
	public String getRoot() 
	{
		{ return this.root; }
	}

	//-------------------------------------------------------
	// Name: getNewList (Sub-function for merkle_tree)
	// PreCondition: tempList is not empty or null.
	// PostCondition: Construct the tree.
	//---------------------------------------------------------
	private List<String> getNewList(List<String> tempList) {

		List<String> newList = new ArrayList<String>();
		int index = 0 ;
		while (index < tempList.size()) 
		{
			// left node
			String left = tempList.get(index);
			index++;

			// right node
			String right = " " ;
			if (index != tempList.size()) 
				{ right = tempList.get(index); }
			

			// hashed value of each two nodes
			String hashedValue = getHashedValue(left + right);
			newList.add(hashedValue);
			index++;

		}

		return newList;
	}

	//-------------------------------------------------------
	// Name: getHashedValue
	// PreCondition:  The left and right nodes are not empty or null.	
	// PostCondition: Save the SHA2 hashed value of each two nodes.
	//---------------------------------------------------------

	public String getHashedValue(String temp) 
	{
		byte[] _byte;
		try {
			MessageDigest msg = MessageDigest.getInstance("SHA-256");
			msg.update(temp.getBytes());
			_byte = msg.digest();
			StringBuilder bulider = new StringBuilder(2 * _byte.length);
			for (byte b : _byte) 
				{ bulider.append(String.format("%02x", b & 0xff)); }
		
			return bulider.toString();

		} catch (Exception err) 
			{ err.printStackTrace(); }

		return " ";
	}

	//-------------------------------------------------------
	// Name: getRoot
	// PreCondition:  The hashed root is not empty or null.	
	// PostCondition: Returns the SHA2 hashed root value of this Merkle tree.
	//---------------------------------------------------------


}