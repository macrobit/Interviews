package merge;
/*Merge two sorted linked lists and return it as a new list. The new list should be made by 
 splicing together the nodes of the first two lists.*/
import dataStructures.ListNode;

public class MergeSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode head = l2.val < l1.val ? l2 : l1;
		ListNode pre = l1;
		ListNode nxt = null;
		/*If there is at least one null input*/
		if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
		
		while(l1.next != null && l2 != null){
			if(l2.val < l1.val) {
				if(pre == l1) {
					nxt = l2.next;
					l2.next = pre;
					l1 = l1.next;
					l2 = nxt;
				} else {
					pre.next = l2;
					nxt = l2.next;
					l2.next = l1;
					pre = l2;
					l2 = nxt;
				}
			}
			else {
				pre = l1;
				l1 = l1.next;
			}
			
		}
		while(l1.next == null && l2 != null) {
			if(l2!=null && l2.val < l1.val){
				pre.next = l2;
				nxt = l2.next;
				l2.next = l1;
				pre = l2;
				l2 = nxt;				
			} else {
				l1.next = l2;
			}
		}
		return head;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(2);
		l1.add(3);
		l1.add(4);
		ListNode l2 = new ListNode(1);
		l2.add(3);
		
		MergeSortedLists test = new MergeSortedLists();
		ListNode rst = test.mergeTwoLists(l1,l2);
		l2.print();
		
	}
}
