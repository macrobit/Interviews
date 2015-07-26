package dataStructures;

public class ListNode {
	public int val, index;
	public static int count;
	public ListNode next;
	public ListNode(int val) {
		this.val = val;
		index = ++count;
	}
	
	public void add(int value){
		ListNode end = new ListNode(value);
		ListNode head = this;
		while(head.next != null) head = head.next;
		head.next = end;
	}
	
	public ListNode get(ListNode head, int index) {
		while(head != null) {
			if(head.index == index) return head;
			head = head.next;
		}
		
		return null;
	}
	public void print() {
		ListNode head = this;
		while(head != null){
			System.out.print("" + head.val + "->");
			head = head.next;
		}
		System.out.print("null\n");
	}
}
