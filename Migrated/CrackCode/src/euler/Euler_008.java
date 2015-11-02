package euler;

import java.util.Scanner;

public class Euler_008 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine().trim());
		String[] ss;
		while (T-- > 0) {
			ss = in.nextLine().split("\\W+");
			int N = Integer.parseInt(ss[0]);
			int K = Integer.parseInt(ss[1]);
			char[] c = in.nextLine().trim().toCharArray();
			int max = 1;
			for (int i = 0; i < K; i++)
				max *= c[i] - '0';
			int val = max;
			for (int i = K; i < N; i++) {
				if (c[i - K] == '0') {
					val = 1;
					for (int j = 1; j < K; j++)
						val *= c[i - j] - '0';
				} else val /= c[i - K] - '0';
				val *= c[i] - '0';
				if (val > max) max = val;
			}
			System.out.println(max);
		}

		in.close();
	}

}
