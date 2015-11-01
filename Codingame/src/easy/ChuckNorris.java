package easy;

import java.util.Scanner;

public class ChuckNorris {

	public static void print0(int c0, StringBuilder sb) {
		if (c0 > 0) {
			sb.append(" 00 ");
			for (int i = 0; i < c0; i++)
				sb.append("0");
		}
	}

	public static void print1(int c1, StringBuilder sb) {
		if (c1 > 0) {
			sb.append(" 0 ");
			for (int i = 0; i < c1; i++)
				sb.append("0");
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] MESSAGE = in.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < MESSAGE.length; j++) {
			int x = (int) MESSAGE[j];
			sb.append(String.format("%7s", Integer.toBinaryString(x)));
		}
		char[] M = sb.toString().replace(" ", "0").toCharArray();
		int c0 = 0, c1 = 0;
		sb = new StringBuilder();
		for (int j = 0; j < M.length;) {
			while (j < M.length && M[j] == '1') {
				c1++;
				j++;
			}
			print1(c1, sb);
			c1 = 0;
			while (j < M.length && M[j] == '0') {
				c0++;
				j++;
			}
			print0(c0, sb);
			c0 = 0;
		}
		System.out.println(sb.toString().trim());

		in.close();
	}
}
