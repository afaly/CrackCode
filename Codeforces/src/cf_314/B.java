package cf_314;

import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		boolean[] n = new boolean[1000001];
		int[] f = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			String[] s = in.nextLine().split("\\s+");
			int v = I(s[1]);
			f[i] = f[i - 1];
			if (s[0].equalsIgnoreCase("-")) {
				if (n[v]) {
					f[i]--;
				} else {
					for (int j = i - 1; j >= 0; j--)
						f[j]++;
				}
				n[v] = false;
			} else {
				f[i]++;
				n[v] = true;
			}
		}
//		System.out.println(Arrays.toString(f));
		int max = 0;
		for (int i = 0; i <= N; i++) {
			max = Math.max(max, f[i]);
		}
		System.out.println(max);
		in.close();
	}
}
