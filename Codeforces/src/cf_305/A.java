package cf_305;

import java.util.Scanner;

public class A {

	public static boolean isPalindrom(char[] c, int i, int j) {
		for (int k = 0; k <= (j - i) / 2; k++)
			if (c[i + k] != c[j - k]) return false;
		return true;
	}

	public static boolean isBackPack(String s, int k) {
		char[] c = s.toCharArray();
		int i = 0, cnt = 0;
		for (int j = i + 1; j < c.length; j++) {
			if (c[j] == c[i] && isPalindrom(c, i, j)) {
				cnt++;
				i = ++j;
			}
		}
		return cnt == k || k == c.length;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int k = Integer.parseInt(in.nextLine());
		System.out.println(isBackPack(s, k) ? "YES" : "NO");
		in.close();
	}
}
