package linkedList;

/*Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.*/

import dataStructures.ListNode;

public class ReverseListII {

	public ListNode reverse(ListNode head, int m, int n) /*throws IllegalArgumentException*/ { 
		// robust judgment
		if(m >= n && head == null) return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		for(int i = 1; i < m; i++) {
			if(head == null) return head;
			head = head.next;
		}
		
//		ListNode preM = head;
//		ListNode pre = null;
//		head = head.next;
//		ListNode M = head;
//		for(int i = 0; i <= n-m; i++) {
//			if(head == null) return head;
//			ListNode tmp = head.next;
//			head.next = pre;
//			pre = head;
//			head = tmp;
//		}
		
		ListNode preM = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode, postN = nNode.next;
		for(int i = m; i < n; i++) {
			if(nNode == null) return null;
			ListNode temp = postN.next;
			postN.next = nNode;
			nNode.next = postN;
			postN = temp;
		}
		
		preM.next = nNode;
		mNode.next = postN;	
		
		return dummy.next;
	}
	
}
