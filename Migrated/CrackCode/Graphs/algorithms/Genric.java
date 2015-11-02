package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Genric {

	static class UF {
		private int sz, cnt;
		private int[] uf, rk;

		public UF(int size) {
			this.uf = new int[size];
			this.rk = new int[size];
			this.sz = size;
			this.cnt = size;
			for (int i = 0; i < sz; i++)
				uf[i] = i;
		}

		public int find(int i) {
			if (uf[i] == i) return i;
			uf[i] = find(uf[i]);
			return uf[i];
		}

		public boolean same(int i, int j) {
			return find(i) == find(j);
		}

		public int union(int i, int j) {
			int pi = find(i);
			int pj = find(j);
			if (pi != pj) {
				cnt--;
				if (rk[pi] > rk[pj]) {
					uf[pj] = uf[pi];
					return pi;
				} else if (rk[pj] > rk[pi]) {
					uf[pi] = uf[pj];
					return pj;
				} else {
					uf[pj] = uf[pi];
					rk[pi]++;
					return pi;
				}
			}
			return pi;
		}

		public boolean isOneSet() {
			return cnt == 0;
		}
	}

	static class N implements Comparable<N> {
		int i, p;
		int s;

		public N(int prnt, int id, int score) {
			this.p = prnt;
			this.i = id;
			this.s = score;
		}

		public N(int id, int score) {
			this.i = id;
			this.s = score;
		}

		@Override
		public int compareTo(N n) {
			return s - n.s;
		}

	}

	static class E implements Comparable<E> {
		int s, d;
		int w;

		public E(int src, int dst, int weight) {
			this.s = src;
			this.d = dst;
			this.w = weight;
		}

		public E(int dst, int weight) {
			this.s = -1;
			this.d = dst;
			this.w = weight;
		}

		@Override
		public String toString() {
			return s + "-->" + d + "  : " + w;
		}

		@Override
		public int compareTo(E e) {
			return w - e.w;
		}
	}

	public static Map<String, Integer[]> DK(Map<Integer, ArrayList<E>> g,
			int src) {
		int sz = g.size();
		Integer[] dist = new Integer[sz], prnt = new Integer[sz];
		Arrays.fill(dist, 1000000000);
		PriorityQueue<N> pq = new PriorityQueue<N>();
		pq.offer(new N(src, src, 0));
		while (!pq.isEmpty()) {
			N node = pq.poll();
			if (dist[node.i].compareTo(node.s) > 0) {
				dist[node.i] = node.s;
				prnt[node.i] = node.p;
				for (E e : g.get(node.i)) {
					if (dist[e.d].compareTo(dist[e.s] + e.w) > 0) pq
							.offer(new N(e.s, e.d, dist[e.s] + e.w));
				}
			}
		}

		HashMap<String, Integer[]> res = new HashMap<String, Integer[]>();
		res.put("dist", dist);
		res.put("prnt", prnt);
		return res;
	}

	public static Map<String, Integer[]> BF(Map<Integer, ArrayList<E>> g,
			int src) {
		int sz = g.size();
		Integer[] dist = new Integer[sz], prnt = new Integer[sz];
		Arrays.fill(dist, 1000000000);
		dist[src] = 0;
		prnt[src] = src;
		boolean cycle = false;
		for (int i = 0; i < sz; i++) {
			cycle = false;
			for (int n = 0; n < sz; n++) {
				for (E e : g.get(n)) {
					if (dist[e.d].compareTo(dist[e.s] + e.w) > 0) {
						dist[e.d] = dist[e.s] + e.w;
						prnt[e.d] = e.s;
						cycle = true;
					}
				}
			}
		}

		HashMap<String, Integer[]> res = new HashMap<String, Integer[]>();
		res.put("dist", dist);
		res.put("prnt", prnt);
		return cycle ? null : res;
	}

	public static HashMap<String, Integer[][]> FW(Map<Integer, ArrayList<E>> g) {
		int sz = g.size();
		Integer[][] dist = new Integer[sz][sz];
		Integer[][] prnt = new Integer[sz][sz];
		for (int i = 0; i < sz; i++) {
			Arrays.fill(dist[i], 1000000000);
			Arrays.fill(prnt[i], -1);
			dist[i][i] = 0;
			prnt[i][i] = i;
			for (E e : g.get(i))
				dist[e.s][e.d] = e.w;
		}

		for (int k = 0; k < sz; k++) {
			for (int i = 0; i < sz; i++) {
				for (int j = 0; j < sz; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						prnt[i][j] = k;
					}
				}
			}
		}

		HashMap<String, Integer[][]> res = new HashMap<String, Integer[][]>();
		res.put("dist", dist);
		res.put("prnt", prnt);
		return res;
	}

	public static ArrayList<E> PRIM(Map<Integer, ArrayList<E>> g) {
		int sz = g.size();
		ArrayList<E> mst = new ArrayList<E>();
		PriorityQueue<E> pq = new PriorityQueue<E>();
		for (Integer n : g.keySet())
			pq.addAll(g.get(n));
		UF uf = new UF(sz);
		while (!pq.isEmpty() && !uf.isOneSet()) {
			E e = pq.poll();
			if (!uf.same(e.s, e.d)) {
				uf.union(e.s, e.d);
				mst.add(e);
			}
		}
		return mst;
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static double D(String s) {
		return Double.parseDouble(s);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Map<Integer, ArrayList<E>> g = new HashMap<Integer, ArrayList<E>>();
		Scanner in = new Scanner(new File("data/cp/in_07.txt"));
		String[] s = in.nextLine().split("\\s+");
		int N = I(s[0]), M = I(s[1]), start = I(s[2]);

		for (int i = 0; i < N; i++)
			g.put(i, new ArrayList<E>());
		for (int i = 0; i < M; i++) {
			s = in.nextLine().trim().split("\\s+");
			g.get(I(s[0])).add(new E(I(s[0]), I(s[1]), I(s[2])));
		}
		Map<String, Integer[]> ans = BF(g, start);
		System.out.println("DIST [BF]: " + Arrays.toString(ans.get("dist")));
		System.out.println("PRNT [BF]: " + Arrays.toString(ans.get("prnt")));
		ans = DK(g, start);
		System.out.println("DIST [DK]: " + Arrays.toString(ans.get("dist")));
		System.out.println("PRNT [DK]: " + Arrays.toString(ans.get("prnt")));
		System.out.println("--------------------------------------------");
		System.out.println("----------------------FW--------------------");
		HashMap<String, Integer[][]> fwm = FW(g);
		Integer[][] fw = fwm.get("dist");
		for (int i = 0; i < N; i++)
			System.out.println("SP of [" + i + "]: " + Arrays.toString(fw[i]));

		ArrayList<E> mst = PRIM(g);
		System.out.println("--------------------------------------------");
		System.out.println("--------------------MST---------------------");
		for (E e : mst)
			System.out.println(e);
		in.close();
	}
}
