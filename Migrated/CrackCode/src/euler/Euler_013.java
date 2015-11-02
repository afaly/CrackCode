package euler;

import java.math.BigInteger;
import java.util.Scanner;

public class Euler_013 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		BigInteger sum = BigInteger.valueOf(0l);
		while (N-- > 0)
			sum = sum.add(in.nextBigInteger());
		System.out.println(sum.toString().substring(0, 10));
		in.close();
	}

}
