package timus;

import java.util.Scanner;

public class T_1104_DontAskWomanAboutHerAge {

	private static short toNum(char c) {
		if (Character.isDigit(c)) return (short) (c - '0');
		else return (short) ((c - 'A') + 10);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		short[] v = new short[s.length];
		short base = 2;
		for (int i = 0; i < s.length; i++) {
			v[i] = toNum(s[i]);
			if (v[i] >= base) base = (short) (v[i] + 1);
		}
		boolean found = false;
		for (short b = base; b <= 36 && !found; b++) {
			long val = 0;
			for (int i = 0; i < v.length; i++) {
				val += v[i];
			}
			if (val % (b - 1) == 0) {
				System.out.println(b);
				found = true;
			}
		}
		if (!found) System.out.println("No solution.");
		in.close();
	}

}
