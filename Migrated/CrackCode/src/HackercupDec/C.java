package HackercupDec;

import java.math.BigInteger;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		BigInteger I = BigInteger.valueOf(2l);
		BigInteger exp = I.pow(a);
		BigInteger res = I.modPow(exp, BigInteger.valueOf(b));
		System.out.println(res);
		in.close();
	}

}
