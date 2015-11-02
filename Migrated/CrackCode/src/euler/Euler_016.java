package euler;

import java.math.BigInteger;
import java.util.Scanner;

public class Euler_016 {

	public static long sum(char[] n) {
		long sum = 0l;
		for (int i = 0; i < n.length; i++)
			sum += n[i] - '0';
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), v;
		while (T-- > 0) {
			v = in.nextInt();
			System.out.println(sum(BigInteger.valueOf(2l).pow(v).toString()
					.toCharArray()));
		}
		in.close();
	}
}
