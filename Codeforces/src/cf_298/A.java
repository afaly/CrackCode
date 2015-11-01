package cf_298;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int[] v;
		if (N == 2 || N == 1) {
			v = new int[] { 1 };
		} else if (N == 3) {
			v = new int[] { 1, 3 };
		} else if (N == 4) {
			v = new int[] { 3, 1, 4, 2 };
		} else {
			v = new int[N];
			for (int i = 1, k = 0; i <= (N + 1) / 2; i++, k += 2)
				v[k] = i;
			for (int i = (N + 1) / 2 + 1, k = 1; i <= N; i++, k += 2)
				v[k] = i;
		}
		System.out.println(v.length);
		System.out.print(v[0]);
		for (int i = 1; i < v.length; i++)
			System.out.print(" " + v[i]);
		in.close();
	}
}
