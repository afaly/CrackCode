package microsoft;

import java.util.Arrays;

public class Micro_001 {

	private static int OO = Integer.MAX_VALUE;

	public static int[][] longestSubarray(int[] n) {
		int N = n.length, x = -1, y = -1, size = -1;
		boolean digMore = true;
		for (int sz = 1; sz <= N / 2 && digMore; sz++) {
			int[] maxs = new int[N - sz];
			int[] mins = new int[N - sz];
			Arrays.fill(maxs, OO);
			Arrays.fill(mins, -OO);
			for (int i = 1, j = sz; i < N - sz && j <= N; i++, j++) {
				int max = -OO, min = OO;
				for (int k = i; k < j; k++) {
					if (n[k] > max) max = n[k];
					if (n[k] < min) min = n[k];
				}
				maxs[i] = max;
				mins[i] = min;
			}
			int min_maxs = OO, max_mins = -OO, imins = -1, imaxs = -1;;
			for (int i = 0; i < N - sz; i++) {
				if (maxs[i] < min_maxs) {
					min_maxs = maxs[i];
					imaxs = i;
				}
				if (mins[i] > max_mins) {
					max_mins = mins[i];
					imins = i;
				}
			}

			if (imins >= 0 && imaxs >= 0 && imins != imaxs) {
				x = imins;
				y = imaxs;
				size = sz;
				System.out.println("ITR : " + x + " , " + y + " , " + size);
			} else
				digMore = false;
		}
		System.out.println("ANS : " + x + " , " + y + " , " + size);
		return null;
	}

	public static void main(String[] args) {
		longestSubarray(new int[] { 1, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		// longestSubarray(new int[] { 1, 2, 3, 4, 5, 6 });
	}

}
