package week_02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import unionFind.UnionFind;

public class A {

	public static final String urlStr = "http://spark-public.s3.amazonaws.com/algo2/datasets/edges.txt";

	private static class Edge implements Comparable<Edge> {
		final int u, v;
		final double w;

		public Edge(int u, int v, double w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			return w < e.w ? -1 : w > e.w ? 1 : 0;
		}

	}

	private static UnionFind uf;
	private static int N;

	public static double Cluster(final int k, final ArrayList<Edge> edges) {
		uf = new UnionFind(N);
		Collections.sort(edges);
		Edge e = null;
		Iterator<Edge> itr;
		for (itr = edges.iterator(), e = itr.next(); uf.numOfComponents() > k
				&& itr.hasNext(); e = itr.next()) {
			uf.union(e.u, e.v);
		}
		double maxDist = Double.NEGATIVE_INFINITY;
		for (; itr.hasNext(); e = itr.next()) {
			if (!uf.connected(e.u, e.v)) maxDist = Math.max(maxDist, e.w);
		}
		return maxDist;
	}

	public static void main(String[] args) throws IOException {
		// URL url = new URL(urlStr);
		// Scanner in = new Scanner(url.openStream());
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		String[] s = in.nextLine().trim().split("\\s+");
		ArrayList<Edge> edges = new ArrayList<Edge>();
		while (s.length == 3) {
			int src = Integer.parseInt(s[0]);
			int dst = Integer.parseInt(s[1]);
			double w = Double.parseDouble(s[2]);
			edges.add(new Edge(src - 1, dst - 1, w));
			s = in.nextLine().trim().split("\\s+");
		}

		System.out.println(Cluster(4, edges));
		in.close();
	}
}
