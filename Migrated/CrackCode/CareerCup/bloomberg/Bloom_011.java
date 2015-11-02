package bloomberg;

public class Bloom_011 {

	public static int findMissing(int[] n, int N) {
		int xor = N;
		for (int i = 0; i < N; xor ^= i, i++)
			xor ^= n[i];
		return xor;
	}

	public static void main(String[] args) {
		System.out.println(findMissing(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 9 },
				9));
	}

}
