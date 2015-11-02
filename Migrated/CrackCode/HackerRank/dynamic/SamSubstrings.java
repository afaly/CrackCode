package dynamic;

import java.util.Scanner;

public class SamSubstrings {

	public static long sumSubstrings(int[] n) {
		long M = 1000000007, sum = 0, val = 10;
		long[] v = new long[n.length];
		v[0] = 1;
		for (int i = 1; i < n.length; i++, val = ((val) * 10) % M)
			v[i] = v[i - 1] + val;
		for (int i = 0; i < n.length; i++) {
			if (n[i] > 0) {
				sum = (sum + ((((i + 1) * n[i]) % M) * v[(n.length - 1) - i])
						% M)
						% M;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] c = in.nextLine().toCharArray();
		int[] n = new int[c.length];
		for (int i = 0; i < c.length; i++)
			n[i] = c[i] - '0';
		System.out.println(sumSubstrings(n));
		in.close();
	}

}
