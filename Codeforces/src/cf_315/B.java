package cf_315;

import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[N];
		boolean[] m = new boolean[N];
		boolean[] f = new boolean[100001];
		for (int i = 0; i < N; i++) {
			n[i] = I(s[i]);
			if (!f[n[i]] && n[i] <= N) f[n[i]] = true;
			else
				m[i] = true;
		}

		StringBuilder sb = new StringBuilder();
		int j = 1;
		for (int i = 0; i < N; i++) {
			if (m[i]) {
				while (f[j])
					j++;
				n[i] = j;
				f[j] = true;
			}
			sb.append(n[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
		in.close();
	}

}
