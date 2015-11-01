package hard;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BenderMoneyMachine {
	public static int I(String s) {
		return Integer.parseInt(s);
	}

	private static int[][] g;
	private static int N;
	private static Stack<Integer> stack;
	private static boolean[] vis;

	public static Stack<Integer> topoSort(int[][] graph, int numNodes) {
		g = graph;
		N = numNodes;
		stack = new Stack<Integer>();
		vis = new boolean[N];
		for (int i = 0; i < N; i++)
			if (!vis[i]) dfs(i);
		return stack;
	}

	private static void dfs(int node) {
		vis[node] = true;
		for (int n : g[node])
			if (n >= 0 && !vis[n]) dfs(n);
		stack.push(node);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine()), OO = 1000000000;
		int[][] g = new int[N][2];
		int[] v = new int[N];
		for (int i = 0; i < N; i++) {
			String[] s = in.nextLine().split("\\s+");
			int id = I(s[0]);
			v[id] = I(s[1]);
			g[id][0] = !s[2].equalsIgnoreCase("E") ? I(s[2]) : -1;
			g[id][1] = !s[3].equalsIgnoreCase("E") ? I(s[3]) : -1;
		}

		int[] dist = new int[N];
		Arrays.fill(dist, -OO);
		dist[0] = v[0];
		Stack<Integer> st = topoSort(g, N);
		while (!st.isEmpty()) {
			int node = st.pop();
			if (dist[node] > -OO) {
				for (int nn : g[node]) {
					if (nn >= 0 && dist[nn] < dist[node] + v[nn]) dist[nn] = dist[node]
							+ v[nn];
				}
			}
		}

		int maxScore = -OO;
		for (int i = 0; i < N; i++)
			if (g[i][0] == -1 && g[i][1] == -1) maxScore = Math.max(maxScore,
					dist[i]);
		System.out.println(maxScore);
		in.close();
	}
}
