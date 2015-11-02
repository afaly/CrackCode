package bloomberg;

public class Bloom_007 {

	static class node {
		int k, v;
		node l, r;

		public node(int k, int v) {
			this.k = k;
			this.v = v;
			this.l = null;
			this.r = null;
		}

		@Override
		public String toString() {
			return k + ": " + v;
		}
	}

	public static int OO = Integer.MAX_VALUE;

	public static int MaxRootSum(node root) {
		return maxRootSum(root, 0);
	}

	private static int maxRootSum(node n, int sum) {
		return n == null ? sum : Math.max(maxRootSum(n.l, sum + n.v),
				maxRootSum(n.r, sum + n.v));
	}

	public static void main(String[] args) {
		node v = new node(10, 10);
		v.l = new node(5, 5);
		v.l.l = new node(4, 4);
		v.l.r = new node(7, 7);
		v.l.r.l = new node(6, 6);
		// --------------------
		v.r = new node(11, 11);
		v.r.l = new node(10, 10);
		v.r.r = new node(12, 12);
		v.r.r.l = new node(11, 11);
		v.r.r.r = new node(19, 19);
		System.out.println(MaxRootSum(v));
	}

}
