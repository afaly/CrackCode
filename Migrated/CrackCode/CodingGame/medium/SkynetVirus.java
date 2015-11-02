package medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	Integer id, pt;

	public Node(Integer id, Integer pt) {
		this.id = id;
		this.pt = pt;
	}

	@Override
	public String toString() {
		return id + " : " + pt;
	}
}

class adj {
	ArrayList<Integer> lst;

	public adj() {
		lst = new ArrayList<Integer>();
	}

	public int len() {
		return lst.size();
	}

	public void add(int node) {
		lst.add(node);
	}

	public void addAll(Collection<Integer> nodes) {
		lst.addAll(nodes);
	}

	public ArrayList<Integer> getAdjList() {
		return lst;
	}
}

public class SkynetVirus {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // the total number of nodes in the
								// level,including the gateways
		int L = in.nextInt(); // the number of links
		int E = in.nextInt(); // the number of exit gateways

		// Map Network:
		adj[] m = new adj[N];
		for (int i = 0; i < N; i++)
			m[i] = new adj();
		for (int i = 0; i < L; i++) {
			int N1 = in.nextInt();
			int N2 = in.nextInt();
			m[N1].add(N2);
			m[N2].add(N1);
		}

		// Exit Gatways:
		HashSet<Integer> e = new HashSet<Integer>(E);
		for (int i = 0; i < E; i++)
			e.add(in.nextInt()); // the index of a gateway node

		// game loop
		while (true) {
			int SI = in.nextInt(); // The index of the node on which the Skynet
									// agent is positioned this turn
			Node EX = null;
			Queue<Node> q = new LinkedList<Node>();
			boolean[] f = new boolean[N];
			int[] pts = new int[N];
			q.add(new Node(SI, SI));
			boolean found = false;
			for (int sz = q.size(); !q.isEmpty() && !found; sz = q.size()) {
				while (sz-- > 0 && !found) {
					Node n = q.poll();
					if (e.contains(n.id)) {
						f[n.id] = true;
						pts[n.id] = n.pt;
						EX = n;
						found = true;
					} else if (!f[n.id]) {
						f[n.id] = true;
						pts[n.id] = n.pt;
						for (Integer nn : m[n.id].getAdjList())
							q.add(new Node(nn, n.id));
					}
				}
			}
			int MI = EX.id, PT = pts[MI];
			while (EX != null && PT != SI) {
				MI = PT;
				PT = pts[MI];
			}

			System.out.println(SI + " " + MI);

			in.close();
		}
	}
}
