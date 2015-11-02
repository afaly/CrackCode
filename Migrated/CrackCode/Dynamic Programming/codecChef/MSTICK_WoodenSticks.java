package codecChef;

import java.util.Scanner;

public class MSTICK_WoodenSticks {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		while (N-- > 0) {
			int M = Integer.parseInt(in.nextLine());
			String[] s = in.nextLine().split("\\s+");
			int[] l = new int[M], w = new int[M];
			for (int i = 0, j = 0; i < M; i++) {
				l[i] = Integer.parseInt(s[j++]);
				w[i] = Integer.parseInt(s[j++]);
			}
		}

		in.close();
	}
}
