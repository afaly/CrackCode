package cf_296;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().split(" ");
		int W = Integer.parseInt(ss[0]);
		int H = Integer.parseInt(ss[1]);
		int N = Integer.parseInt(ss[2]);
		int p = -1;

		int wi = 0, wj = 0;
		int[] w = new int[W];
		int[] h = new int[H];

		while (N-- > 0) {
			ss = in.nextLine().split(" ");
			p = Integer.parseInt(ss[1]);
			if (ss[0].equals("V")) {
				wi++;
				int m = w[p];
				for (int j = p; j < W && w[j] == m; j++)
					w[j] = wi;
			} else {
				wj++;
				int m = h[p];
				for (int j = p; j < H && h[j] == m; j++)
					h[j] = wj;
			}

			System.out.println(Arrays.toString(w));
			System.out.println(Arrays.toString(h));
		}

		// System.out.println(Arrays.toString(w));
		// System.out.println(Arrays.toString(h));

		in.close();
	}

}
