package LeetCode;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "" + val;
	}
}

public class ReverseLinkedList {

	private static ListNode nxtTail, preHead;
	private static int M, N, i;

	private static ListNode reverseBetween(ListNode n, int pos) {
		if (pos == N) {
			if (n != null) nxtTail = n.next;
			if (preHead != null) preHead.next = n;
			return n;
		}
		ListNode t = reverseBetween(n.next, pos + 1);
		if (t != null) t.next = n;
		return n;
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) return null;
		M = m;
		N = n;
		ListNode orgHead = head;
		if (M > 1) {
			i = 1;
			while (head != null && ++i < M)
				head = head.next;
			preHead = head;
		}
		ListNode temp = reverseBetween(head.next, i);
		temp.next = nxtTail;
		return orgHead;
	}

	private static ListNode tail;

	private static ListNode reverse(ListNode n) {
		if (n.next == null) return tail = n;
		reverse(n.next).next = n;
		return n;
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null) return null;
		ListNode n = reverse(head);
		n.next = null;
		return tail;
	}

	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(4);
		ListNode h5 = new ListNode(5);
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		ListNode n = reverseBetween(h1, 1, 4);
		System.out.println(n.val);
	}
}