package zetolabs_2015;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	private static int mem[], H[], W[];
	private static int C, HR, HB, WR, WB;

	public static int Joy(int w, int t) {
		if (w < 0) return 0;
		if (w == 0) return H[t];
		if (mem[w] > 0) return mem[w];
		int a = 0, b = 0;
		if (w - W[0] > 0) a = H[0] + Joy(w - W[0], 0);
		if (w - W[1] > 0) b = H[1] + Joy(w - W[1], 1);
		mem[w] = Math.max(a, b);
		return mem[w];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		C = in.nextInt();
		HR = in.nextInt();
		HB = in.nextInt();
		WR = in.nextInt();
		WB = in.nextInt();
		H = new int[] { HR, HB, 0 };
		W = new int[] { WR, WB };
		mem = new int[C + 1];
		int v = Joy(C, 2);
		System.out.println(Arrays.toString(mem));
		System.out.println(v);

		/*-
		double VR = 1.0 * HR / WR, VB = 1.0 * HB / WB;
		int joy = 0;
		if (VR > VB) {
			long v = C / WR;
			long r = C % WR;
			if (r == 0 || r % WB == 0) {
				joy += v * HR;
				joy += (r / WB) * HB;
			} else {
				boolean solved = false;
				for (long w = r; w < C && !solved; w += WR) {
					if (w % WB == 0) {
						joy += (w / WB) * HB;
						joy += (((C - w) / WR) * HR);
						solved = true;
					}
				}
				if (!solved) {
					joy += v * HR;
					joy += (r / WB) * HB;
				}
			}
		} else {
			long v = C / WB;
			long r = C % WB;
			if (r == 0 || r % WR == 0) {
				joy += v * HB;
				joy += (r / WR) * HR;
			} else {
				boolean solved = false;
				for (long w = r; w < C && !solved; w += WB) {
					if (w % WR == 0) {
						joy += (w / WR) * HR;
						joy += (((C - w) / WB) * HB);
						solved = true;
					}
				}
				if (!solved) {
					joy += v * HB;
					joy += (r / WR) * HR;
				}
			}
		}
		System.out.println(joy);
		 */
		in.close();
	}
}
