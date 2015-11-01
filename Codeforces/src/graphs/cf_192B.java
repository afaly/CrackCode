package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class cf_192B {

	static class adj {
		ArrayList<Integer> l;

		public adj() {
			l = new ArrayList<Integer>();
		}

		public void add(int v) {
			l.add(v);
		}

		public Integer get(int i) {
			if (i >= 0 && i < l.size()) return l.get(i);
			else
				return null;
		}

		public int size() {
			return l.size();
		}
	}

	static class Pair {
		int i, j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return i + " " + j;
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] s = in.nextLine().split("\\s+");
		int N = I(s[0]), M = I(s[1]);
		adj[] m = new adj[N];
		for (int i = 0; i < M; i++) {
			s = in.nextLine().split("\\s+");
			int a = I(s[0]) - 1;
			int b = I(s[1]) - 1;
			if (m[a] == null) m[a] = new adj();
			if (m[b] == null) m[b] = new adj();
			m[a].add(b);
			m[b].add(a);
		}

		int i = 0, minCnt = 0;

		for (; i < N && m[i] != null; i++);

		ArrayList<Pair> ans = new ArrayList<Pair>();

		minCnt = 0;
		for (int j = 0; j < N; j++) {
			if (j == i) continue;
			minCnt++;
			ans.add(new Pair(j + 1, i + 1));
		}
		// ANS
		System.out.println(minCnt);
		for (Pair p : ans)
			System.out.println(p);

		in.close();
	}
}
