/**
 * 
 */
package leetCode;

/**
 * @author howard
 * Remove linked list elements
 * Example
 *Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 *Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RmListElement {
	public ListNode removeElements(ListNode head, int val) {
		ListNode index = head;
		ListNode pre = head;
		while(index != null) {
			int value = index.val;
			if(value == val) {
				if(pre == index) {
					index = index.nxt;
					pre=head=index;
				} else if(index.nxt == null){
					pre.nxt = null;
					index = null;
				} else {
					pre.nxt = index.nxt;
					index = index.nxt;
				}
			} else {
				pre = index;
				index = index.nxt;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode list[] = new ListNode[7];
		list[0] = new ListNode(1);
		list[1] = new ListNode(2);
		list[2] = new ListNode(6);
		list[3] = new ListNode(3);
		list[4] = new ListNode(4);
		list[5] = new ListNode(5);
		list[6] = new ListNode(6);
		for(int i = 0; i < 6; i++) {
			list[i].nxt = list[i+1];
		}
		ListNode head = list[0];
		RmListElement test = new RmListElement();
		head = test.removeElements(head,4);
		while(head != null) {
			if(head.nxt != null)
				System.out.printf("%d --> ",head.val);
			else
				System.out.printf("%d",head.val);
			head = head.nxt;
		}
		System.out.println();
	}
}
