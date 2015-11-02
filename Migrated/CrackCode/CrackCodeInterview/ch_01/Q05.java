package ch_01;

import java.util.Scanner;

public class Q05 {

	public static String compress(String s) {
		char[] c = s.toCharArray();
		char p = c[0];
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length;) {
			cnt = 0;
			while (i < c.length && c[i] == p) {
				cnt++;
				i++;
			}
			sb.append(p).append(cnt);
			if (i < c.length) p = c[i];
		}
		return sb.length() >= s.length() ? s : sb.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(compress(in.nextLine()));
		in.close();
	}

}
