package euler;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Scanner;

public class Euler_010 {

	static class Sieve {
		private BitSet sieve;

		private Sieve() {}

		private Sieve(int size) {
			sieve = new BitSet((size + 1) / 2);
		}

		private boolean is_composite(int k) {
			assert k >= 3 && (k % 2) == 1;
			return sieve.get((k - 3) / 2);
		}

		private void set_composite(int k) {
			assert k >= 3 && (k % 2) == 1;
			sieve.set((k - 3) / 2);
		}

		public static ArrayList<Integer> sieve_of_eratosthenes(int max) {
			Sieve sieve = new Sieve(max + 1); // +1 to include max itself
			for (int i = 3; i * i <= max; i += 2) {
				if (sieve.is_composite(i)) continue;

				// We increment by 2*i to skip even multiples of i
				for (int multiple_i = i * i; multiple_i <= max; multiple_i += 2 * i)
					sieve.set_composite(multiple_i);

			}
			ArrayList<Integer> primes = new ArrayList<Integer>();
			primes.add(2);
			for (int i = 3; i <= max; i += 2)
				if (!sieve.is_composite(i)) primes.add(i);

			return primes;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> primes = Sieve.sieve_of_eratosthenes(1000000);
		int T = in.nextInt(), v;
		long sum = 0l;
		long[] s = new long[primes.size()];
		int idx = 0;
		for (int prime : primes) {
			sum += prime;
			s[idx++] = sum;
		}
		// System.out.println(primes);
		// System.out.println(Arrays.toString(s));
		while (T-- > 0) {
			v = in.nextInt();
			int pos = Collections.binarySearch(primes, v);
			if (pos >= 0) System.out.println(s[pos]);
			else System.out.println(s[-pos - 2]);
		}

		in.close();
	}
}
