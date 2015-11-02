package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockMiniMax {
	private static int P, Q;

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int D(int a, int b) {
		return Math.abs(a - b);
	}

	public static boolean V(int v) {
		return v >= P && v <= Q;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		int[] n = new int[N];
		String[] s = in.nextLine().split("\\s+");
		for (int i = 0; i < N; i++)
			n[i] = I(s[i]);
		s = in.nextLine().split("\\s+");
		P = I(s[0]);
		Q = I(s[1]);
		int MAX = 0, VAL = 0, VALUE = 0, MID, FLOR = Q;
		Arrays.sort(n);
		if (P < n[0] && D(P, n[0]) > MAX) {
			VAL = P;
			MAX = D(P, n[0]);
		}
		if (Q < n[N - 1]) {
			for (int i = 1; i < N; i++) {
				if (n[i] > Q) {
					MID = Math.min((n[i] - Q), (Q - n[i - 1]));
					if (MID > MAX) {
						VAL = Q;
						MAX = MID;
					}
					break;
				}
			}
		} else {
			if (D(Q, n[N - 1]) > MAX) {
				VAL = Q;
				MAX = D(Q, n[N - 1]);
			}
		}
		for (int i = 1; i < N; i++) {
			MID = (n[i] - n[i - 1]) / 2;
			VALUE = MID + n[i - 1];
			if (MID > MAX && V(VALUE)) {
				MAX = MID;
				VAL = VALUE;
			}
			VALUE = n[i] - MID;
			if (MID > MAX && V(VALUE)) {
				MAX = MID;
				VAL = VALUE;
			}
		}
		System.out.println(VAL);
		in.close();
	}
}
