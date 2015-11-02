package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node {
	Integer id, pt;

	public Node(Integer id, Integer pt) {
		this.id = id;
		this.pt = pt;
	}
}

class Adj {
	ArrayList<Integer> lst;

	public Adj() {
		this.lst = new ArrayList<Integer>();
	}

	public int len() {
		return lst.size();
	}

	public void add(Integer node) {
		lst.add(node);
	}

	public void addAll(Collection<Integer> all) {
		lst.addAll(all);
	}

	public void addAll(Adj all) {
		lst.addAll(all.lst);
	}

	public void print() {
		if (lst != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("[ ");
			for (Integer r : lst)
				sb.append(r + " ");
			sb.append("]");
			System.out.println(sb.toString());
		}
	}
}

class adjp {
	ArrayList<Node> lst;

	public adjp() {
		this.lst = new ArrayList<Node>();
	}

	public int len() {
		return lst.size();
	}

	public void add(Node node) {
		lst.add(node);
	}

	public void add(int id, int pt) {
		lst.add(new Node(id, pt));
	}

	public void addAll(Collection<Node> all) {
		lst.addAll(all);
	}
}

public class BFS {

	public static int[] bfs(int S, Adj[] G) {
		int[] dist = new int[G.length];
		boolean[] flag = new boolean[G.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		int d = 0, cnt = 1, count = 0;
		while (!q.isEmpty()) {
			int n = q.poll();
			if (!flag[n]) {
				dist[n] = d;
				flag[n] = true;
				q.addAll(G[n].lst);
				count += G[n].len();
			}
			if (--cnt == 0) {
				d++;
				cnt = count;
				count = 0;
			}
		}
		return dist;
	}

	public static int[] bfsAwesome(int S, Adj[] G) {
		int[] dist = new int[G.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.addAll(G[S].lst);
		for (int d = 1, sz = q.size(); !q.isEmpty(); d++, sz = q.size())
			while (sz-- > 0) {
				int n = q.poll();
				if (n != S && dist[n] == 0) {
					dist[n] = d;
					q.addAll(G[n].lst);
				}
			}
		return dist;
	}

	public static void bfsMany(Set<Integer> s, Adj[] G) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] dist = new int[G.length];
		int[] prnt = new int[G.length];
		q.addAll(s);
		for (Integer n : s)
			prnt[n] = n;
		for (int d = 1, sz = q.size(); !q.isEmpty(); d++, sz = q.size()) {
			while (sz-- > 0) {
				int n = q.poll();
				for (Integer nn : G[n].lst) {
					if (!s.contains(nn) && dist[nn] == 0) {
						dist[nn] = d;
						prnt[nn] = n;
						q.add(nn);
					}
				}
			}
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(prnt));
	}

	public static Adj[] bfsPath(int S, Adj[] G) {
		Queue<Node> q = new LinkedList<Node>();
		Adj[] p = new Adj[G.length];
		q.add(new Node(S, null));
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (p[n.id] == null) {
				p[n.id] = new Adj();
				if (n.pt != null) p[n.id].addAll(p[n.pt]);
				p[n.id].add(n.id);
				for (Integer nn : G[n.id].lst) {
					q.add(new Node(nn, n.id));
				}
			}
		}
		return p;
	}

	public static void main(String[] args) {
		Adj[] g = new Adj[10];
		for (int i = 0; i < g.length; i++)
			g[i] = new Adj();
		// g[0].add(1);
		g[0].add(2);
		// g[1].add(0);
		g[1].add(2);
		g[2].add(0);
		g[1].add(7);
		g[2].add(1);
		g[7].add(1);
		for (int i = 4; i < g.length; i++) {
			g[i - 1].add(i);
			g[i].add(i - 1);
		}

		System.out.println(Arrays.toString(bfs(0, g)));
		System.out.println(Arrays.toString(bfsAwesome(0, g)));
		Adj[] res = bfsPath(0, g);
		for (int i = 0; i < res.length; i++) {
			System.out.print(i + "\t: ");
			if (res[i] != null) res[i].print();
		}
		System.out.println("-------------------------");
		for (int i = 0; i < g.length; i++) {
			System.out.print(i + "\t: ");
			g[i].print();
		}
		Set<Integer> S = new HashSet<>();
		S.add(4);
		S.add(7);
		bfsMany(S, g);
	}

}
