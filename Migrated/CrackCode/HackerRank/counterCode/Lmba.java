package counterCode;

import java.util.Scanner;

public class Lmba {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt(), NN = (N >> 1) << 1;
			int i = NN / 2, j = N - NN / 2 + 1;
			StringBuilder sb = new StringBuilder();
			sb.append(N % 2 == 0 ? "" : (N + 1) / 2 + " ");
			for (int k = 0; k < NN / 2; k++)
				sb.append(i--).append(" ").append(j++).append(" ");
			System.out.println(sb.toString().trim());
		}

		in.close();
	}
}
