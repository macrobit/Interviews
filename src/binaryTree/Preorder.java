/********************************************************************************************************
 *                Preorder Binary Tree Traversal
 * 	
 * 		Sequence: root -> left child -> right child
 * 		
 */
package binaryTree;

import java.util.*;
import dataStructures.TreeNode;

public class Preorder {
	
// method 1: stack and while loop
	public ArrayList<Integer> preorderTraverse() {
		
	}
	
// method 2: recursion + traverse
// Pros: 
// Cons: Don't support multi-thread computing
	public ArrayList<Integer> preorderTraverse2(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}
	
	private void traverse(TreeNode root, ArrayList<Integer> list) {
		if(root == null) return;
		
		list.add(root.val);
		traverse(root.left, list);
		traverse(root.right, list);
	} 

// method 3: Divide & Conquer utilize the return value, no need to use the result as an argument.
// Pros: only one method; support multi-thread computing
// Cons: too many ArrayLists waste space
	public ArrayList<Integer> preorderTraverse3(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// Base
		if(root == null)
			return result;
		
		// Divide
		ArrayList<Integer> left = preorderTraverse3(root.left);
		ArrayList<Integer> right = preorderTraverse3(root.right);
		
		// Conquer
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		
		return result;		
	}
}
