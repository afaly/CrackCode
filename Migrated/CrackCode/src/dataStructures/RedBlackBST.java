package dataStructures;

import java.util.Random;

public class RedBlackBST<Key extends Comparable<Key>, Value> implements
		BSTI<Key, Value> {

	protected Node root;
	protected VisitNode<Key, Value> visiter;
	protected static boolean RED = true;
	protected static boolean BLACK = false;

	public void setVisiter(VisitNode<Key, Value> visiter) {
		this.visiter = visiter;
	}

	public void toDoublyLinkedList() {
		dlNode head = toDoublyLinkedList(root);
		int cnt = 0;
		while (head != null && cnt < size() * 3) {
			System.out.println(head);
			head = head.r;
			cnt++;
		}
	}

	private dlNode toDoublyLinkedList(Node x) {
		if (x == null) return null;
		dlNode sml = toDoublyLinkedList(x.l);
		dlNode big = toDoublyLinkedList(x.r);

		dlNode mid = new dlNode(x.key, x.val);

		dlNode head = sml != null ? sml : mid;
		dlNode tail = big != null ? big.l : mid;
		if (sml != null) sml = sml.l;

		append(sml, mid);
		append(mid, big);
		append(tail, head);

		return head;
	}

	private void append(dlNode a, dlNode b) {
		if (a != null && b != null) {
			a.r = b;
			b.l = a;
		}
	}

	public class Node implements Comparable<Node> {

		public Key key;
		public Value val;
		public Node l, r;
		public int cnt;
		public boolean color;

		public Node(Key key, Value value, boolean color) {
			this.key = key;
			this.val = value;
			this.color = color;
			this.cnt = 1;
		}

		@Override
		public int compareTo(Node o) {
			return key.compareTo(o.key);
		}

		@Override
		public String toString() {
			return new StringBuilder().append(color ? "RED   " : "BLACK ")
					.append(" [key=").append(key).append(", value=")
					.append(val).append(", Count=").append(cnt).append("]")
					.toString();
		}
	}

	public class dlNode implements Comparable<dlNode> {

		public Key key;
		public Value val;
		public dlNode l, r;

		public dlNode(Key key, Value value) {
			this.key = key;
			this.val = value;
		}

		@Override
		public int compareTo(dlNode o) {
			return key.compareTo(o.key);
		}

		@Override
		public String toString() {
			return new StringBuilder().append(" [key=").append(key)
					.append(", value=").append(val).append("]").toString();
		}
	}

	public static void main(String[] args) {
		RedBlackBST<Integer, String> bst = new RedBlackBST<Integer, String>();
		VisitNode<Integer, String> vis = new VisitNode<Integer, String>() {

			@Override
			public void Visit(Integer key, String val) {
				System.out.println("Key: " + key + " , Value: " + val);
			}
		};

		bst.setVisiter(vis);
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < 10; i++) {
			int val = r.nextInt(20);
			// int val = i;
			bst.put(val, "" + val);
		}
		// bst.inorder();
		bst.toDoublyLinkedList();
		// for (int i = -5; i <= 15; i++) {
		// // System.out.println(i + " : " + bst.rank(i));
		// System.out.println("==========  " + i + "  ==========");
		// bst.delete(i);
		// bst.inorder();
		// System.out.println("\n\n\n-----------------------------------");
		// }
		// while (bst.size() > 0) {
		// System.out.println("Current Max: " + bst.max());
		// bst.deleteMax();
		// }
		// System.out.println("MAX: " + bst.max());
		// System.out.println("MIN: " + bst.min());
		// System.out.println("--------------------");
		// bst.inorder();

	}

	@Override
	public void put(Key key, Value value) {
		root = put(key, value, root);
	}

	private Node put(Key key, Value value, Node x) {
		if (x == null) return new Node(key, value, RED);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.l = put(key, value, x.l);
		else if (cmp > 0) x.r = put(key, value, x.r);
		else x.val = value;

		if (isRed(x.r) && !isRed(x.l)) x = rotateLeft(x);
		if (isRed(x.l) && isRed(x.l.l)) x = rotateRight(x);
		if (isRed(x.l) && isRed(x.r)) flipColor(x);

		x.cnt = 1 + size(x.l) + size(x.r);
		return x;
	}

	private Node rotateLeft(Node i) {
		Node j = i.r;
		i.r = j.l;
		j.color = i.color;
		i.color = RED;
		i.cnt = 1 + size(i.r) + size(i.l);
		j.l = i;
		return j;
	}

	private Node rotateRight(Node i) {
		Node j = i.l;
		i.l = j.r;
		j.color = i.color;
		i.color = RED;
		i.cnt = 1 + size(i.l) + size(i.r);
		j.r = i;
		return j;
	}

	private void flipColor(Node x) {
		x.color = BLACK;
		x.l.color = RED;
		x.r.color = RED;
	}

	private boolean isRed(Node x) {
		if (x == null) return BLACK;
		return x.color;
	}

	@Override
	public Value get(Key key) {
		Node x = get(key, root);
		if (x == null) return null;
		return x.val;
	}

	public Node get(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return get(key, x.l);
		else if (cmp > 0) return get(key, x.r);
		else return x;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) return 0;
		return x.cnt;
	}

	@Override
	public void delete(Key key) {
		root = delete(key, root);
	}

	private Node delete(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.l = delete(key, x.l);
		else if (cmp > 0) x.r = delete(key, x.r);
		else {
			if (x.l == null && x.r == null) return null;
			else if (x.l == null && x.r != null) return x.r;
			else if (x.l != null && x.r == null) {
				x.l.color = BLACK;
				return x.l;
			} else {
				Node t = min(x.r);
				delMin(x.r);
				t.color = x.color;
				x = t;
			}
		}
		x.cnt = 1 + size(x.l) + size(x.r);
		return x;
	}

	@Override
	public void deleteMin() {
		root = delMin(root);
	}

	private Node delMin(Node x) {
		if (x == null) return null;
		if (x.l == null) return x.r;
		else x.l = delMin(x.l);
		x.cnt = 1 + size(x.l) + size(x.r);
		return x;
	}

	@Override
	public void deleteMax() {
		root = delMax(root);
	}

	private Node delMax(Node x) {
		if (x == null) return null;
		if (x.r == null) return x.l;
		else x.r = delMax(x.r);
		if (isRed(x.r) && !isRed(x.l)) x = rotateLeft(x);
		if (isRed(x.r) && isRed(x.l)) flipColor(x);
		x.cnt = 1 + size(x.l) + size(x.r);
		return x;
	}

	@Override
	public Value min() {
		Node x = min(root);
		if (x == null) return null;
		return x.val;
	}

	private Node min(Node x) {
		if (x == null) return null;
		if (x.l != null) return min(x.l);
		return x;
	}

	@Override
	public Value max() {
		Node x = max(root);
		if (x == null) return null;
		return x.val;
	}

	private Node max(Node x) {
		if (x == null) return null;
		if (x.r != null) return max(x.r);
		return x;
	}

	@Override
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null) return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return rank(key, x.l);
		else if (cmp > 0) return 1 + size(x.l) + rank(key, x.r);
		else return 1 + size(x.l);
	}

	@Override
	public Value ceil(Key key) {
		Node x = ceil(key, root);
		if (x == null) return null;
		return x.val;
	}

	private Node ceil(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			Node t = ceil(key, x.l);
			if (t == null) return x;
			else return t;
		} else if (cmp > 0) return ceil(key, x.r);
		else return x;
	}

	@Override
	public Value floor(Key key) {
		Node x = floor(key, root);
		if (x == null) return null;
		return x.val;
	}

	private Node floor(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return floor(key, x.l);
		else if (cmp > 0) {
			Node t = floor(key, x.r);
			if (t == null) return x;
			else return t;
		} else return x;
	}

	@Override
	public void inorder() {
		inorder(root);
	}

	private void inorder(Node x) {
		if (x == null) return;
		inorder(x.l);
		visit(x);
		inorder(x.r);
	}

	@Override
	public void postorder() {
		postorder(root);
	}

	private void postorder(Node x) {
		if (x == null) return;
		postorder(x.l);
		postorder(x.r);
		visit(x);
	}

	@Override
	public void preorder() {
		preorder(root);
	}

	private void preorder(Node x) {
		if (x == null) return;
		visit(x);
		preorder(x.l);
		preorder(x.r);
	}

	public void visit(Node x) {
		if (visiter != null) visiter.Visit(x.key, x.val);
	}
}
