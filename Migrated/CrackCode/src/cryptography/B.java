package cryptography;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] c = in.nextLine().trim().toCharArray();
		int len = c.length;
		char[] p = new char[len];
		int n = Integer.parseInt(in.nextLine().trim());
		for (int i = 0; i < len; i++) {
			p[(i * n) % len] = c[i];
		}
		System.out.println(new String(p));
		in.close();
	}

}
