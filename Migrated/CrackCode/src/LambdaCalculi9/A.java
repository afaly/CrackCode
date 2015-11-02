package LambdaCalculi9;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] c = in.nextLine().toCharArray();
		boolean[] f = new boolean[26];
		for (int i = 0; i < c.length; i++) {
			if (!f[c[i] - 'a']) {
				f[c[i] - 'a'] = true;
				sb.append(c[i]);
			}
		}
		System.out.println(sb.toString());
		in.close();
	}
}
