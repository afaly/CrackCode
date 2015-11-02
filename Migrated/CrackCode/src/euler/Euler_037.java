package euler;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Euler_037 {

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
		int N = in.nextInt();
		ArrayList<Integer> p = Sieve.sieve_of_eratosthenes(N - 1);
		HashSet<Integer> s = new HashSet<Integer>(p);
		s.add(0);
		long ans = -17l;
		for (Integer n : p) {
			boolean valid = true;
			int t = n;
			while (t > 0 && valid) {
				if (!s.contains(t / 10)) valid = false;
				t /= 10;
			}
			t = n;
			while (t > 0 && valid) {
				 
			}
			if (valid) ans += n;
		}
		System.out.println(ans);
		in.close();
	}

}
