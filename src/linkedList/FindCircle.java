/*********************************************************************************************
 * 		Problem: Given a linked list, determine if it contains a circle
 * 		Data Structures: HashMap, Linked List
 * 
 * 		Attention: if there is cycle in a list, there is no tail for it.
 * 
 *********************************************************************************************/

package linkedList;

import dataStructures.ListNode;
import java.util.HashSet;

public class FindCircle {

// method 1: runner pointer. When slow catch up fast, there must be a cycle
	public boolean hasCycle3(ListNode head) {
		if(head == null || head.next == null) return false;
		
		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null) {
			if(slow == fast) return true; // maybe self-loop
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

// method 2: use extra space (a hash table)
	public boolean hasCycle2(ListNode head) {
		if(head == null || head.next == null) return false;
		
		HashSet<ListNode> table = new HashSet<ListNode>();
		while(head != null) {
			if(!table.contains(head)){
				table.add(head);
				head = head.next;
			} else {
				return true;
			//  return head;
			}
		}
		
		return false;
		
	}
	
// method 3: get the cycle staring point
/*************************************************************************
 *  two pointers meet x positions before the loop start in the cycle body, 
 *  where x is the distance from head to cycle start.
 *  time complexity: O(n)
 *************************************************************************/
	public ListNode hasCycle(ListNode head) {
		if(head == null || head.next == null) return null;
		
		// declare two pointer
		ListNode slow = head, fast = head; // slow and fast must have a same staring point!!!
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
		
		// no cycle
		if(fast == null || fast.next == null) {
			return null;
		}
		
		// detect a cycle, the distance(junction, cycle_start) = distance(head, junction)
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
		
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(2);
		head.add(3);
		head.add(5);
		ListNode c = head.get(head, 4);
		c.next = head;
//		head.print();
		
		FindCircle test = new FindCircle();
		System.out.println(test.hasCycle2(head));
		
	}
}
