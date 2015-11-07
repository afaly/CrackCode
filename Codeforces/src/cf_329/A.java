package cf_329;

import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		int[][] freq = new int[26][26];
		char f = '.', s = '.';
		int max = 0;
		for (int i = 0; i < N; i++) {
			char[] c = in.nextLine().trim().toCharArray();
			Character a = null, b = null;
			boolean valid = true;
			for (int j = 0; j < c.length && valid; j++) {
				if (a == null || a == c[j]) a = c[j];
				else if (b == null || b == c[j]) b = c[j];
				else valid = false;
			}

			if (valid) {
				if (a != null) {
					if (b != null) {
						freq[a - 'a'][b - 'a'] += c.length;
						freq[b - 'a'][a - 'a'] += c.length;
					} else {
						for (int j = 0; j < 26; j++) {
							freq[a - 'a'][j] += c.length;
							freq[j][a - 'a'] += c.length;
						}
					}
				}
			}

			for (int x = 0; x < 26; x++) {
				for (int y = x + 1; y < 26; y++) {
					if (freq[x][y] > max) {
						max = freq[x][y];
						f = (char) (x + 'a');
						s = (char) (y + 'a');
					}
				}
			}
		}
		System.out.println(f + " , " + s);
		System.out.println(max);
		in.close();
	}
}
