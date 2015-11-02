package cryptography;

import java.util.Scanner;

public class Q {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] c = in.nextLine().trim().toCharArray();
		char[] a = "bcdefghijklmnopqrstuvwxyza".toCharArray();
		char[] d = new char[c.length];

		for (int i = 0; i < c.length; i++) {
			d[i] = a[(c[i] - 'a')];
		}
		System.out.println(new String(d));
		in.close();
	}

}
