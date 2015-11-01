package cf_304;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class D {

	public static final int nbits = 2500;
	public static BitSet p = new BitSet(nbits);
	public static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void sieve() {
		p.set(0);
		p.set(1);
		for (int i = 2; i < nbits; i++) {
			if (!p.get(i)) {
				primes.add(i);
				for (int j = i; j < nbits; j += i)
					p.set(j);
			}
		}
	}

	public static final int size = 6000001;
	public static int[] dp = new int[size];
	public static int[] vv = new int[size];

	public static void fill() {
		for (int i = 2; i < size; i++) {
			if (dp[i] == 0) {
				vv[i] = 1;
				for (int j = i; j < size; j += i) {
					dp[j]++;
					int k = j / i;
					if (k > 1 && k % i == 0) {
						dp[j] += vv[k];
						vv[j] = vv[k] + 1;
					}
				}
			}
		}
	}

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		fill();
		// System.out.println("DONE");
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		for (int t = 0; t < T; t++) {
			String[] s = in.nextLine().split("\\s+");
			int a = I(s[0]), b = I(s[1]);
			long cnt = 0;
			for (int i = a; i > b; i--) {
				System.out.println(" >  " + i + " , " + dp[i]);
				cnt += dp[i];
			}
			System.out.println(cnt);
		}
		in.close();
	}
}
