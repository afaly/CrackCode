package codeforces;

import java.util.Scanner;

public class DreamoonStairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int min = (n >> 1) + (n % 2);
		int k = min % m;
		if ((k > 0 && m - k > min) || m > n) System.out.println("-1");
		else if (k == 0) System.out.println(min);
		else System.out.println(min + (m - k));
		in.close();
	}

}
