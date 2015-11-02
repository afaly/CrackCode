package cryptography;

import java.util.Scanner;

public class K {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 26; i++)
			System.out.println((char) (i + 'a') + "  : " + (int) (i + 'a'));
		int len = Integer.parseInt(in.nextLine());
		char[] p = new char[len];
		String[] ss = in.nextLine().split(" ");
		for (int i = 0; i < len; i++) {
			long val = Long.parseLong(ss[i]);
			int chr = (((int) (val - 'A')) % 26) + 'A';
			System.out.println(chr + " : " + (char) chr);
			p[i] = (char) chr;
		}
		System.out.println(p);
		in.close();
		String[] s = "Z,1,1,1,2,2,1,1,2,1,4,1,3,1,1,1,1,1,3,2,2,1,2,2,1,1,1,1,2,2,2,2,2,1,1,2,1".split(",");
		System.out.println(s.length);
	}
}
