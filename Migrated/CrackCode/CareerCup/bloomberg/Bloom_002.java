package bloomberg;

import java.util.Arrays;

public class Bloom_002 {

	public static int[] uniqueShuffle(int[] n) {
		int i = 0;
		for (int k = 1; k < n.length;) {
			while (k < n.length && n[k] == n[i])
				k++;
			if (k < n.length) n[++i] = n[k];
		}
		return n;
	}

	public static void main(String[] args) {
		int[] n = { 0, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6,
				7, 7, 8, 9, 10 };
		System.out.println(Arrays.toString(uniqueShuffle(n)));
	}
}
