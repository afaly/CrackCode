package easy;

import java.util.Scanner;

public class MarsLander_01 {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(String[] ss) {
			this.x = Integer.parseInt(ss[0]);
			this.y = Integer.parseInt(ss[1]);
		}

		public double dist(Point p) {
			return Math.sqrt(((p.x - x) * (p.x - x)) + ((p.y - y) * (p.y - y)));
		}

		public long dist2(Point p) {
			return ((p.x - x) * (p.x - x)) + ((p.y - y) * (p.y - y));
		}

		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}

	public static int[] gamePosition(String[] ss) {
		int[] val = new int[ss.length];
		for (int i = 0; i < ss.length; i++) {
			val[i] = Integer.parseInt(ss[i]);
		}
		return val;
	}

	private static final double G = 3.711;
	private static final int VSL = 40, VSL2 = VSL * VSL, HSL = 20;
	private static final int SPEED_STEP = 1, ANGLE_STEP = 15;

	private static final int Al = 0;
	private static final int MAX_P = 4, MIN_P = 0;
	private static final int MARG = 2;

	public static int Power(int YL, int Y, int VS) {
		for (int i = MIN_P; i < MAX_P; i++) {
			double A = G - i;
			double V = Math.ceil(2 * A * (Y - YL) + (VS * VS));
			System.err.println("V: " + V + "  |  " + VSL2);
			if (V < VSL2) return i;
		}
		return MAX_P;
	}

	public static int Pow(int startPos, int targetPos, int curentPos, int V0,
			int V) {
		System.err.println("Target Velocity : " + VSL + "\nCurrent Velocity : "
				+ V);
		double lerpFactor = (V0 - V) / (-VSL - V);
		double v = lerp(V, VSL, lerpFactor);
		System.err.println("Lerp Factor: " + lerpFactor);
		System.err.println("Power: " + v + "  > " + Math.ceil(v));
		return (int) Math.min(4, Math.abs(v));
	}

	public static double lerp(int startPos, int targetPos, double lerpFactor) {
		double smothStepFactor = lerpFactor * lerpFactor
				* (3.0 - 2.0 * lerpFactor);
		return startPos + (targetPos - startPos) * smothStepFactor;
	}

	private static Point[] points;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine()); // the number of points used to
													// draw the surface of Mars.
		points = new Point[N];
		// X coordinate of a surface point. (0 to 6999)
		// Y coordinate of a surface point.
		for (int i = 0; i < N; i++)
			points[i] = new Point(in.nextLine().split(" "));

		int cur = 0, pre = 0, start_land = 0, end_land = 0;
		for (int i = 1; i < N; i++) {
			cur = i;
			if (points[pre].y == points[cur].y) {
				start_land = pre;
				end_land = cur;
			}
			pre = cur;
		}

		System.err.println("Start land: " + points[end_land]);
		System.err.println("End   land: " + points[start_land]);

		Integer Y0 = null, V0 = null;
		int power = 0, angle = 0;

		// game loop
		while (true) {
			int[] game = gamePosition(in.nextLine().split(" "));
			// Position:
			int X = game[0];
			int Y = game[1];
			// Speed:
			int HS = game[2]; // the horizontal speed (in m/s), can be negative.
			int VS = game[3]; // the vertical speed (in m/s), can be negative.
			// Status:
			int F = game[4]; // the quantity of remaining fuel in liters.
			int R = game[5]; // the rotation angle in degrees (-90 to 90).
			int P = game[6]; // the thrust power (0 to 4).

			if (Y0 == null) Y0 = Y;
			if (V0 == null) V0 = VS;

			if ((Y < 450 + points[start_land].y && VS < -34) || VS < -40) {
				power = Math.min(power + SPEED_STEP, 4);
			} else {
				power = Math.max(power - SPEED_STEP, 0);
			}
			System.out.println(angle + " " + power);

			in.close();
		}

	}
}
