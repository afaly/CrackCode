package ch_02;

class Node<T extends Comparable<T>> {
	private T value;
	private Node<T> next;

	public Node(T value) {
		this.value = value;
		this.next = null;
	}

	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	public T value() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> next() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Data: " + value;
	}
}

class ChainList<T extends Comparable<T>> {
	private Node<T> head, tail;
	private int size;

	public ChainList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	public void append(T value) {
		Node<T> newNode = new Node<T>(value);
		if (size == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		size++;
	}

	public void addHead(T value) {
		Node<T> newNode = new Node<T>(value);
		if (size == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.setNext(head);
			this.head = newNode;
		}
		size++;
	}

	public Node<T> head() {
		return head;
	}

	public int size() {
		return size;
	}
}

class ChainListUtils<T extends Comparable<T>> {
	private Node<T> temp;

	public Node<T> Kth(ChainList<T> l, int K) {
		kth(l.head(), K);
		return temp;
	}

	private int kth(Node<T> node, int K) {
		if (node == null) return 0;
		if (node.next() == null) return 1;
		int cnt = 1 + kth(node.next(), K);
		if (cnt == K) temp = node;
		return cnt;
	}

	public ChainList<Integer> sumReverse(ChainList<Integer> l1,
			ChainList<Integer> l2) {
		ChainList<Integer> res = new ChainList<Integer>();
		Node<Integer> i = l1.head();
		Node<Integer> j = l2.head();
		int carry = 0;
		while (i != null || j != null) {
			int v1 = i == null ? 0 : i.value();
			int v2 = j == null ? 0 : j.value();
			int sm = v1 + v2 + carry;
			carry = Math.max(sm / 10, 0);
			sm %= 10;
			res.append(sm);
			if (i != null) i = i.next();
			if (j != null) j = j.next();
		}
		if (carry > 0) res.append(carry);
		return res;
	}

	public ChainList<Integer> sumForward(ChainList<Integer> l1,
			ChainList<Integer> l2) {
		res = new ChainList<Integer>();
		for (int i = 0; i < l1.size() - l2.size(); i++)
			l2.addHead(0);
		for (int i = 0; i < l2.size() - l1.size(); i++)
			l1.addHead(0);
		int carry = sumForward(l1.head(), l2.head());
		if (carry > 0) res.addHead(carry);
		return res;
	}

	private ChainList<Integer> res;

	private int sumForward(Node<Integer> a, Node<Integer> b) {
		int carry = 0;
		if (a.next() != null && b.next() != null) carry = sumForward(a.next(),
				b.next());
		int sum = a.value() + b.value() + carry;
		res.addHead(sum % 10);
		return sum / 10;
	}
}

public class Q02 {

	public static void main(String[] args) {

		ChainList<Integer> l = new ChainList<Integer>();
		ChainListUtils<Integer> u = new ChainListUtils<Integer>();
		for (int i = 0; i < 10; i++) {
			l.addHead(i);
		}

		System.out.println(l.size());
		Node<Integer> itr1 = l.head();
		Node<Integer> itr2 = l.head();
		int k = 2;
		if (k < 0 || k > l.size()) System.out.println("Invalid");
		else {
			for (int i = 0; i < k; i++)
				itr1 = itr1.next();
			while (itr1 != null) {
				itr1 = itr1.next();
				itr2 = itr2.next();
			}
			System.out.println("Kth: " + k + "   ELEMENT: " + itr2);
		}
		System.out.println("Kth: " + k + "   ELEMENT: " + u.Kth(l, k));
		Node<Integer> itr = l.head();
		while (itr != null) {
			System.out.println(itr);
			itr = itr.next();
		}

		ChainList<Integer> l1 = new ChainList<Integer>(); // 179
		l1.append(1);
		l1.append(7);
		l1.append(9);
		ChainList<Integer> l2 = new ChainList<Integer>(); // 9159
		l2.append(9);
		l2.append(1);
		l2.append(5);
		l2.append(9);

		ChainList<Integer> l3 = u.sumForward(l1, l2);
		Node<Integer> itr3 = l3.head();
		while (itr3 != null) {
			System.out.print(itr3.value() + "  ");
			itr3 = itr3.next();
		}
	}
}
