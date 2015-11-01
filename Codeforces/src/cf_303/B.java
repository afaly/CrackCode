package cf_303;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		char[] t = in.nextLine().toCharArray();
		int N = s.length;
		char[] r = new char[N];
		int n = 0, m = 0;
		for (int i = 0; i < N; i++) {
			if (s[i] != t[i]) {
				if (n > m) {
					r[i] = s[i];
					m++;
				} else {
					r[i] = t[i];
					n++;
				}
			} else
				r[i] = t[i];
		}
		if (n == m) System.out.println(new String(r));
		else
			System.out.println("impossible");
		System.out.println();
		in.close();

	}

}
