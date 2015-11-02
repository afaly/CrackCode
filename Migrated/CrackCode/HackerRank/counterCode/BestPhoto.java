package counterCode;

import java.math.BigInteger;
import java.util.Scanner;

public class BestPhoto {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine()), L = 1000001, cnt = 0;
		BigInteger b = BigInteger.valueOf(1);
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[L];
		for (int i = 0; i < N; i++)
			n[I(s[i])]++;

		for (int i = 0; i < L; i++) {
			if (n[i] > 0) cnt++;
			
		}
		in.close();
	}
}
