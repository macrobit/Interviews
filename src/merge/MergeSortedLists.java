/***********************************************************************************************
 *	Problem Name:     Merge Two Sorted Linked Lists
 * 	
 * 	Tags:			  Linked Lists, Sorted, Merge, Dummny Node
 * 
 * 	Time Complexity:  O(n log n)
 * 
 *  Description:	  Use dummy node when there would be a flexible head node in the new merged 
 *  				  list. It will decrease the if and else statements.
 * 
 * 	                 		Author: Yuhao Fei
 * 
 ************************************************************************************************/

package merge;
/*Merge two sorted linked lists and return it as a new list. The new list should be made by 
 splicing together the nodes of the first two lists.*/
import dataStructures.ListNode;

public class MergeSortedLists {
	public ListNode mergeTwoLists(ListNode listA, ListNode listB){		
	// dummy node
		ListNode dummy = new ListNode(0);
		ListNode end = dummy;
		
		while(listA != null && listB != null) {
			if(listA.val < listB.val) {
				end.next = listA;
				listA = listA.next;
			} else {
				end.next = listB;
				listB = listB.next;
			}
			end = end.next;
		}
		
		if(listA == null) {
			end.next = listB;
		} else {
			end.next = listA;
		}
		
		return dummy.next;

	}
	
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(2);
		l1.add(3);
		l1.add(4);
		ListNode l2 = new ListNode(1);
		l2.add(3);
		
		MergeSortedLists test = new MergeSortedLists();
		ListNode rst = test.mergeTwoLists(l1,l2);
		rst.print();
		
	}
}
