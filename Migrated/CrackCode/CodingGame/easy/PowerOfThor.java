package easy;

import java.util.Scanner;

public class PowerOfThor {

	public static int X = 40;
	public static int Y = 18;

	public static boolean check(int i, int j) {
		return i >= 0 && i < X && j >= 0 && j < Y;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int LX = in.nextInt(); // the X position of the light of power
		int LY = in.nextInt(); // the Y position of the light of power
		int TX = in.nextInt(); // Thor's starting X position
		int TY = in.nextInt(); // Thor's starting Y position
		int dx = TX - LX;
		int dy = TY - LY;
		String[] xd = { "W", "", "E" };
		String[] yd = { "N", "", "S" };
		// game loop
		while (true) {
			// The level of Thor's remaining energy, representing the number of
			// moves he can still make.
			int E = in.nextInt();
			int sx = 0, sy = 0;
			if (dx < 0) {
				if (TX + 1 < X) {
					sx = 1;
					dx++;
				}
			} else if (dx > 0) {
				if (TX - 1 >= 0) {
					sx = -1;
					dx--;
				}
			}

			if (dy < 0) {
				if (TY + 1 < Y) {
					sy = 1;
					dy++;
				}
			} else if (dy > 0) {
				if (dy - 1 >= 0) {
					sy = -1;
					dy--;
				}
			}
			System.out.println(yd[sy + 1] + xd[sx + 1]);

			in.close();
		}
	}
}
