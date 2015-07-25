/***********************************************************************************************
 *							Problem: Reorder a Linked List 	
 * 
 * 		Description: Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
 *					 reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 *					 You must do this in-place without altering the nodes' values.
 *					 For example,
 *					 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 *		Tags: Linked List, middle node, reverse, merge
 *
 *		Complexity: Time findMiddle( n ); reverse( n ); merge( n )
 * 
 ***********************************************************************************************/

package linkedList;

import dataStructures.ListNode;
public class ReorderList {
    private ListNode findMiddle(ListNode head) {
        if(head == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode pre = null;
        while(head != null) { // not head.next, the last node must be processed.
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        
        return pre;
    }
    
    private void merge(ListNode head1, ListNode head2) {
        while(head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
        
        // when head1 is null head2 is null, when head1 is not null head2 is null
        if(head1 != null) {
            head1.next = head2;
        }
    }
    public void reorderList(ListNode head) {
        // empty list and one node list
        if(head == null || head.next == null) return;
        
        ListNode mid = findMiddle(head);
        ListNode tail = reverseList(mid.next);
        mid.next = null; // end the front list
        
        merge(head, tail); 
    }
}
