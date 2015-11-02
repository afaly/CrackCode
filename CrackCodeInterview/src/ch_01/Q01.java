package ch_01;

import java.util.Scanner;

public class Q01 {

	public static boolean isUnique(String s) {
		if (s.length() > 26) return false;
		boolean[] vis = new boolean[26];
		s = s.toLowerCase();
		for (int i = 0, j = s.charAt(0) - 'a'; i < s.length(); i++, j = s
				.charAt(i >= s.length() ? 0 : i) - 'a')
			if (vis[j]) return false;
			else
				vis[j] = true;
		return true;
	}

	public static boolean isUniqueOPT(String s) {
		if (s.length() > 26) return false;
		s = s.toLowerCase();
		for (int c = 0; c < 26; c++) {
			boolean found = false;
			for (int i = 0, j = s.charAt(0) - 'a'; i < s.length(); i++, j = s
					.charAt(i >= s.length() ? 0 : i) - 'a') {
				if (c == j) {
					if (found) return false;
					else
						found = true;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(isUnique(s));
		in.close();
	}

}
