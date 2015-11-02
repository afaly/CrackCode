package bloomberg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Bloom_015 {

	static class Node {
		int i;
		Node[] n;

		public Node(int id) {
			this.i = id;
			this.n = null;
		}

		public Node(int id, Node[] nodes) {
			this.i = id;
			this.n = nodes;
		}

		@Override
		public String toString() {
			return i + ":" + Arrays.toString(n);
		}

		public int size() {
			return n == null ? 0 : n.length;
		}
	}

	public static HashMap<Integer, Integer> map;
	public static int[][] mem;

	public static int maxParty(Node a) {
		int[] v = sumLevel(a);
		System.out.println(Arrays.toString(v));
		mem = new int[2][v.length];
		Arrays.fill(mem[0], -1);
		Arrays.fill(mem[1], -1);
		return maxParty(sumLevel(a), 0, false);
	}

	private static int maxParty(int[] v, int i, boolean took) {
		if (i >= v.length) return 0;
		if (mem[took ? 1 : 0][i] >= 0) return mem[took ? 1 : 0][i];
		mem[1][i] = maxParty(v, i + 1, false);
		mem[0][i] = took ? 0 : v[i] + maxParty(v, i + 1, true);
		return Math.max(mem[0][i], mem[1][i]);
	}

	private static int[] sumLevel(Node a) {
		map = new HashMap<Integer, Integer>();
		sumLevel(a, 0);
		int[] res = new int[map.size()];
		for (Integer key : map.keySet())
			res[key] = map.get(key);
		return res;
	}

	private static void sumLevel(Node a, int l) {
		if (a == null) return;
		if (!map.containsKey(l)) map.put(l, 0);
		map.put(l, map.get(l) + 1);
		if (a.n != null) for (Node j : a.n)
			sumLevel(j, l + 1);
	}

	public static void printLevel(Node n) {
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		q.add(n);
		System.out.println("-------------------------------");
		while (!q.isEmpty()) {
			System.out.print("[");
			for (int sz = q.size(); sz > 0; sz--) {
				t = q.poll();
				if (t.n != null) for (Node x : t.n)
					q.add(x);
				System.out.print(t.i + " ");
			}
			System.out.println("]");
		}
		System.out.println("-------------------------------");
	}

	public static int reverse(int n, int x) {
		return x == 0 ? n : reverse((n * 10) + (x % 10), x / 10);
	}

	public static int fib(int n) {
		int[] f = { 1, 1, 2 };
		while (f[2] < n) {
			f[2] = f[0] + f[1];
			f[0] = f[1];
			f[1] = f[2];
			System.out.print(f[2] + " ");
		}
		return f[2];
	}

	public static void main(String[] args) {
		fib(100);
		System.out.println(reverse(0, 123456789));
		Node p0 = new Node(0);
		Node p1 = new Node(1);
		Node p2 = new Node(2);
		Node p3 = new Node(3);
		Node p4 = new Node(4);
		Node p5 = new Node(5);
		Node p6 = new Node(6);
		Node p7 = new Node(7);
		Node p8 = new Node(8);
		Node p9 = new Node(9);
		Node q0 = new Node(10);
		Node q1 = new Node(11);
		Node q2 = new Node(12);
		Node q3 = new Node(13);
		Node q4 = new Node(14);
		Node q5 = new Node(15);
		Node q6 = new Node(16);
		Node q7 = new Node(17);
		Node q8 = new Node(18);
		Node q9 = new Node(19);

		p0.n = new Node[] { p1, p3, q0, p6, q3, q1 };
		p1.n = new Node[] { p4 };
		p4.n = new Node[] { p5 };
		p5.n = new Node[] { p7, p8 };
		p8.n = new Node[] { p9, p2 };

		q0.n = new Node[] { q2 };
		q2.n = new Node[] { q4 };
		q4.n = new Node[] { q5, q6, q7, q8, q9 };

		printLevel(p0);
		System.out.println(maxParty(p0));
	}
}
