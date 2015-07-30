package linkedList;

import dataStructures.ListNode;
/*
Remove all elements from a linked list of integers that have value val.
Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/




 
public class RmLLEliments {
	
	 //Definition for singly-linked list.
//	 class ListNode {
//	     int val;
//	     ListNode next;
//	     ListNode(int x) { val = x; }
//	 }

	 public ListNode removeElements(ListNode head, int val) {
		 
		 // the head's value is val, move the head
		 while(head != null && head.val == val) {
			 head = head.next;
		 }
         
         // if the head is null
         if(head == null) return head;
		 
		 // if the head is not null and does not have val.
		 ListNode index = head;
		 
		 // iterate the rest of nodes
		 while(index.next != null) {			 
			 // if the next is target, delete the next node
			 if(index.next.val == val) {
				 index.next = index.next.next;
			 } 
			 // if the next is not a target, move forward one node
			 else {
				 index = index.next;
			 }			 
		 }
		 
		 return head;
		 
	 }
	 
	 public ListNode rmElements(ListNode head, int val) {
//		 if(head == null) return head;
		 
		 ListNode dummy = new ListNode(0);
		 dummy.next = head;
		 head = dummy;
		 
		 while(head.next != null) {
			 if(head.next.val == val) {
				 head.next = head.next.next;
			 } else {
				 head = head.next;
			 }			 
		 }
		 
		 return dummy.next;
		 
	 }
	 
	 public static void main(String[] args) {
		 ListNode head = new ListNode(1);
		 head.add(2);
		 head.add(2);
		 head.add(3);
		 head.add(4);
		 head.print();
		 RmLLEliments test = new RmLLEliments();
		 test.rmElements(head,2); 
		 head.print();
	 }
}
