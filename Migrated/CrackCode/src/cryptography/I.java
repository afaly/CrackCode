package cryptography;

import java.util.Scanner;

public class I {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String c = in.nextLine().trim();
		char[] p = new char[c.length() / 8];
		for (int i = 0, j = 8, k = 0; j <= c.length(); i += 8, j += 8, k++) {
			p[k] = (char) Integer.parseInt(c.substring(i, j), 2);
		}
		System.out.println(new String(p));
		in.close();
	}
}
