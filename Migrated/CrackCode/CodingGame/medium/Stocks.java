package medium;

import java.util.ArrayList;
import java.util.Scanner;

public class Stocks {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String[] vs = in.nextLine().split(" ");
		long[] n = new long[N];
		for (int i = 0; i < N; i++) {
			n[i] = Long.parseLong(vs[i]);
		}
		int xi = 0;
		int yi = 0;
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		while (xi <= yi && xi < N && yi < N) {
			int i = xi;
			while (i + 1 < N && n[i + 1] > n[xi])
				i++;
			int j = i;
			while (j + 1 < N && n[j + 1] < n[yi])
				j++;
			x.add(i);
			y.add(j);
			xi = j + 1;
			yi = j + 1;
		}

		boolean modified = true;
		while (x.size() != 1 && modified) {
			modified = false;
			ArrayList<Integer> xx = new ArrayList<Integer>();
			ArrayList<Integer> yy = new ArrayList<Integer>();
			int x1 = x.get(0), x2 = x.get(0);
			int y1 = y.get(0), y2 = y.get(0);
			for (int i = 1; i < x.size(); i++) {
				x2 = x.get(i);
				y2 = y.get(i);
				if (n[x1] > n[x2]) {
					if (n[y2] <= n[y1]) {
						xx.add(x1);
						yy.add(y2);
						y2 = y1;
						modified = true;
						continue;
					}
				}
				xx.add(x1);
				yy.add(y1);
				x1 = x2;
				y1 = y2;
			}
			xx.add(x2);
			yy.add(y2);
			x = xx;
			y = yy;
		}
		long d = n[y.get(0)] - n[x.get(0)];
		for (int i = 1; i < x.size(); i++) {
			d = Math.min(n[y.get(i)] - n[x.get(i)], d);
		}
		System.out.println(d);
		in.close();
	}
}
