package timus;

import java.util.ArrayList;
import java.util.Scanner;

public class T_1118_NonTrivial_Numbers {

	private static ArrayList<Integer> p;

	private static void Init() {
		p = new ArrayList<Integer>();
		p.add(2);
		boolean[] f = new boolean[1000010];
		f[2] = true;
		for (int i = 3; i < f.length; i += 2) {
			if (!f[i]) {
				f[i] = true;
				p.add(i);
				for (int j = i; j < f.length; j += i)
					f[j] = true;
			}
		}
	}

	public static long sumFactors(int x) {
		long sum = 1l;
		boolean cont = true;
		while (x > 1 && cont) {
			for (Integer k : p) {
				if (k > x) {
					cont = false;
					break;
				}
				if (x % k == 0) {
					long val = 1l;
					long acc = 1l;
					while (x % k == 0) {
						acc *= k;
						val += acc;
						x /= k;
					}
					sum *= val;
				}
			}
		}
		return sum;
	}

	public static int leastTrivial(int l, int h) {
		double score = Double.MAX_VALUE;
		int x_min = -1;
		for (int x = l; x <= h; x++) {
			double s = sumFactors(x) * 1.0 / x;
			if (s < score) {
				score = s;
				x_min = x;
			}
		}
		return x_min;
	}

	public static void old_main(String[] args) {
		Init();
		Scanner in = new Scanner(System.in);
		int l = in.nextInt(), h = in.nextInt();
		if (l == 1) System.out.println("1");
		else if (l == h) System.out.println(l);
		else System.out.println(leastTrivial(l, h));
		in.close();
	}

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int I = in.nextInt();
		int J = in.nextInt();

		if (I == 1) {
			System.out.println(1);
			return;
		}
		if (I == J) {
			System.out.println(I);
			return;
		}
		int min = 10000;
		int mineded = 0;

		for (int i = J; i >= I; i--) {

			for (int j = i / 2; j >= 1; j--) {

				if (i % j == 0) {
					if (j < min) {
						min = j;
						mineded = i;
						if (j == 1) {
							System.out.println(i);
							return;
						}
					}

					break;
				}
			}
		}
		System.out.println(mineded);
		in.close();

	}

}
