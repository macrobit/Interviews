/*****************************************************************************************************
 * 		Problem: Remove the Nth Node to the End of a List
 * 		Tags: two pointers, dummy node, one pass
 * 		Description: If we use the brutal force method, we have to run two passes, one pass to get the 
 * 					length, one pass to find the specific node. If we want to use one pass, we have to 
 * 					use some specific methods, like recursion or two pointers.
 * 
 * 		Time Complexity: O(n)
 * 		Space Complexity: O(n)
 * 
 ****************************************************************************************************/

package linkedList;

import dataStructures.*;

public class RmNthFromEnd {
	   public ListNode removeNthFromEnd(ListNode head, int n) {
	        
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        head = dummy;
	        
	        ListNode slow = head, fast = head;
	        for(int i = 0; i < n; i++) {
	            if(fast == null) return null;
	            fast = fast.next;
	        }
	        
	        while(fast.next != null) {
	            slow = slow.next;
	            fast = fast.next;
	        }
	        
	        slow.next = slow.next.next;
	        return dummy.next;
	        
	    }
}
