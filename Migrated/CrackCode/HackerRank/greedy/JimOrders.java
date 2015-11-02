package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class JimOrders {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	static class p implements Comparable<p> {
		int i, v;

		public p(int idx, int value) {
			this.i = idx;
			this.v = value;
		}

		@Override
		public int compareTo(p b) {
			return v - b.v == 0 ? i - b.i : v - b.v;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		p[] n = new p[N];
		String[] s;
		for (int i = 0; i < N; i++) {
			s = in.nextLine().split("\\s+");
			n[i] = new p(i + 1, I(s[0]) + I(s[1]));
		}
		Arrays.sort(n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(n[i].i).append(" ");
		System.out.println(sb.toString().trim());
		in.close();
	}
}
