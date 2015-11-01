package easy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class M implements Comparable<M> {
	int id;
	int dist;

	public M(int id, int dist) {
		this.id = id;
		this.dist = dist;
	}

	@Override
	public int compareTo(M m) {
		return dist - m.dist;
	}
}

class Mountains {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		boolean right = true;
		// game loop
		while (true) {
			int SX = in.nextInt();
			int SY = in.nextInt();
			PriorityQueue<M> pq = new PriorityQueue<M>();
			String order = "";
			for (int i = 0; i < 8; i++) {
				pq.offer(new M(i, in.nextInt()));
			}
			boolean cont = true;
			while (!pq.isEmpty() && cont) {
				M top = pq.poll();
				if (top.id == SX) {
					order = "FIRE";
					cont = false;
				}
				if (right) {
					if (top.id > SX) {
						order = "HOLD";
						cont = false;
					}
				} else {
					if (top.id < SX) {
						order = "HOLD";
						cont = false;
					}
				}
			}
			if (SX == 7)
				right = false;
			if (SX == 0)
				right = true;
			System.out.println(order);
		}
	}
}