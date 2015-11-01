package noSpoon;

import java.util.Scanner;

public class A {

	public static int[] parseInt(String s) {
		String[] ss = s.split("\\s+");
		int[] val = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			val[i] = Integer.parseInt(ss[i]);
		return val;
	}

	public static long[] parseLong(String s) {
		String[] ss = s.split("\\s+");
		long[] val = new long[ss.length];
		for (int i = 0; i < ss.length; i++)
			val[i] = Long.parseLong(ss[i]);
		return val;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int w = Integer.parseInt(in.nextLine());
		int h = Integer.parseInt(in.nextLine());
		char[][] m = new char[h][w];
		for (int i = 0; i < h; i++)
			m[i] = in.nextLine().toCharArray();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (m[i][j] == '0') {
					int k = -1, l = -1, o = -1, p = -1;
					boolean found = false;
					for (int x = 1; i + x < h && !found; x++) {
						if (m[i + x][j] == '0') {
							found = true;
							k = i + x;
							l = j;
						}
					}
					found = false;
					for (int y = 1; j + y < w && !found; y++) {
						if (m[i][j + y] == '0') {
							found = true;
							o = i;
							p = j + y;
						}
					}
					System.out.println(i + " " + j + " " + o + " " + p + " "
							+ k + " " + l);
				}
			}
		}
		in.close();
	}
}
