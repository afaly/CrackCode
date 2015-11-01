package cf_288;

import java.util.Scanner;

public class B {

	private static char[] c;
	private static int len, l;

	public static int toInt(char c) {
		return (int) c - '0';
	}

	public static boolean solve(int i) {
		if (i >= 0 && i < len) {
			int x = toInt(c[i]);
			if ((x & 1) == 0) {
				if (x < l) {
					char p = c[i];
					c[i] = c[c.length - 1];
					c[c.length - 1] = p;
					return true;
				} else {
					if (!solve(i + 1)) {
						char p = c[i];
						c[i] = c[c.length - 1];
						c[c.length - 1] = p;
					}
					return true;
				}
			} else
				return solve(i + 1);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		c = in.nextLine().toCharArray();
		len = c.length;
		// SWAP SMALL
		l = toInt(c[c.length - 1]);
		boolean solved = solve(0);
		if (solved)
			System.out.println(new String(c));
		else
			System.out.println("-1");
		
		
		int t;
		boolean found = false;
		for (int i = 0; i < c.length - 1 && !found; i++) {
			t = toInt(c[i]);
			if ((t & 1) == 0 && t < l) {
				char p = c[i];
				c[i] = c[c.length - 1];
				c[c.length - 1] = p;
				found = true;
			}
		}
		if (found) {
			System.out.println(new String(c));
		} else {
			for (int i = c.length - 2; i >= 0 && !found; i--) {
				t = toInt(c[i]);
				if ((t & 1) == 0) {
					char p = c[i];
					c[i] = c[c.length - 1];
					c[c.length - 1] = p;
					found = true;
				}
			}
			if (found) {
				System.out.println(new String(c));
			} else {
				System.out.println("-1");
			}

		}

		in.close();
	}
}
