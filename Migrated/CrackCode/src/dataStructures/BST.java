package dataStructures;

import java.util.Random;

public class BST<Key extends Comparable<Key>, Value> implements
		BSTI<Key, Value> {

	private VisitNode<Key, Value> visiter;

	public void setVisiter(VisitNode<Key, Value> visiter) {
		this.visiter = visiter;
	}

	private class Node implements Comparable<Node> {

		private Key key;
		private Value val;
		private Node l, r;
		private int cnt;

		public Node(Key key, Value value) {
			this.key = key;
			this.val = value;
			this.l = null;
			this.r = null;
			this.cnt = 1;
		}

		@Override
		public int compareTo(Node o) {
			return key.compareTo(o.key);
		}

		@Override
		public String toString() {
			return new StringBuilder().append("Node [key=").append(key)
					.append(", value=").append(val).append(", Count=")
					.append(cnt).append("]").toString();
		}
	}

	public static void main(String[] args) {
		BSTI<Integer, String> bst = new BST<Integer, String>();
		VisitNode<Integer, String> vis = new VisitNode<Integer, String>() {

			@Override
			public void Visit(Integer key, String val) {
				System.out.println("Key: " + key + " , Value: " + val);
			}
		};

		bst.setVisiter(vis);
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < 5; i++) {
			int val = r.nextInt(10);
			bst.put(val, "" + val);
		}
		bst.inorder();
		for (int i = -5; i <= 15; i++) {
			System.out.println(i + " : " + bst.rank(i));
			// System.out.println("==========  " + i + "  ==========");
			// bst.delete(i);
			// bst.inorder();
			// System.out.println("\n\n\n-----------------------------------");
		}
		while (bst.size() > 0) {
			System.out.println("Current Max: " + bst.min());
			bst.deleteMin();
		}
		System.out.println("MAX: " + bst.max());
		System.out.println("MIN: " + bst.min());
		System.out.println("--------------------");
		bst.inorder();
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x == null) return x;
		if (x.l != null) x.l = deleteMin(x.l);
		else return x.r;
		x.cnt = 1 + size(x.l) + size(x.r);
		return x;
	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x == null) return x;
		if (x.r != null) x.r = deleteMax(x.r);
		else return x.l;
		x.cnt = 1 + size(x.l) + size(x.r);
		return x;
	}

	private Node root;

	private Node ceil(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		else if (cmp > 0) return ceil(key, x.r);
		else {
			Node t = ceil(key, x.l);
			if (t != null) return t;
			return null;
		}
	}

	public Value ceil(Key key) {
		Node x = ceil(key, root);
		if (x != null) return x.val;
		return null;
	}

	public void delete(Key key) {
		root = delete(key, root);
	}

	private Node delete(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.l = delete(key, x.l);
		else if (cmp > 0) x.r = delete(key, x.r);
		else {
			if (x.r == null) return x.l;
			else {
				Node t = x;
				x = min(t.r);
				x.r = deleteMin(t.r);
				x.l = t.l;
			}
		}
		x.cnt = 1 + size(x.l) + size(x.r);
		return x;
	}

	private Node floor(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp < 0) return floor(key, x.l);
		else {
			Node temp = floor(key, x.r);
			if (temp != null) return temp;
			else return x;
		}
	}

	public Value floor(Key key) {
		Node x = floor(key, root);
		if (x != null) return x.val;
		return null;
	}

	public Value get(Key key) {
		Node temp = root;
		int cmp;
		while (temp != null) {
			cmp = key.compareTo(temp.key);
			if (cmp < 0) temp = temp.l;
			else if (cmp > 0) temp = temp.r;
			else return temp.val;
		}
		return null;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node x) {
		if (x == null) return;
		inorder(x.l);
		Visit(x);
		inorder(x.r);
	}

	private Node max(Node x) {
		if (x != null && x.r != null) return max(x.r);
		return x;
	}

	public Value max() {
		Node x = max(root);
		if (x != null) return x.val;
		return null;
	}

	private Node min(Node x) {
		if (x != null && x.l != null) return min(x.l);
		return x;
	}

	public Value min() {
		Node x = min(root);
		if (x != null) return x.val;
		return null;
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node x) {
		if (x == null) return;
		postorder(x.l);
		postorder(x.r);
		Visit(x);
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node x) {
		if (x == null) return;
		Visit(x);
		preorder(x.l);
		preorder(x.r);
	}

	public void put(Key key, Value value) {
		root = put(key, value, root);
	}

	private Node put(Key key, Value value, Node x) {
		if (x == null) return new Node(key, value);
		int cmp = key.compareTo(x.key);
		if (cmp > 0) {
			x.r = put(key, value, x.r);
		} else if (cmp < 0) {
			x.l = put(key, value, x.l);
		} else {
			x.val = value;
		}
		x.cnt = 1 + size(x.l) + size(x.r);
		return x;
	}

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

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) return 0;
		return x.cnt;
	}

	private void Visit(Node x) {
		if (visiter != null) visiter.Visit(x.key, x.val);
	}

}
