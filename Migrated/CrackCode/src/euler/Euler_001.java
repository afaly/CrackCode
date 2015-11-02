package euler;

import java.util.Scanner;

public class Euler_001 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long v, v3, v5, v15, sum;
		while (T-- > 0) {
			v = in.nextLong();
			sum = 0l;
			v3 = ((v - 1) / 3) + 1;
			v5 = ((v - 1) / 5) + 1;
			v15 = ((v - 1) / 15) + 1;
			sum += (v3 * (v3 - 1) * 3) / 2;
			sum += (v5 * (v5 - 1) * 5) / 2;
			sum -= (v15 * (v15 - 1) * 15) / 2;
			System.out.println(sum);
		}

		in.close();
	}
}
