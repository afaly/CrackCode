package Goodbye2014;

import java.util.Scanner;

public class NewYearTransportation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().trim().split(" ");

		int N = Integer.parseInt(ss[0]);
		int T = Integer.parseInt(ss[1]);
		int[] p = new int[N + 1];
		ss = in.nextLine().trim().split(" ");
		for (int i = 1; i <= N - 1; i++)
			p[i] = i + Integer.parseInt(ss[i - 1]);

		boolean[] f = new boolean[N + 1];
		int pos = 1;
		while (!f[pos] && pos != T) {
			f[pos] = true;
			pos = p[pos];
		}
		if (pos == T)
			System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}

}
