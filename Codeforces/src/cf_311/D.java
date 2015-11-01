package cf_311;

import java.util.Scanner;

public class D {

	static class UF {
		private int[] id, rk;
		private int sz, cnt;

		public UF(int size) {
			this.sz = size;
			this.cnt = size;
			this.id = new int[size];
			this.rk = new int[size];
			for (int i = 0; i < size; i++)
				id[i] = i;
		}

		public boolean same(int a, int b) {
			return find(a) == find(b);
		}

		public int find(int a) {
			return id[a] != a ? id[a] = find(id[a]) : id[a];
		}

		public boolean union(int a, int b) {
			int pa = find(a), pb = find(b);
			if (pa != pb) {
				if (rk[pa] > rk[pb]) id[pb] = pa;
				else if (rk[pb] > rk[pa]) id[pa] = pb;
				else {
					id[pb] = pa;
					rk[pa]++;
				}
				cnt--;
				return true;
			} else
				return false;
		}

		public int size() {
			return sz;
		}

		public int count() {
			return cnt;
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] P(String[] s) {
		return new int[] { I(s[0]), I(s[1]) };
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] p = P(in.nextLine().split("\\s+"));
		UF uf = new UF(p[0]);
		boolean cycle = false;
		for (int i = 0; i < p[1]; i++) {
			int[] e = P(in.nextLine().split("\\s+"));
			cycle |= !uf.union(e[0] - 1, e[1] - 1);
		}
		System.out.println(cycle);
		System.out.println(uf.count());
		in.close();

	}
}
