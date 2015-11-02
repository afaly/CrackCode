package week_01;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import unionFind.UnionFind;

class Constants {
	public static final NumberFormat DEC_2_FORMAT = new DecimalFormat("#0.00");
}

class Edge implements Comparable<Edge> {
	final int dst;
	final double w;

	public Edge(int node, double w) {
		this.dst = node;
		this.w = w;
	}

	@Override
	public int compareTo(Edge e) {
		return w > e.w ? 1 : w < e.w ? -1 : 0;
	}

	@Override
	public String toString() {
		return "(" + dst + ":" + Constants.DEC_2_FORMAT.format(w) + ")";
	}
}

class PathEdge implements Comparable<PathEdge> {
	final int node, prnt;
	final double w;

	public PathEdge(int node, double w) {
		this.prnt = -1;
		this.node = node;
		this.w = w;
	}

	public PathEdge(int prnt, int node, double w) {
		this.prnt = prnt;
		this.node = node;
		this.w = w;
	}

	@Override
	public int compareTo(PathEdge e) {
		return w > e.w ? 1 : w < e.w ? -1 : 0;
	}

	@Override
	public String toString() {
		return prnt + " " + node + " " + w;
	}
}

class AdjList implements Iterable<Edge> {
	private List<Edge> list;

	public AdjList(int size) {
		this.list = new ArrayList<Edge>(size);
	}

	public AdjList() {
		this(0);
	}

	public List<Edge> getList() {
		return list;
	}

	public void add(Edge node) {
		this.list.add(node);
	}

	public void addAll(Collection<Edge> nodes) {
		this.list.addAll(nodes);
	}

	public int size() {
		return list.size();
	}

	@Override
	public Iterator<Edge> iterator() {
		return list.iterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (Edge e : list) {
			sb.append(e).append("  ");
		}
		return sb.append("}").toString();
	}
}

class Graph<D> {

	private static final double OO = Double.MAX_VALUE;
	private AdjList[] graph;
	private D[] data;
	private int numOfNodes, numOfEdges;

	private double[] dist;
	private int[] prnt;
	private double mst_weight;

	public Graph(int numOfNodes) {
		this.numOfNodes = numOfNodes;
		this.numOfEdges = 0;
		this.graph = new AdjList[numOfNodes];
		for (int i = 0; i < numOfNodes; i++)
			graph[i] = new AdjList();
	}

	public int V() {
		return numOfNodes;
	}

	public int E() {
		return numOfEdges;
	}

	public void addNodeData(D[] data) {
		this.data = data;
	}

	public D[] getNodeData() {
		return data;
	}

	public void addEdgeDirected(int src, int dst, double w) {
		graph[src].add(new Edge(dst, w));
		numOfEdges++;
	}

	public void addEdgeUnDirected(int src, int dst, double w) {
		graph[src].add(new Edge(dst, w));
		graph[dst].add(new Edge(src, w));
		numOfEdges++;
	}

	public double[] getDijstraDistances(int src) {
		return dist;
	}

