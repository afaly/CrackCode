package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/

class Skynet {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt(); // the total number of nodes in the level,
								// including the gateways
		int L = in.nextInt(); // the number of links
		int E = in.nextInt(); // the number of exit gateways
		boolean[][] m = new boolean[N][N];
		boolean[] f = new boolean[N];
		for (int i = 0; i < L; i++) {
			int N1 = in.nextInt();
			int N2 = in.nextInt();
			m[N1][N2] = true;
			m[N2][N1] = true;
		}
		HashSet<Integer> e = new HashSet<Integer>(E);
		for (int i = 0; i < E; i++) {
			e.add(in.nextInt()); // the index of a gateway node
		}

		// game loop
		while (true) {
			int SI = in.nextInt(); // The index of the node on which the Skynet
									// agent is positioned this turn
			int MI = -1;
			int D = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				if (m[SI][i]) {
					Queue<P> q = new LinkedList<P>();
					q.add(new P(i, 1));
					while (!q.isEmpty()) {
						P nxt = q.poll();
						f[nxt.i] = true;
						if (e.contains(nxt.i)) {
							if (nxt.dist < D) {
								D = nxt.dist;
								MI = i;
							}
							break;
						} else {
							for (int j = 0; j < N; j++) {
								if (m[i][j] && !f[j])
									q.add(new P(j, nxt.dist + 1));
							}
						}
					}
				}
			}
			if (MI >= 0)
				System.out.println(SI + " " + MI);
			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");

			// System.out.println("1 2"); // Example: 0 1 are the indices of the
			// nodes you wish to sever the link between
		}
	}
}

class P {
	int i, dist;

	public P(int i, int dist) {
		this.i = i;
		this.dist = dist;
	}
}
