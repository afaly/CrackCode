package dynamic;

import java.util.Scanner;

/*-
 * UVA 10003 Cutting Sticks
 * 
 You have to cut a wood stick into pieces. The most affordable company, The Analog Cutting Machinery,
 Inc. (ACM), charges money according to the length of the stick being cut. Their procedure of work
 requires that they only make one cut at a time.
 It is easy to notice that different selections in the order of cutting can led to different prices.
 For example, consider a stick of length 10 meters that has to be cut at 2, 4 and 7 meters from one
 end. There are several choices. One can be cutting first at 2, then at 4, then at 7. This leads to a
 price of 10 + 8 + 6 = 24 because the first stick was of 10 meters, the resulting of 8 and the last
 one of 6. Another choice could be cutting at 4, then at 2, then at 7. This would lead to a price of
 10 + 4 + 6 = 20, which is a better price.

 Your boss trusts your computer abilities to find out the minimum cost for cutting a given stick.

 INPUT:
 ------
 100
 3
 25 50 75
 10
 4
 4 5 7 8
 0
 */

public class CuttingSticks {

	private static int[] cut;
	private static int[][] mem;

	public static int Cut(int[] Cuts, int length) {
		cut = Cuts;
		mem = new int[Cuts.length][Cuts.length + 1];
		return Cut(0, length, 0, Cuts.length);
	}

	private static int Cut(int s, int e, int i, int j) {
		if (i == j) return 0;
		if (mem[i][j] > 0) return mem[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			min = Math.min(min, Cut(s, cut[k], i, k) + Cut(cut[k], e, k + 1, j)
					+ (e - s));
		}
		mem[i][j] = min;
		return min;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = Integer.parseInt(in.nextLine());
		while (len != 0) {
			int n = Integer.parseInt(in.nextLine());
			String[] ss = in.nextLine().split(" ");
			int[] c = new int[n];
			for (int i = 0; i < n; i++)
				c[i] = Integer.parseInt(ss[i]);
			System.out.printf("The minimum cutting is %d.\n", Cut(c, len));
			len = Integer.parseInt(in.nextLine());
		}
		in.close();
	}

}
