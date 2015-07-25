package linkedList;
/*********************************************************************************************************
* 	Problem: Given a linked list and a value x, partition it such that all nodes 
* 	         less than x come before nodes greater than or equal to x.
*
* 	         You should preserve the original relative order of the nodes in each of the two partitions.
*
*	         For example,
*	         Given 1->4->3->2->5->2 and x = 3,
*	         return 1->2->2->4->3->5.
*	
*	Tags:    Two Lists, Partition, Dummy Nodes
*	
*	Complexity:   time O(n) space O(n)
*
*	Author:	 Yuhao Fei
*
***********************************************************************************************************/

/* Questions for the interviewers:
 * 1. Can the value of x be negative?
 * 
 */

import dataStructures.ListNode;
public class PartitionList {
	   public ListNode partition(ListNode head, int x) {
	        if(head == null) return head;
	        
	        // dummyL for smaller ones, dummyR for bigger or equal ones
	        ListNode dummyL = new ListNode(0);
	        ListNode dummyR = new ListNode(0);
	        ListNode left = dummyL, right = dummyR;
	        
	        while(head != null) {
	            if(head.val < x) {
	                left.next = head;
	                left = left.next;
	            } else {
	                right.next = head;
	                right = right.next;
	            }
	            head = head.next;
	        }
	        
	        // create a tail
	        right.next = null;
	        // concatenate two lists
	        left.next = dummyR.next;

	        
	        return dummyL.next;
	        
	    }
}
