package hard;

import java.util.Arrays;
import java.util.Scanner;

public class SuperComputer {
	static class p implements Comparable<p> {
		int s, d;

		public p(int start, int duration) {
			this.s = start;
			this.d = duration;
		}

		@Override
		public int compareTo(p that) {
			return this.s - that.s == 0 ? this.d - that.d : -(this.s - that.s);
		}

		@Override
		public String toString() {
			return s + ":" + (s + d);
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		p[] s = new p[N];
		for (int i = 0; i < N; i++) {
			s[i] = new p(in.nextInt(), in.nextInt());
		}

		Arrays.sort(s);
		// System.err.println(Arrays.toString(s));

		int cnt = 0, spre = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (s[i].s + s[i].d <= spre) {
				spre = s[i].s;
				cnt++;
			}
		}

		System.out.println(cnt);

		in.close();
	}
}
