package geometry;

import static java.lang.Math.sin;
import static java.lang.Math.PI;

import java.util.Scanner;

public class PolygonCircle {

	public static double pArea(double r, int n) {
		return (n >> 1) * r * r * sin(2 * PI / n);
	}

	public static double pPerimeter(double r, int n) {
		return (n << 1) * r * sin(PI / n);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss;
		while (in.hasNextLine()) {
			String s = in.nextLine();
			if (s.isEmpty()) break;
			ss = s.split(" ");
			int r = Integer.parseInt(ss[0]);
			int n = Integer.parseInt(ss[1]);
			System.out.printf("%.3f", pArea(r, n));
		}
		in.close();
	}

}
