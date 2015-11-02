package bloomberg;

public class Bloom_003 {

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

	public static int maxDepth(node root) {
		return maxDepth(root, 0);
	}

	private static int maxDepth(node n, int cur) {
		return n == null ? cur : Math.max(maxDepth(n.l, cur + 1),
				maxDepth(n.r, cur + 1));
	}

	public static void main(String[] args) {
		node v = new node(10);
		v.l = new node(5);
		v.l.l = new node(4);
		v.l.r = new node(9);
		v.l.r.l = new node(8);
		v.l.r.l.l = new node(7);
		v.l.r.l.l.l = new node(6);
		v.l.r.l.l.l.l = new node(5);
		// --------------------
		v.r = new node(11);
		v.r.l = new node(10);
		v.r.r = new node(12);
		v.r.r.l = new node(11);
		v.r.r.r = new node(19);
		v.r.r.r.r = new node(20);
		v.r.r.r.r.r = new node(21);
		v.r.r.r.r.r.r = new node(22);
		v.r.r.r.r.r.r.r = new node(23);
		v.r.r.r.r.r.r.r.r = new node(24);
		System.out.println("Max Depth : " + maxDepth(v));

	}

}
