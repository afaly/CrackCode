package easy;

import java.util.PriorityQueue;
import java.util.Scanner;

class e implements Comparable<e> {
	String name;
	int dist;

	public e(String name, int dist) {
		this.name = name;
		this.dist = dist;
	}

	@Override
	public int compareTo(e o) {
		return dist - o.dist;
	}
}

class StarShip {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		// game loop
		while (true) {
			int count = in.nextInt(); // The number of current enemy ships
										// within range
			PriorityQueue<e> pq = new PriorityQueue<e>();
			for (int i = 0; i < count; i++) {
				String enemy = in.next(); // The name of this enemy
				int dist = in.nextInt(); // The distance to your cannon of this
											// enemy
				pq.offer(new e(enemy, dist));
			}
			if (!pq.isEmpty()) System.out.println(pq.peek().name);
		}
	}
}