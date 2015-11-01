package hard;

public class Surface {
	class uf {
		private int len, grps;
		private int[] prnt, rank;

		public uf(int len) {
			this.len = len;
			this.grps = len;
			this.prnt = new int[len];
			this.rank = new int[len];
			for (int i = 0; i < len; i++)
				prnt[i] = i;
		}

		public int find(int a) {
			if (prnt[a] == a) return a;
			prnt[a] = find(prnt[a]);
			return prnt[a];
		}

		public void union(int a, int b) {
			int prnt_a = find(a);
			int prnt_b = find(b);
			if (prnt_a == prnt_b) return;
			if (rank[a] > rank[b]) {
				prnt[prnt_b] = prnt_a;
			} else if (rank[b] > rank[a]) {
				prnt[prnt_a] = prnt_b;
			} else {
				prnt[prnt_a] = prnt_b;
				rank[prnt_a]++;
			}
			grps--;
		}

		public boolean connected(int a, int b) {
			return find(a) == find(b);
		}

		public int cnt() {
			return grps;
		}
	}

	private static final int RIGHT = 0xFFFF;

	public static int toInt(int left, int right) {
		return (left << 16) | (right & RIGHT);
	}

	public static int getLeft(int val) {
		return val >>> 16; // >>> operator 0-fills from left
	}

	public static int getRight(int val) {
		return val & RIGHT;
	}
}
