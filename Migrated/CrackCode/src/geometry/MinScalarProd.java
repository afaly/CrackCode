package geometry;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MinScalarProd {

	public static BigInteger minScalarProd(long[] v1, long[] v2) {
		Arrays.sort(v1);
		Arrays.sort(v2);
		int len = v1.length, i = 0, j = len - 1;
		BigInteger val = BigInteger.valueOf(0l);
		for (; i < len; i++, j--) {
			BigInteger evl = BigInteger.valueOf(v1[i] * v2[j]);
			val = val.add(evl);
		}
		return val;
	}

	public static long[] parseArray(int N, String[] ss) {
		long[] vals = new long[N];
		for (int i = 0; i < N; i++) {
			vals[i] = Long.parseLong(ss[i]);
		}
		return vals;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine()), t = 0;
		while (t < T) {
			int N = Integer.parseInt(in.nextLine());
			long[] v1 = parseArray(N, in.nextLine().split(" ")), v2 = parseArray(
					N, in.nextLine().split(" "));
			System.out.printf("Case #%d: %s\n", ++t, minScalarProd(v1, v2)
					.toString());
		}
		in.close();
	}

}
