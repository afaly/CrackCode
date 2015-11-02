package codeforces;

import java.util.Scanner;

public class RandomTeams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long m = in.nextLong();
		long max = (n - m + 1) * (n - m) / 2;
		long d = n / m;
		long k = d * (d - 1) / 2;
		long min = m * k + ((n - (d * m)) * d);
		System.out.println(min + " " + max);
		in.close();
	}
}
