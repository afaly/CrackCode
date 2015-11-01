package easy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * The code below will read all the game information for you. On each game turn,
 * information will be available on the standard input, you will be sent: -> the
 * total number of visible enemies -> for each enemy, its name and distance from
 * you The system will wait for you to write an enemy name on the standard
 * output. Once you have designated a target: -> the cannon will shoot -> the
 * enemies will move -> new info will be available for you to read on the
 * standard input.
 **/
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
			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");
			if (!pq.isEmpty())
				System.out.println(pq.peek().name); // The name of the most
			// threatening enemy (HotDroid
			// is just one example)
		}
	}
}