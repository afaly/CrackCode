package easy;

import java.util.PriorityQueue;
import java.util.Scanner;

class Temp implements Comparable<Temp> {
	int temp, delta;

	public Temp(int temp, int delta) {
		this.temp = temp;
		this.delta = delta;
	}

	@Override
	public int compareTo(Temp t) {
		int x = Math.abs(delta) - Math.abs(t.delta);
		if (x == 0) return t.temp - temp;
		else return x;
	}
}

public class Temperatuers {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // the number of temperatures to analyse
		in.nextLine();
		if (N > 0) {
			// The N temperatures expressed as integers ranging from -273 to
			// 5526
			String[] TEMPS = in.nextLine().split(" ");
			PriorityQueue<Temp> pq = new PriorityQueue<Temp>();
			for (String tempStr : TEMPS) {
				int val = Integer.parseInt(tempStr);
				pq.offer(new Temp(val, val));
			}

			if (!pq.isEmpty()) System.out.println(pq.poll().temp);
		} else {
			System.out.println("0");
		}

		in.close();
	}
}
