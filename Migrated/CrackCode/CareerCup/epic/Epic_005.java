package epic;

import java.util.Arrays;
import java.util.HashSet;

public class Epic_005 {

	public static boolean[] flag;
	public static HashSet<Integer> primes;
	public static int size = 0;

	public static void sieve(int N) {
		if (N <= size) return;
		if (size == 0) {
			flag = new boolean[N];
			flag[0] = true;
			flag[1] = true;
			primes = new HashSet<Integer>();
		} else {
			flag = Arrays.copyOf(flag, N);
			for (int p : primes) {
				for (int j = (size / p) * p; j < N; j += p)
					flag[j] = true;
			}
		}
		size = N;
		for (int i = 2; i < N; i++) {
			if (!flag[i]) {
				primes.add(i);
				for (int j = i; j < N; j += i)
					flag[j] = true;
			}
		}
	}

	public static int[] decompose(int N) {
		if ((N & 1) == 0 && N > 2) {
			sieve(N);
			System.out.println(primes.size());
			for (int p : primes) {
				if (primes.contains(N - p)) {
					return new int[] { p, N - p };
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(decompose(10022)));
		System.out.println(Arrays.toString(decompose(100022)));
		System.out.println(Arrays.toString(decompose(1000022)));
		System.out.println(Arrays.toString(decompose(10)));
	}

}
