package noSpoon;

import java.util.Scanner;

public class B {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int w = Integer.parseInt(in.nextLine());
		int h = Integer.parseInt(in.nextLine());
		int[][] m = new int[h][w];
		for (int i = 0; i < h; i++) {
			char[] c = in.nextLine().toCharArray();
			for (int j = 0; j < w; j++)
				m[i][j] = (int) (c[j] - '0');
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (m[i][j] > 0) {
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
