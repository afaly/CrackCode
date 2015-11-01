package medium;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MayanCalculations {
	private static String[][] num;
	private static BigInteger T = BigInteger.valueOf(20l);

	public static void print(BigInteger val) {
		if (val.compareTo(T) >= 0) print(val.divide(T));
		String[] c = num[(val.mod(T)).intValue()];
		for (String x : c)
			System.out.println(x);
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int H = in.nextInt();
		num = new String[20][H];
		StringBuilder[] sb = new StringBuilder[20];
		for (int i = 0; i < 20; i++)
			sb[i] = new StringBuilder();
		for (int i = 0; i < H; i++) {
			String numeral = in.next();
			for (int k = 0, j = 0; k < 20 * L && j < 20; k += L, j++) {
				String s = numeral.substring(k, k + L);
				sb[j].append(s);
				num[j][i] = s;
			}
		}

		Map<String, Integer> map = new HashMap<String, Integer>(20);
		for (int i = 0; i < 20; i++)
			map.put(sb[i].toString(), i);

		int S1 = in.nextInt();
		BigInteger v1 = BigInteger.valueOf(0l);
		for (long i = (S1 / L) - 1, p = (long) Math.pow(20, i); i >= 0; i--, p /= 20) {
			StringBuilder sbb = new StringBuilder();
			for (int j = 0; j < L; j++)
				sbb.append(in.next());
			v1 = v1.add(BigInteger.valueOf(map.get(sbb.toString()) * p));
		}
		int S2 = in.nextInt();
		BigInteger v2 = BigInteger.valueOf(0l);
		for (long i = (S2 / L) - 1, p = (long) Math.pow(20, i); i >= 0; i--, p /= 20) {
			StringBuilder sbb = new StringBuilder();
			for (int j = 0; j < L; j++)
				sbb.append(in.next());
			v2 = v2.add(BigInteger.valueOf(map.get(sbb.toString()) * p));
		}
		char op = in.next().charAt(0);

		if (op == '+') print(v1.add(v2));
		else if (op == '-') print(v1.subtract(v2));
		else if (op == '*') print(v1.multiply(v2));
		else print(v1.divide(v2));

		in.close();
	}
}
