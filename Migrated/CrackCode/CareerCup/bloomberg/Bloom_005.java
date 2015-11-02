package bloomberg;

import java.util.Arrays;

public class Bloom_005 {

	private static int[] hist;
	private static int N, M;

	public static int[] Dice(int n, int m) {
		N = n;
		M = m;
		hist = new int[((N * M) + 1) - N];
		dice(0, 0);
		return hist;
	}

	private static void dice(int sum, int idx) {
		if (idx == N) hist[sum - N]++;
		else
			for (int i = 1; i <= M; i++)
				dice(sum + i, idx + 1);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(Dice(5, 10)));
	}

}
