package codeforces;

import java.util.Scanner;

public class TableDecorations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long r = in.nextLong();
		long g = in.nextLong();
		long b = in.nextLong();
		long res = 0l;
		long v = Math.min(r, Math.min(g, b));
		res += v;
		r -= v;
		g -= v;
		b -= v;
		if (r == 0) v = Math.min(g, b);
		if (g == 0) v = Math.min(r, b);
		if (b == 0) v = Math.min(g, r);
		res += Math.min((r + g + b) / 3, v);
		System.out.println(res);
		in.close();
	}

}
