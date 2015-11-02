package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class DEC_LONG_A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while (T-- > 0) {
			int N = Integer.parseInt(in.nextLine());
			String[] ss = in.nextLine().split(" ");
			int[] v = new int[N];
			for (int i = 0; i < N; i++)
				v[i] = Integer.parseInt(ss[i]);
			Arrays.sort(v);
			int cnt = 0;
			int cur = -1;
			for (int i = N - 1; i >= 0; i--) {
				if (v[i] != cur && v[i] > v[0]) {
					cnt++;
					cur = v[i];
				}
			}
			cnt++;
			System.out.println(cnt);
		}
		in.close();
	}
}
