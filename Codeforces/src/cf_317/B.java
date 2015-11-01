package cf_317;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] A(Scanner in) {
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[s.length];
		for (int i = 0; i < n.length; i++)
			n[i] = I(s[i]);
		return n;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = I(in.nextLine());
		while (T-- > 0) {
			int[] d = A(in), n = A(in), m = A(in);
			Arrays.sort(n);
			Arrays.sort(m);
			int cx = 1, cy = 1, i = d[0] - 1, j = d[1] - 1, cst = 0;
			while (i >= 0 && j >= 0) {
				if (n[i] * cy >= m[j] * cx) {
					cst += n[i] * cy;
					cx++;
					i--;
				} else {
					cst += m[j] * cx;
					cy++;
					j--;
				}
			}
			while (i >= 0)
				cst += n[i--] * cy;
			while (j >= 0)
				cst += m[j--] * cx;
			System.out.println(cst);
		}
		in.close();
	}
}