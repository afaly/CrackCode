package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int nn;
	Double v, OO = Double.MAX_VALUE;

	public Edge(int node, Double value) {
		this.nn = node;
		this.v = value;
	}

	public Edge(int node) {
		this.nn = node;
		this.v = OO;
	}

	@Override
	public int compareTo(Edge b) {
		return v.compareTo(b.v);
	}

	@Override
	public String toString() {
		return "[" + nn + " : " + v + "]";
	}
}

class E implements Comparable<E> {
	int nn, pt;
	Double v, OO = Double.MAX_VALUE;

	public E(int node, int prnt, Double value) {
		this.nn = node;
		this.pt = prnt;
		this.v = value;
	}

	public E(int node, int prnt) {
		this.nn = node;
		this.pt = prnt;
		this.v = OO;
	}

	@Override
	public int compareTo(E b) {
		return v.compareTo(b.v);
	}

	@Override
	public String toString() {
		return "[" + nn + " : " + v + "]";
	}
}

class Adj {
	List<Edge> adj;

	public Adj() {
		adj = new ArrayList<Edge>();
	}

	public void add(Edge e) {
		if (adj == null) adj = new ArrayList<Edge>();
		adj.add(e);
	}

	public void add(int node, double v) {
		if (adj == null) adj = new ArrayList<Edge>();
		adj.add(new Edge(node, v));
	}

	public void add(int node) {
		if (adj == null) adj = new ArrayList<Edge>();
		adj.add(new Edge(node));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Edge e : adj) {
			sb.append(e.toString() + " , ");
		}
		return sb.toString();
	}
}

class Stop {

	String stopId, name, dscr, zoneId, url, type, motherStation;
	double lat, lng;

	public Stop(String val) {
		String[] ss = val.split(",");
		this.stopId = ss[0];
		this.name = ss[1].replaceAll("\"", "");
		this.dscr = ss[2];
		this.lat = toRad(Double.parseDouble(ss[3]));
		this.lng = toRad(Double.parseDouble(ss[4]));
		this.zoneId = ss[5];
		this.url = ss[6];
		this.type = ss[7];
		// this.motherStation = ss[8];
		this.motherStation = "";
	}

	private double toRad(double deg) {
		return (deg / 180) * Math.PI;
	}

	public double Dist(Stop b) {
		double x = (b.lng - lng) * Math.cos((b.lat + lat) / 2);
		double y = b.lat - lat;
		return Math.sqrt(x * x + y * y);
	}

	@Override
	public String toString() {
		return stopId + " : " + name + "  (" + lat + " , " + lng + ")";
	}
}

public class TANNetwork {
	private static final Double OO = Double.MAX_VALUE;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String startPoint = in.nextLine().split(":")[1];
		String endPoint = in.nextLine().split(":")[1];
		int N = Integer.parseInt(in.nextLine());

		Stop[] stops = new Stop[N];
		Map<String, Integer> map = new HashMap<String, Integer>();
		Adj[] adjList = new Adj[N];

		int startId = -1, endId = -1, numVisited = 0;
		// Start Algorithm DIJSTRA
		PriorityQueue<E> q = new PriorityQueue<E>();
		boolean[] vist = new boolean[N];
		double[] dist = new double[N];
		int[] prnt = new int[N];
		for (int i = 0; i < N; i++) {
			stops[i] = new Stop(in.nextLine().split(":")[1]);
			adjList[i] = new Adj();
			map.put(stops[i].stopId, i);
			dist[i] = OO;
			prnt[i] = -1;
		}

		startId = map.get(startPoint);
		endId = map.get(endPoint);

		int M = Integer.parseInt(in.nextLine());

		for (int i = 0; i < M; i++) {
			String[] ss = in.nextLine().split(" ");
			Integer src = map.get(ss[0].split(":")[1]);
			Integer dst = map.get(ss[1].split(":")[1]);
			Double distance = stops[src].Dist(stops[dst]);
			adjList[src].add(dst, distance);
			// adjList[dst].add(src, distance);
		}
		q.offer(new E(startId, -1, 0.0));

		while (!q.isEmpty() && numVisited < N) {
			E t = q.poll();
			if (!vist[t.nn]) {
				vist[t.nn] = true;
				prnt[t.nn] = t.pt;
				dist[t.nn] = t.v;
				numVisited++;
				for (Edge u : adjList[t.nn].adj) {
					if (!vist[u.nn] && dist[t.nn] + u.v < dist[u.nn]) {
						q.offer(new E(u.nn, t.nn, dist[t.nn] + u.v));
					}
				}
			}
		}
		int idx = endId;
		if (prnt[idx] == -1 && startId != endId) {
			System.out.println("IMPOSSIBLE");
		} else {
			StringBuilder res = new StringBuilder();
			while (idx != -1) {
				res.insert(0, stops[idx].name);
				idx = prnt[idx];
				if (idx != -1) res.insert(0, "\n");
			}
			System.out.println(res.toString());
		}

		in.close();
	}
}
