package euler;

import java.util.Scanner;

public class Euler_042 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			long v = in.nextLong();
			long sqrv = 8 * v + 1;
			long sqrtv = Math.round(Math.sqrt(sqrv));
			if (sqrtv * sqrtv == sqrv) {
				System.out.println((sqrtv - 1) / 2);
			} else {
				System.out.println("-1");
			}
		}
		in.close();
	}
}
