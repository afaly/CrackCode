package codechef;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		char[] c;
		while (T-- > 0) {
			boolean[] f = new boolean[26];
			c = in.nextLine().toCharArray();
			for (int i = 0; i < c.length; i++) {
				f[c[i] - 'a'] = true;
			}
			int cnt = 0;
			for (int i = 0; i < 26; i++) {
				if (f[i]) cnt++;
			}
			System.out.println(cnt);
		}
		in.close();
	}

}
