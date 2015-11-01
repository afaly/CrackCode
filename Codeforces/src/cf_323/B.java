package cf_323;

import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine()), cnt = 0, val = 0, OO = 1000000000;
		int[] n = IA(in.nextLine());
		while (val < N) {
			for (int i = 0; i < N; i++)
				if (n[i] <= val) {
					val++;
					n[i] = OO;
				}
			if (val < N) {
				cnt++;
				for (int i = N - 1; i >= 0; i--) {
					if (n[i] <= val) {
						val++;
						n[i] = OO;
					}
				}
				if (val < N) cnt++;
			}
		}
		System.out.println(cnt);
		in.close();
	}
}
