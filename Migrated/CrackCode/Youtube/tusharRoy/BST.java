package tusharRoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

class Node<K extends Comparable<K>, D> {
	private K key;
	private D data;
	private Node<K, D> left;
	private Node<K, D> right;

	public Node(K value) {
		this.key = value;
		this.data = null;
		this.left = null;
		this.right = null;
	}

	public Node(K value, D data) {
		this.key = value;
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public Node<K, D> l() {
		return left;
	}

	public Node<K, D> r() {
		return right;
	}

	public K key() {
		return key;
	}

	public D val() {
		return data;
	}

	public void val(D data) {
		this.data = data;
	}

	public void l(Node<K, D> left) {
		this.left = left;
	}

	public void r(Node<K, D> right) {
		this.right = right;
	}

	public boolean leaf() {
		return left == null && right == null;
	}
}

public class BST<K extends Comparable<K>, D> {

	private Node<K, D> root;
	private int size;

	public BST(K key, D data) {
		this.size = 0;
		add(key, data);
	}

	public BST() {
		this.size = 0;
		this.root = null;
	}

	public void add(K key, D data) {
		this.root = add(root, key, data);
	}

	private Node<K, D> add(Node<K, D> n, K value, D data) {
		if (n == null) {
			size++;
			return new Node<K, D>(value, data);
		}
		int cmp = value.compareTo(n.key());
		if (cmp > 0) n.r(add(n.r(), value, data));
		else if (cmp < 0) n.l(add(n.l(), value, data));
		else
			n.val(data);
		return n;
	}

	public int size() {
		return size;
	}

	public D get(K key) {
		Node<K, D> node = get(root, key);
		return node == null ? null : node.val();
	}

	private Node<K, D> get(Node<K, D> n, K key) {
		if (n == null) return null;
		int cmp = key.compareTo(n.key());
		if (cmp < 0) return get(n.l(), key);
		else if (cmp > 0) return get(n.r(), key);
		else
			return n;
	}

	public void visit(Node<K, D> n) {
		System.out.println("VISITED : " + n.key() + " , " + n.val());
	}

	public void InOrder() {
		InOrder(root);
	}

	public void PreOrder() {
		PreOrder(root);
	}

	public void PostOrder() {
		PostOrder(root);
	}

	private void InOrder(Node<K, D> n) {
		if (n == null) return;
		InOrder(n.l());
		visit(n);
		InOrder(n.r());
	}

	private void PreOrder(Node<K, D> n) {
		if (n == null) return;
		visit(n);
		PreOrder(n.l());
		PreOrder(n.r());
	}

	private void PostOrder(Node<K, D> n) {
		if (n == null) return;
		PostOrder(n.l());
		PostOrder(n.r());
		visit(n);
	}

	public void LevelOrder() {
		Queue<Node<K, D>> q = new LinkedList<Node<K, D>>();
		q.add(root);
		int cnt = 1;
		while (cnt > 0) {
			int count = 0;
			while (cnt > 0) {
				Node<K, D> n = q.poll();
				printNode(n);
				if (n.l() != null) {
					q.add(n.l());
					count++;
				}
				if (n.r() != null) {
					q.add(n.r());
					count++;
				}
				cnt--;
			}
			cnt = count;
			addLevel();
		}
	}

	public void LevelOrderQQ() {
		Queue<Node<K, D>> q = new LinkedList<Node<K, D>>(), v;
		q.add(root);
		while (!q.isEmpty()) {
			v = new LinkedList<Node<K, D>>();
			while (!q.isEmpty()) {
				Node<K, D> n = q.poll();
				printNode(n);
				if (n.l() != null) v.add(n.l());
				if (n.r() != null) v.add(n.r());
			}
			addLevel();
			q = v;
		}
	}

	public void LevelOrderR() {
		if (size > 0) {
			ArrayList<Node<K, D>> q = new ArrayList<Node<K, D>>();
			q.add(root);
			LevelOrder(q, 0);
		}
	}

	private int LevelOrder(ArrayList<Node<K, D>> q, int level) {
		if (q.isEmpty()) return 0;
		for (Node<K, D> n : q)
			printNode(n);
		addLevel();
		ArrayList<Node<K, D>> v = new ArrayList<Node<K, D>>();
		for (Node<K, D> n : q) {
			if (n.l() != null) v.add(n.l());
			if (n.r() != null) v.add(n.r());
		}
		LevelOrder(v, level + 1);
		return level + 1;
	}

	public void InOrderItr() {
		if (root == null) return;
		Stack<Node<K, D>> s = new Stack<Node<K, D>>();
		Node<K, D> itr = root;
		while (true) {
			if (itr != null) {
				s.push(itr);
				itr = itr.l();
			} else {
				if (s.isEmpty()) break;
				itr = s.pop();
				visit(itr);
				itr = itr.r();
			}
		}
	}

	public void PreOrderItr() {
		if (root == null) return;
		Stack<Node<K, D>> s = new Stack<Node<K, D>>();
		Node<K, D> itr = root;
		while (true) {
			if (itr != null) {
				visit(itr);
				s.push(itr);
				itr = itr.l();
			} else {
				if (s.isEmpty()) break;
				itr = s.pop();
				itr = itr.r();
			}
		}
	}

	public void PostOrderItr() {
		if (root == null) return;
		Stack<Node<K, D>> s = new Stack<Node<K, D>>();
		Stack<Node<K, D>> v = new Stack<Node<K, D>>();
		Node<K, D> itr = root;
		while (itr != null) {
			v.push(itr);
			if (itr.l() != null) s.push(itr.l());
			if (itr.r() != null) s.push(itr.r());
			if (!s.isEmpty()) itr = s.pop();
			else
				itr = null;
		}
		while (!v.isEmpty())
			visit(v.pop());
	}

	private void addLevel() {
		System.out.println("\n----------------------\n");
	}

	private void printNode(Node<K, D> node) {
		System.out.print(" " + node.key());
	}

	public static void main(String[] args) {
		BST<Integer, String> bst = new BST<>();
		Random r = new Random(System.currentTimeMillis());
		Random r2 = new Random(System.currentTimeMillis());
		String[] v = new String[15];
		for (int i = 0; i < 15; i++) {
			int n = r.nextInt(100), x = r2.nextInt(10000);
			bst.add(n, "" + n + ":" + x);
			v[i] = n + ":" + x;
		}
		System.out.println("Size: " + bst.size());
		// Arrays.sort(v);
		System.out.println(Arrays.toString(v));
		System.out.println("\n\n");

		for (int i = 0; i < 0; i++) {
			String s = bst.get(i);
			if (s == null) {
				System.out.println(i + " : Not Found!");
			} else {
				System.out.println(i + " : " + s);
			}
		}

		System.out.println("----------------	--------------");
		System.out.println("------------INORDER-----------");
		bst.InOrder();
		System.out.println("------------------------------");
		bst.InOrderItr();

		System.out.println("------------------------------");
		System.out.println("-----------PREORDER-----------");
		bst.PreOrder();
		System.out.println("------------------------------");
		bst.PreOrderItr();

		System.out.println("------------------------------");
		System.out.println("----------POSTORDER-----------");
		bst.PostOrder();
		System.out.println("------------------------------");
		bst.PostOrderItr();

		System.out.println("##############################");
		// bst.LevelOrder();
		System.out.println("******************************");
		// bst.LevelOrderQQ();
		bst.LevelOrderR();
	}
}
