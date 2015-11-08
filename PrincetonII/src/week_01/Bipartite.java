package week_01;

import java.util.ArrayList;
import java.util.List;

public class Bipartite {

	public static List<List<Integer>> isBipartite(Graph G) {
		Boolean[] marks = new Boolean[G.V()];
		boolean valid = true;
		for (Integer node = 0; node < G.V(); node++) {
			if (marks[node] == null) valid &= DFS(G, node, marks, true);
		}

		if (valid) {
			List<Integer> p1 = new ArrayList<Integer>();
			List<Integer> p2 = new ArrayList<Integer>();
			for (Integer node = 0; node < G.V(); node++) {
				if (marks[node]) p1.add(node);
				else p2.add(node);
			}
			List<List<Integer>> ret = new ArrayList<List<Integer>>();
			ret.add(p1);
			ret.add(p2);
			return ret;
		} else return null;
	}

	private static boolean DFS(Graph graph, Integer cur, Boolean[] marks,
			Boolean mark) {
		if (marks[cur] == null) {
			marks[cur] = mark;
			boolean valid = true;
			for (Edge nxt : graph.adj(cur)) {
				if (marks[nxt.dst()] == null) valid &= DFS(graph, nxt.dst(),
						marks, !mark);
			}
			return valid;
		} else return marks[cur] == mark;
	}
}
