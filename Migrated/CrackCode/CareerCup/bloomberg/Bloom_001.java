package bloomberg;

public class Bloom_001 {

	static class node {
		int k;
		node l, r;

		public node(int k) {
			this.k = k;
			this.l = null;
			this.r = null;
		}

		@Override
		public String toString() {
			return k + "";
		}
	}

	private static int OO = Integer.MAX_VALUE;

	private static boolean checkLeft(node n, int kmax, int kmin) {
		return n == null
				|| (n.k >= kmin && n.k < kmax && checkLeft(n.l, n.k, kmin) && checkRight(
						n.r, kmax, n.k));
	}

	private static boolean checkRight(node n, int kmax, int kmin) {
		return n == null
				|| (n.k >= kmin && n.k < kmax && checkRight(n.r, kmax, n.k) && checkLeft(
						n.l, n.k, kmin));
	}

	public static boolean isBST(node root) {
		return root == null
				|| (checkLeft(root.l, root.k, -OO) && checkRight(root.r, OO,
						root.k));
	}

	public static void main(String[] args) {
		node v = new node(10);
		v.l = new node(5);
		v.l.l = new node(4);
		v.l.r = new node(7);
		v.l.r.l = new node(6);
		// --------------------
		v.r = new node(11);
		v.r.l = new node(10);
		v.r.r = new node(12);
		v.r.r.l = new node(11);
		v.r.r.r = new node(19);
		System.out.println(isBST(v));

	}

}
