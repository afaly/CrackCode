package cf_298;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int v1 = in.nextInt();
		int v2 = in.nextInt();
		int t = in.nextInt();
		int d = in.nextInt();

		int v = v1;
		int D = v1;
		t--;
		boolean acc = true;
		// System.out.println(v);
		// Accelerate:
		int[] n = new int[t];
		for (int i = 0; i < t; i++) {
			n[i] = v1 + i * d;
		}

		for (int i = t - 1; i >= 0; i--) {
			n[t - i - 1] = Math.min(n[i], v2 + i * d);
		}

		while (acc) {
			acc = false;
			for (int i = d; i >= 0; i--) {
				if (t > 0 && Math.abs(v2 - (v + i)) <= (t - 1) * d) {
					t--;
					v += i;
					D += v;
					// System.out.println("V1: " + v);
					acc = true;
					break;
				}
			}
		}

		while (t > 0) {
			t--;
			v -= Math.min(d, v - v2);
			// System.out.println("V2: " + v);
			D += v;
		}
		// System.out.println(v);
		System.out.println(D);
		in.close();
	}
}
