package hackerRank;

import java.util.Scanner;

/**
 * 
 * @author enzo
 * 
 *         These are elementary symmetric polynomials. You can write them using
 *         summation signs as in Wikipedia. You can also use Vieta's formulas to
 *         get all of them at once as coefficients of a polynomial (up to signs)
 * 
 *         LINKS: [1]
 *         http://stackoverflow.com/questions/10106193/sum-of-product-of-subsets
 *         [2]
 *         http://stackoverflow.com/questions/9280936/efficient-algorithm-to-
 *         calculate-the-sum-of-all-k-products
 * 
 * 
 * 
 *         James is very naive in Mathematics, He always makes new things out of
 *         a given list of integers. Today he is given a list L, so he creates a
 *         value S out of it.
 * 
 *         S from a given list can be calculated as follows.
 * 
 *         value_of_S(list L) { while ((number of elements in L) > 1) { a = L[0]
 *         b = L[1] delete L[1] L[0] = a+b+ab } return L[0] % 1000000007 } James
 *         has an ample amount of time, so he calculates the values of S for all
 *         the permutations of the given list L and finds their average value.
 *         Then he asks you to report that value.
 *
 */
public class TellAverage {

	public static long[] Solve(int[] a, int N) {
		long[] o = new long[N + 1], n;
		o[0] = 1;
		for (int d = 1; d <= N; ++d) {
			n = new long[N + 1];
			n[0] = (a[d - 1] * o[0]) % 1000000007;
			for (int i = 1; i <= d; ++i) {
				n[i] = (o[i - 1] + a[d - 1] * o[i]) % 1000000007;
			}
			o = n;
		}
		return o;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		int[] n = new int[N];
		String[] ss = in.nextLine().trim().split(" ");
		for (int i = 0; i < N; i++)
			n[i] = Integer.parseInt(ss[i]);
		long[] sol = Solve(n, N);
		long res = -1l;
		for (int i = 0; i < sol.length; i++) {
			res += sol[i];
			if (res > 1000000007) res %= 1000000007;
		}
		System.out.println(res);
		in.close();
	}

}
