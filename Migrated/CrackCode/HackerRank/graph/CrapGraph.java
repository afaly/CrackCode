package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CrapGraph {
	private static HashMap<Integer, ArrayList<Integer>> g;
	private static int N;
	private static boolean[] leaf, vist;

	public static int cntCrap(HashMap<Integer, ArrayList<Integer>> graph,
			int numNodes) {
		g = graph;
		N = numNodes;
		leaf = new boolean[N + 1];
		vist = new boolean[N + 1];
		for (int src : g.keySet())
			if (g.get(src).size() == 1) leaf[src] = true;

		for (int src : g.keySet()) {
			if (leaf[src]) {
			}
		}

		return 0;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int T = I(in.nextLine());
		while (T-- > 0) {
			int numNodes = I(s[0]), numEdges = I(s[1]);
			HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
			for (int i = 0; i < numEdges; i++) {
				s = in.nextLine().split("\\s+");
				int src = I(s[0]), dst = I(s[1]);
				if (!graph.containsKey(src)) graph.put(src,
						new ArrayList<Integer>());
				if (!graph.containsKey(dst)) graph.put(dst,
						new ArrayList<Integer>());
				graph.get(src).add(dst);
				graph.get(dst).add(src);
			}

			cntCrap(graph, numNodes);
		}
		in.close();
	}
}
