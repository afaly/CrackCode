package dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_10036 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			N = in.nextInt();
			K = in.nextInt();
			v = new int[N];
			for (int i = 0; i < N; i++)
				v[i] = in.nextInt();
			System.out.println(Divisible() ? "Divisible" : "Not divisible");
		}
		in.close();
	}

	private static int[] v;
	private static int[][] dp;
	private static int N, K, M, MM;

	private static boolean Divisible() {
		M = (N / K) * K;
		MM = M << 1;
		dp = new int[N][MM];
		for (int[] n : dp)
			Arrays.fill(n, -1);
		return divisible(0, 0);
	}

	private static boolean divisible(int i, int a) {
		return i == N ? a % K == 0 : divisible(i + 1, a - v[i])
				|| divisible(i + 1, a + v[i]);
	}
}
