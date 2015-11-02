package easy;

import java.util.Scanner;

public class Defibllirators {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		double LON = Double.parseDouble(in.nextLine().replace(",", "."));
		double LAT = Double.parseDouble(in.nextLine().replace(",", "."));
		int N = Integer.parseInt(in.nextLine());
		String MIN_NAME = "";
		double lon, lat, dist, MIN_DIST = Double.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String[] ss = in.nextLine().split(";");
			lon = Double.parseDouble(ss[4].replace(",", "."));
			lat = Double.parseDouble(ss[5].replace(",", "."));
			dist = Math.pow((lon - LON), 2) + Math.pow((lat - LAT), 2);
			if (dist < MIN_DIST) {
				MIN_DIST = dist;
				MIN_NAME = ss[1];
			}
		}
		System.out.println(MIN_NAME);

		in.close();
	}
}
