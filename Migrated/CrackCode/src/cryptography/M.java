package cryptography;

import java.util.Scanner;

public class M {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int len = Integer.parseInt(in.nextLine());
		String[] ss = in.nextLine().split(" ");
		char[] p = new char[len];
		for (int i = 0; i < len; i++) {
			int val = Integer.parseInt(ss[i]);
			if ((val & 1) == 0) p[i] = Character
					.toLowerCase((char) (254 - val));
			else p[i] = Character.toLowerCase((char) (256 - val));
		}
		System.out.println(p);
		in.close();
	}
}
