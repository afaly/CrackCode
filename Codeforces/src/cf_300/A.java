package cf_300;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] c = in.nextLine().toCharArray();
		char[] v = "CODEFORCES".toCharArray();
		if (c.length < 10
				|| (c[0] != v[0] && c[c.length - 1] != v[v.length - 1])) {
			System.out.println("NO");
		} else {
			int i, j;
			for (i = 0; i < v.length; i++)
				if (c[i] != v[i]) break;
			for (j = 0; j < v.length; j++)
				if (c[(c.length - 1) - j] != v[(v.length - 1) - j]) break;
			if (i >= 10 || j >= 10 || (j + i) >= 10) System.out.println("YES");
			else
				System.out.println("NO");
		}
		in.close();
	}
}
