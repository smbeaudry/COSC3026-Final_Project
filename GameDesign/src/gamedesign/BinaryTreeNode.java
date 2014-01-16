/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamedesign;

/**
 * This class creates a generic Binary Tree Node.  The node itself holds data of
 * type E, and  * the reference to two more Binary Tree Nodes (Left and Right).
 * It also implements many recursive * methods to add nodes, find the height of 
 * the tree from this node down, accessors, mutators, etc.
 * @author Ryan Trudeau, student ID 0296506
 *
 * @param <E> is the generic data type for the node's data.
 */
public class BinaryTreeNode<E extends Comparable<E>> {

	//datafields
	private BinaryTreeNode<E> left;
	private BinaryTreeNode<E> right;
	private E data;

	//Constructor(s)
	
	/**
	 * This fully argumented constructor initializes the Binary Tree Node's
         * data fields with no error checking.
	 * @param leftNode is input to initialize the BTN's left node datafield
	 * @param rightNode is input to initialize the BTN's right node 
         * datafield
	 * @param nodeData is the input to initialize the data for the node.
	 */
	public BinaryTreeNode(BinaryTreeNode<E> leftNode, BinaryTreeNode<E> 
                rightNode, E nodeData){
	left = leftNode;
	right = rightNode;
	data = nodeData;
	}
	
	//Accessors
	/**
	 * This method returns this node's left node reference.
	 * @return this node's left node reference.
	 */
	public BinaryTreeNode<E> getLeft(){
		return left;
	}
	
	/**
	 * This method returns this node's right node reference.
	 * @return this node's right node reference.
	 */
	public BinaryTreeNode<E> getRight(){
		return right;
	}
	
	/**
	 * This method returns this node's data of type E
	 * @return this node's data of type E
	 */
	public E getData(){
		return data;
	}
	
	//Mutators
	
	/**
	 * This mutator takes in an argument node and sets the left node 
         * reference to that node with no error checking.
	 * @param newLeft is the argument node to replace this node's left node
         * reference.
	 */
	public void setLeft(BinaryTreeNode<E> newLeft){
		left = newLeft;
	}
	
	/**
	 * This mutator takes in an argument node and sets the right node
         * reference to that node with no error checking.
	 * @param newRight is the argument node to replace this node's right 
         * node reference.
	 */
	public void setRight(BinaryTreeNode<E> newRight){
		right = newRight;
	}
	
	/**
	 * This method takes in an argument of type E to replace this node's 
         * data with no error checking.
	 * @param newData is the data to replace this nodes data datafield.
	 */
	public void setData(E newData){
		data = newData;
	}

	/**
	 * This add method takes in a new node as an argument.  It recursively 
         * compares the new nodes data to the nodes in the tree
	 * beneath the root node, and places the new node in the proper 
         * position.  It returns a boolean value of true
	 * if the node was successfully placed, and a recursive call if it is 
         * not yet at the proper place in the tree..
	 * @param newNode is the node to be added to the current tree.
	 * @return a boolean value, true if the node was successfully added, 
         * recursive call if not yet at the proper tree position.
	 */
	public boolean add(BinaryTreeNode<E> newNode){
		int comp = (data.compareTo(newNode.data)); // compare the data 
                of the old node to the new node.
		
		if(comp > 0){ //The new node's data is less than the current 
                    node.
			if(left != null){
				return left.add(newNode);
			}
			else{
				left = newNode;
				return true;
			}
		}
		else{
			if(right != null){
				return right.add(newNode);
			}
			else{
				right = newNode;
				return true;
			}
		}
	}

	/**
	 * This void method recursively prints the current tree parsing the 
         * nodes In Order.
	 */
	public void printTree(){
		
		System.out.println(data);
		
		if(left != null){
			System.out.print("Left: ");
			left.printTree();
		}
		if(right != null){
			System.out.print("Right: ");
			right.printTree();
		}
	}
	
	/**
	 * This void method prints the information for a single node, the data, 
         * and right/left references for error checking comparison
	 */
	public void printNode(){
		System.out.print(data + "  This Node: " + this + "  Left Node: "
                                + "" + left + "  Right Node: " + right);
	}
	
	/**
	 * This method searches the tree structure for a node with data matching
         * E.  It returns true if found, false if not.
	 * @param keyData is the value being searched for.
	 * @return a boolean value, true if found, false if not.
	 */
	public boolean search(E keyData){
	int comp = (data.compareTo(keyData)); // compare the data to the current
        data's node
		
		if(comp == 0){
			return true;
		}
	
		if(comp > 0){
			if(left != null){
				return left.search(keyData);
			}
		}
		else{
			if(right != null){
				return right.search(keyData);
			}
		}
		
		return false;
	}
	
	/**
	 * This method is to be used in conjunction with a failed search 
         * command. It returns the node in the 
	 * tree structure containing data closest to matching the search value.  
	 * @param keyData is the value being searched for.
	 * @return the node with data closest to the search value
	 */
	public BinaryTreeNode<E> findClosestTo(E keyData){
	int comp = (data.compareTo(keyData)); // compare the data to the current
        data's node
		
		if(comp > 0){
			if(left != null){
				return left.findClosestTo(keyData);
			}
		}
		else{
			if(right != null){
				return right.findClosestTo(keyData);
			}
		}
		
		return this;
	}
	
	/**
	 * This method returns an integer value of the height of the tree 
         * structure using the argumented node
	 * as the top. The height is found recursively.
	 * @return the height of the tree structure. (-1 if given a null node);
	 */
	public int height(){
		if(this == null)
			return -1;
		
		if(this.left == null && this.right == null)
			return 0;
		
		if(this.left != null && this.right == null)
			return left.height() + 1;
		
		if(this.right != null && this.left == null)
			return right.height() + 1;
			
		return 1 + Math.max(left.height(), right.height());
	}

}