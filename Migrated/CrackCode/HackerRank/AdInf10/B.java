package AdInf10;

import java.math.BigDecimal;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		double r5 = Math.sqrt(5);
		BigDecimal x1 = BigDecimal.valueOf((1 / r5) * ((1 + r5) / 2));
		BigDecimal x2 = BigDecimal.valueOf((1 / r5) * ((1 - r5) / 2));
		while (T-- > 0) {
			String[] s = in.nextLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int N = Integer.parseInt(s[2]);
			int [] a = new int[10];
		}

		in.close();
	}

}
