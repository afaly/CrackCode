package cf_303;

import java.util.Scanner;

public class C {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	static class P {
		int i, h, s;

		public P(int i, int h) {
			this.i = i;
			this.h = h;
			this.s = 0;
		}

		@Override
		public String toString() {
			return i + "," + h + ":" + s;
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		String[] s;
		P[] n = new P[N];
		for (int i = 0; i < N; i++) {
			s = in.nextLine().split("\\s+");
			n[i] = new P(I(s[0]), I(s[1]));
		}
		int i = n[0].i, h = n[0].h, cnt = 1;
		n[0].s = -1;
		boolean cut = true;
		for (int k = 1; k < N - 1; k++) {
			if (cut) {
				int l = n[k].i - n[k].h;
				int r = n[k].i + n[k].h;
				cut = false;
				if (l > 1 && l > n[k - 1].i
						&& l > n[k - 1].i + (n[k - 1].s * n[k - 1].h)) {
					cnt++;
					n[k].s = -1;
					cut = true;
				} else if (r < n[k + 1].i) {
					cnt++;
					n[k].s = 1;
					cut = true;
				}
			} else {
				int l = n[k].i - n[k].h;
				int r = n[k].i + n[k].h;
				cut = false;
				if (l > 1 && l > n[k - 1].i) {
					cnt++;
					n[k].s = -1;
					cut = true;
				} else if (r < n[k + 1].i) {
					cnt++;
					n[k].s = 1;
					cut = true;
				}
			}
		}
		if (N > 1) cnt++;
		System.out.println(cnt);
		in.close();
	}
}
