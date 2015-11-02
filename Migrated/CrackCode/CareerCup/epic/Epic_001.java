package epic;

import java.util.HashSet;
import java.util.Scanner;

public class Epic_001 {

	public static int[] primes = { 2, 3, 5, 7 };

	public static boolean check(int val, int[] v) {
		int[] x = new int[10];
		while (val > 0) {
			x[val % 10]++;
			val /= 10;
		}
		for (int i = 2; i < 10; i++)
			if (x[i] != v[i]) return false;
		return true;
	}

	public static HashSet<Integer> set;

	public static HashSet<Integer> Solve(int N) {
		set = new HashSet<Integer>();
		solve(N, new int[10]);
		return set;
	}

	public static int number(int N) {
		int cnt = 0;
		while (N > 0) {
			N /= 10;
			cnt++;
		}
		return cnt;
	}

	public static int number(int[] N) {
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			cnt += N[i];
		}
		return cnt;
	}

	private static void solve(int val, int[] v) {
		if (number(val) < number(v)) return;
		if (check(val, v)) set.add(val);
		for (int i = 2; i < 10; i++) {
			if (val % i == 0) {
				v[i]++;
				solve(val / i, v);
				v[i]--;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		System.out.println(Solve(N));
		in.close();
	}
}