	public Map<Integer, LinkedList<Integer>> getDijstraPaths(int src) {
		Map<Integer, LinkedList<Integer>> paths = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < numOfNodes; i++) {
			LinkedList<Integer> path = new LinkedList<Integer>();
			int node = i;
			while (node >= 0 && node != src) {
				path.addFirst(node);
				node = prnt[node];
			}
			path.addFirst(src);
			paths.put(i, path);
		}
		return paths;
	}

	public void Dijkstra(int src) {
		this.dist = new double[numOfNodes];
		this.prnt = new int[numOfNodes];
		this.mst_weight = 0;

		Arrays.fill(dist, OO);
		Arrays.fill(prnt, -1);

		PriorityQueue<PathEdge> frontier = new PriorityQueue<PathEdge>();
		frontier.offer(new PathEdge(src, src, 0.0));

		int numOfVisNodes = 0;
		boolean[] vis = new boolean[numOfNodes];

		while (numOfVisNodes < numOfNodes) {
			PathEdge cur = frontier.poll();
			if (!vis[cur.node]) {
				numOfVisNodes++;
				vis[cur.node] = true;
				dist[cur.node] = cur.w;
				prnt[cur.node] = cur.prnt;
				for (Edge e : graph[cur.node].getList()) {
					if (!vis[e.dst]) frontier.offer(new PathEdge(cur.node,
							e.dst, cur.w + e.w));
				}
			}
		}
	}

	private AdjList[] primMST(int src) {
		AdjList[] mst = new AdjList[numOfNodes];
		PriorityQueue<PathEdge> pq = new PriorityQueue<PathEdge>();
		pq.offer(new PathEdge(src, src, 0));
		mst_weight = 0;

		boolean[] vis = new boolean[numOfNodes];
		int numOfTakeNodes = 0;

		while (numOfTakeNodes < numOfNodes && !pq.isEmpty()) {
			PathEdge cur = pq.poll();
			if (!vis[cur.node]) {
				vis[cur.node] = true;
				numOfTakeNodes++;

				for (Edge e : graph[cur.node].getList()) {
					pq.offer(new PathEdge(cur.node, e.dst, e.w));
				}

				if (mst[cur.prnt] == null) mst[cur.prnt] = new AdjList();
				if (cur.prnt == cur.node) continue;
				mst[cur.prnt].add(new Edge(cur.node, cur.w));
				mst_weight += cur.w;
			}
		}
		System.out.println("PRIM MST : " + mst_weight);
		return mst;
	}

	public AdjList[] PrimMST(int src) {
		return src >= 0 && src < numOfNodes ? primMST(src) : primMST(0);
	}

	public AdjList[] PrimMST() {
		return primMST(0);
	}

	public AdjList[] kruskalMST() {
		AdjList[] mst = new AdjList[numOfNodes];
		mst_weight = 0;
		PriorityQueue<PathEdge> pq = new PriorityQueue<PathEdge>();
		UnionFind uf = new UnionFind(numOfNodes);
		// ADD ALL EDGES.
		for (int n = 0; n < numOfNodes; n++) {
			for (Edge e : graph[n]) {
				pq.offer(new PathEdge(n, e.dst, e.w));
			}
		}

		int numOfTakeEdges = 0;
		while (numOfTakeEdges < numOfNodes - 1 && !pq.isEmpty()) {
			PathEdge cur = pq.poll();
			if (!uf.connected(cur.node, cur.prnt)) {
				uf.union(cur.node, cur.prnt);

				if (mst[cur.prnt] == null) mst[cur.prnt] = new AdjList();
				mst[cur.prnt].add(new Edge(cur.node, cur.w));

				mst_weight += cur.w;
				numOfTakeEdges++;
			}
		}
		System.out.println("KRUSKAL MST : " + mst_weight + "   : "
				+ uf.numOfComponents());
		return mst;
	}
}

public class C {

	public static final String urlStr = "http://spark-public.s3.amazonaws.com/algo2/datasets/edges.txt";

	public static void main(String[] args) throws IOException {
		URL url = new URL(urlStr);
		Scanner in = new Scanner(url.openStream());
		String[] s = {};
		s = in.nextLine().split("\\s+");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		Graph<String> g = new Graph<String>(N);

		for (int i = 1; i <= M; i++) {
			s = in.nextLine().trim().split("\\s+");
			int src = Integer.parseInt(s[0]);
			int dst = Integer.parseInt(s[1]);
			double w = Double.parseDouble(s[2]);
			g.addEdgeUnDirected(src - 1, dst - 1, w);
		}

		AdjList[] t1 = g.PrimMST();
		AdjList[] t2 = g.kruskalMST();
		for (int node = 0; node < t1.length; node++) {
			System.out.println("Src : " + node + "  " + t1[node] + "   |  "
					+ t2[node]);
		}

		in.close();
	}
}
