package ch_01;

import java.util.Scanner;

public class Q04 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] c = in.nextLine().toCharArray();
		int i;
		for (i = c.length - 1; i >= 0; i--)
			if (c[i] != ' ') break;

		for (int j = c.length - 1; j >= 0; j--) {
			if (c[i] != ' ') c[j] = c[i--];
			else {
				c[j--] = '0';
				c[j--] = '2';
				c[j] = '%';
				i--;
			}
		}

		System.out.println(new String(c));
		in.close();
	}
}
