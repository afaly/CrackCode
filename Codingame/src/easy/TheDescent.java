package easy;

import java.util.PriorityQueue;
import java.util.Scanner;

class Mountains implements Comparable<Mountains> {
	int id;
	int dist;

	public Mountains(int id, int dist) {
		this.id = id;
		this.dist = dist;
	}

	@Override
	public int compareTo(Mountains m) {
		return m.dist - dist;
	}
}

public class TheDescent {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		boolean right = true;
		// game loop
		while (true) {
			int SX = in.nextInt();
			int SY = in.nextInt();
			PriorityQueue<Mountains> pq = new PriorityQueue<Mountains>();
			String order = "";
			for (int i = 0; i < 8; i++) {
				pq.offer(new Mountains(i, in.nextInt()));
			}
			boolean cont = true;
			while (!pq.isEmpty() && cont) {
				Mountains top = pq.poll();
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
			if (SX == 7) right = false;
			if (SX == 0) right = true;

			System.out.println(order);

			in.close();
		}
	}
}
