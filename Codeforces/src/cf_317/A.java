package cf_317;

import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int[] S(Scanner in) {
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[s.length];
		for (int i = 0; i < s.length; i++)
			n[i] = I(s[i]);
		return n;
	}

	public static int Ceil(int[] n, int l, int h, int key) {
		if (h < l) return h + 1;
		int m = (h + l) / 2;
		if (n[m] < key) return Ceil(n, m + 1, h, key);
		else if (n[m] > key) return Ceil(n, l, m - 1, key);
		else {
			int i = 0;
			while ((m - i) - 1 >= 0 && n[(m - i) - 1] == n[m])
				i++;
			return m - i;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] n = S(in), na, nb;
		int Nb = n[1], k, m;
		n = S(in);
		k = n[0];
		m = n[1];
		na = S(in);
		nb = S(in);
		int bkey = Ceil(nb, 0, Nb - 1, na[k - 1] + 1);
		System.out.println((Nb - bkey) >= m ? "YES" : "NO");
		in.close();
	}

}
