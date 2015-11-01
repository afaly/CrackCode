package rocketFuel;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static int N, M;

	public static void Gen(int n, int m) {
		N = n;
		M = m;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < n;)
			x[i] = ++i;
		System.out.println(Arrays.toString(x));
		in.close();
	}
}
