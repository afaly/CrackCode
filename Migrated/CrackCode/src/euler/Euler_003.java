package euler;

import java.util.Scanner;

public class Euler_003 {

	public static boolean isPrime(long n) {
		if (n <= 3) {
			return n > 1;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		} else {
			for (int i = 5; i * i <= n; i += 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long v;
		int r;
		while (T-- > 0) {
			v = in.nextLong();
			r = (int) Math.sqrt(v);
			if (isPrime(v)) System.out.println(v);
			else {
				for (int i = 2; i <= r; i++) {
					if (v % i == 0) {
						if (isPrime(v / i)) {
							System.out.println(v / i);
							break;
						} else {
							
						}
					}
				}
			}
		}

		in.close();
	}
}
