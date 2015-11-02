package math;

import java.util.Scanner;

public class Leibniz {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), i = 0, j = 0;
		int[] n = new int[N];
		for (; i < N; i++)
			n[i] = in.nextInt();
		double val = 0.0;
		for (i = 0; i < n[N - 1]; i++) {
			val += ((i & 1) == 0) ? 1.0 / ((2 * i) + 1) : -1.0 / ((2 * i) + 1);
			if (i + 1 == n[j]){
				System.out.println(val);
				j++;
			}
		}
		in.close();
	}
}
