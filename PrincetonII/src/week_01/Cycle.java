package week_01;

import java.util.ArrayList;
import java.util.Stack;

public class Cycle {

	public static ArrayList<Integer> getCycle(Graph G) {
		boolean[] vist = new boolean[G.V()];
		Integer[] prnt = new Integer[G.V()];
		for (Integer node = 0; node < G.V(); node++) {
			if (!vist[node]) {
				Stack<Integer> st = new Stack<Integer>();
				prnt[node] = node;
				st.push(node);
				while (!st.isEmpty()) {
					Integer cur = st.pop();
					if (!vist[cur]) {
						vist[cur] = true;
						for (Edge nxt : G.adj(cur)) {
							if (!vist[nxt.dst()]) {
								prnt[nxt.dst()] = cur;
								st.push(nxt.dst());
							} else if (prnt[cur] != nxt.dst()
									&& prnt[nxt.dst()] != cur) {
								// Cycle Found.
								ArrayList<Integer> cycle = new ArrayList<Integer>();
								cycle.add(nxt.dst());
								Integer itr = cur;
								while (itr != nxt.dst()) {
									cycle.add(itr);
									itr = prnt[itr];
								}
								cycle.add(nxt.dst());
								return cycle;
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Graph g = new UnDirectedGraph(7);
		g.addEdge(0, 1);
		// g.addEdge(0, 2);
		// g.addEdge(0, 5);
		g.addEdge(0, 6);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);

		ArrayList<Integer> res = Cycle.getCycle(g);
		for (Integer n : res) {
			System.out.println("Node : " + n);
		}

	}
}
