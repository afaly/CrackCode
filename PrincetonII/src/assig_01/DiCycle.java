package assig_01;

import edu.princeton.cs.algs4.Digraph;

public class DiCycle {

	public static boolean check(Digraph G) {
		int[] vist = new int[G.V()];
		Integer node = 0, mark = 0;
		boolean valid = true;
		for (; node < G.V() && valid; node++) {
			if (vist[node] == 0) {
				vist[node] = mark;
				valid &= dfs(G, node, mark, vist);
			}
		}

		return valid;
	}

	private static boolean dfs(Digraph G, int cur, int mark, int[] vist) {
		boolean ret = true;
		for (Integer nxt : G.adj(cur)) {
			ret = !(vist[nxt] == 0 && vist[nxt] != mark);
			if (!ret) return false;
			vist[nxt] = mark;
			ret &= dfs(G, nxt, mark, vist);
		}
		return ret;
	}
}
