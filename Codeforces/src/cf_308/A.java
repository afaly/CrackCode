package cf_308;

import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine()), cnt = 0;
		String[] s;
		while (N-- > 0) {
			s = in.nextLine().split("\\s+");
			int x1 = I(s[0]), y1 = I(s[1]), x2 = I(s[2]), y2 = I(s[3]);
			cnt += ((x2 - x1) + 1) * ((y2 - y1) + 1);
		}
		System.out.println(cnt);
		in.close();
	}
}
