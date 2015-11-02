package src;

import java.util.Scanner;

public class C {

	static class CH {
		char v;
		int s;

		@Override
		public String toString() {
			return s > 0 ? "" + v : "-" + v;
		}

		public boolean isChar(char c) {
			return v == c;
		}

		public CH(char v, int sign) {
			this.v = v;
			this.s = sign;
		}

		public void Mult(char u) {
			if (v == '1') v = u;
			else {
				if (v == 'i') {
					if (u == 'i') {
						v = '1';
						s *= NEG;
					} else if (u == 'j') {
						v = 'k';
					} else {
						v = 'j';
						s *= NEG;
					}
				} else if (v == 'j') {
					if (u == 'i') {
						v = 'k';
						s *= NEG;
					} else if (u == 'j') {
						v = '1';
						s *= NEG;
					} else {
						v = 'i';
					}
				} else {
					if (u == 'i') {
						v = 'j';
					} else if (u == 'j') {
						v = 'i';
						s *= NEG;
					} else {
						v = '1';
						s *= NEG;
					}
				}
			}
		}

		public void Mult(char u, int sign) {
			if (v == '1') v = u;
			else {
				s *= sign;
				if (v == 'i') {
					if (u == 'i') {
						v = '1';
						s *= NEG;
					} else if (u == 'j') {
						v = 'k';
					} else {
						v = 'j';
						s *= NEG;
					}
				} else if (v == 'j') {
					if (u == 'i') {
						v = 'k';
						s *= NEG;
					} else if (u == 'j') {
						v = '1';
						s *= NEG;
					} else {
						v = 'i';
					}
				} else {
					if (u == 'i') {
						v = 'j';
					} else if (u == 'j') {
						v = 'i';
						s *= NEG;
					} else {
						v = '1';
						s *= NEG;
					}
				}
			}
		}
	}

	private static final int RES = 1, SGN = 0;
	private static final int POS = 1, NEG = -1;

	private static int[] mult(char[] c, int i, char f) {
		char v = '1', u;
		int s = POS;
		for (int j = i; j < c.length; j++) {
			u = c[i];
			if (v == '1') v = u;
			else {
				if (v == 'i') {
					if (u == 'i') {
						v = '1';
						s *= NEG;
					} else if (u == 'j') {
						v = 'k';
					} else {
						v = 'j';
						s *= NEG;
					}
				} else if (v == 'j') {
					if (u == 'i') {
						v = 'k';
						s *= NEG;
					} else if (u == 'j') {
						v = '1';
						s *= NEG;
					} else {
						v = 'i';
					}
				} else {
					if (u == 'i') {
						v = 'j';
					} else if (u == 'j') {
						v = 'i';
						s *= NEG;
					} else {
						v = '1';
						s *= NEG;
					}
				}
			}
			if (v == f) return new int[] { i + 1, s };
		}
		return new int[] { -1, -1 };
	}

	public static boolean solve(char[] c, int l, int x) {
		long t = x * l;
		if (t < 3) return false;
		if (t == 3) return c[0] == 'i' && c[1] == 'j' && c[2] == 'k';
		CH curi = new CH('1', POS);
		for (int i = 0; i < t; i++) {
			int idxi = (int) (i % l);
			curi.Mult(c[idxi]);
			if (curi.isChar('i')) {
				CH curj = new CH('1', curi.s);
				for (int j = idxi + 1; j < t; j++) {
					int idxj = (int) (j % l);
					curj.Mult(c[idxj]);
					if (curj.isChar('j')) {
						CH curk = new CH('1', curj.s);
						for (int k = idxj + 1; k < t; k++) {
							int idxk = (int) (k % l);
							curk.Mult(c[idxk]);
						}
						if (curk.isChar('k') && curk.s == POS) return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for (int t = 1; t <= T; t++) {
			String[] s = in.nextLine().split("\\s+");
			int L = Integer.parseInt(s[0]);
			int X = Integer.parseInt(s[1]);
			char[] c = in.nextLine().toCharArray();
			boolean ans = solve(c, L, X);
			String ansStr = ans ? "YES" : "NO";
			System.out.println("Case #" + t + ": " + ansStr);
		}
		in.close();
	}
}
