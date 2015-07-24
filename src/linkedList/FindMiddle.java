package linkedList;
/*
 * find the middle node of a linked list.
 */
import dataStructures.ListNode;
public class FindMiddle {
	
// method 1: brutal force
	public ListNode findMiddle1 (ListNode head) {
		ListNode curt = head;
		int count = 0;
		while(curt != null) {
			curt = curt.next;
			count ++;
		}
		int middle = count/2;
		for(int i = 1; i < middle; i++) {
			head = head.next;
		}
		return head ;
	}
	
// method 2: fast and slow pointers
/*
 * The position of slow and fast pointers are very important:
1. if slow = fast = head, then when the size of a list is even, the result is the later one in the two middle numbers.
2. if slow = head and fast = head.next, when the size is even, the result is the front one in the two middle numbers.

*/
	public ListNode findMiddle2(ListNode head) {
		if(head == null) return head;
		
		ListNode slow, fast;
		slow = head;
		fast = head.next;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}

// test
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		for(int i = 1; i < 6; i++) {
			head.add(i + 1);
		}
		head.print();
		
		FindMiddle test = new FindMiddle();
		ListNode middle = test.findMiddle2(head);
		System.out.println("The middle value is " + middle.val);
	}
}
