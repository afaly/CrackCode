package easy;

import java.util.Scanner;

public class SkynetChasm {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt(); // the length of the road before the gap.
		int G = in.nextInt(); // the length of the gap.
		int L = in.nextInt(); // the length of the landing platform.
		// game loop
		while (true) {
			int S = in.nextInt(); // the motorbike's speed.
			int X = in.nextInt(); // the position on the road of the
									// motorbike.
			if (S < G + 1 && X <= R && X + S <= R) {
				System.out.println("SPEED");
			} else if (X <= R && X + S > R) {
				System.out.println("JUMP");
			} else if (X >= R + G || S > G + 1) {
				System.out.println("SLOW");
			} else {
				System.out.println("WAIT");
			}

			in.close();
		}
	}
}
