package cf_298;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int N = Integer.parseInt(s[0]);
		long A = Long.parseLong(s[1]);
		int[] n = new int[N];
		s = in.nextLine().split("\\s+");
		long sum = 0;
		for (int i = 0; i < N; i++) {
			n[i] = Integer.parseInt(s[i]);
			sum += n[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int d = n[i];
			long u = Math.min(d, A - (N - 1));
			long x = Math.max(sum - d, 0);
			long l = (A > x ? (A - x) : 1);
			sb.append((d - ((u - l) + 1)) + " ");
		}
		System.out.println(sb.toString().trim());
		in.close();
	}

}
