package dataStructures;

import java.util.Scanner;

public class SegmentTree {

	static class N {
		int fr, to, ct;
		N left, right;
		boolean leaf;

		public N(int fromIdx, int toIdx, int count) {
			this.fr = fromIdx;
			this.to = toIdx;
			this.ct = count;
			this.leaf = true;
		}

		public N(int fromIdx, int toIdx) {
			this.fr = fromIdx;
			this.to = toIdx;
			this.ct = 0;
			this.leaf = true;
		}

		public String toString() {
			return "[" + fr + ":" + to + "] " + ct + "  ->" + leaf;
		}
	}

	static class Tree {
		char[] c;
		int len;
		N root;

		public int f(int fr, int to) {
			int cnt = 0;
			for (int i = fr; i < to;) {
				int cur = 0;
				while (i < to && c[i++] == '.')
					cur++;
				if (cur > 1) cnt += cur - 1;
			}
			return cnt;
		}

		public Tree(String s) {
			this.c = s.toCharArray();
			this.len = s.length();
			root = new N(0, len, f(0, len));
			for (int i = 0; i < len; i++)
				if (c[i] != '.') split(i, c[i]);
		}

		public int split(int key, char x) {
			this.c[key] = x;
			this.root = x == '.' ? merge(root, key) : split(root, key);
			return this.root.ct;
		}

		private N merge(N node, int key) {
			if (node == null) return null;
			if (node.to - node.fr <= 1) return node;
			if (key >= node.fr && key < node.to) {
				if (node.leaf) {
					node.ct++;
				} else {
					if (key < node.left.to) node.left = merge(node.left, key);
					else if (key > node.right.fr) node.right = merge(
							node.right, key);
					else {
						node.left = null;
						node.right = null;
						node.ct = f(node.fr, node.to);
						node.leaf = true;
					}
				}
			} else if (key < node.fr) node = merge(node.right, key);
			else node = merge(node.left, key);

			node.ct = node.leaf ? node.ct : node.left.ct + node.right.ct;
			return node;
		}

		private N split(N node, int key) {
			if (node == null) return null;
			if (node.to - node.fr <= 1) return node;
			if (key >= node.fr && key < node.to) {
				if (node.leaf) {
					N lNode = new N(node.fr, key, f(node.fr, key));
					N rNode = new N(key, node.to, f(key, node.to));
					node.left = lNode;
					node.right = rNode;
					node.leaf = false;
				} else {
					if (key > node.left.to) node.right = split(node.right, key);
					else node.left = split(node.left, key);
				}
			} else if (key < node.fr) node = split(node.right, key);
			else node = split(node.left, key);

			node.ct = node.leaf ? node.ct : node.left.ct + node.right.ct;
			return node;
		}

		public int count() {
			return root == null ? -1 : root.ct;
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().split("\\s+");
		int n = I(ss[0]), m = I(ss[1]);
		String s = in.nextLine();
		Tree t = new Tree(s);
		while (m-- > 0) {
			ss = in.nextLine().split("\\s+");
			int i = I(ss[0]) - 1;
			System.out.println(t.split(i, ss[1].charAt(0)));
		}
		in.close();
	}

}
