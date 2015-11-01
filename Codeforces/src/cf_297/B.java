package cf_297;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] c = in.nextLine().toCharArray();

		int N = Integer.parseInt(in.nextLine()), M = c.length;
		String[] s = in.nextLine().split("\\s+");
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(s[i]) - 1;

		Arrays.sort(a);
		int k = 0;
		boolean invert = true;
		for (int i = 0, j = 1; i < M / 2; i++) {
			if (i < a[k]) continue;
			else if (j == N || (i >= a[k] && i < a[j])) {
				if (invert) {
					char t = c[i];
					c[i] = c[M - (i + 1)];
					c[M - (i + 1)] = t;
				}
			} else {
				k = j++;
				invert ^= true;
				i--;
			}
		}
		System.out.println(new String(c));
		in.close();
	}
}
