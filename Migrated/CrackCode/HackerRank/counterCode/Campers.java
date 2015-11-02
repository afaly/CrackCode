package counterCode;

import java.util.Scanner;

public class Campers {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int N = I(s[0]), K = I(s[1]);
		s = in.nextLine().split("\\s+");
		boolean[] n = new boolean[N];
		for (int i = 0; i < K; i++) {
			int v = I(s[i]) - 1;
			n[v] = true;
			if (v > 0) n[v - 1] = true;
			if (v < N - 1) n[v + 1] = true;
		}
		int cnt = K, l = N;
		for (int i = 1; i < N; i++) {
			if (n[i]) {
				l = i;
				for (int j = i - 1; j >= 0 && !n[j]; j -= 2) {
					cnt++;
				}
			}
		}
		for (int i = l + 1; i < N; i += 2)
			cnt++;
		System.out.println(cnt);
		in.close();
	}
}
