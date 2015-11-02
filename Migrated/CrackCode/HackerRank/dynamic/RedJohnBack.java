package dynamic;

import java.util.Scanner;

public class RedJohnBack {

	public static int Jane(int N) {
		return solve(0, N);
	}

	private static int solve(int cnt, int N) {
		if (cnt > N) return 0;
		if (cnt == N) return 1;
		return solve(cnt + 1, N) + solve(cnt + 4, N);
	}

	private static int[] p;

	public static void Primes() {
		p = new int[217300];
		int sum = 0;
		for (int i = 2; i < p.length; i++) {
			if (p[i] == 0) {
				sum++;
				for (int j = i; j < p.length; j += i)
					p[j] = -1;
			}
			p[i] = sum;
		}
	}

	public static int Primes(int limit) {
		return p[limit];
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Primes();
		int T = I(in.nextLine().trim());
		while (T-- > 0) {
			int N = I(in.nextLine().trim());
			System.out.println(Primes(Jane(N)));
		}
		in.close();
	}

}
