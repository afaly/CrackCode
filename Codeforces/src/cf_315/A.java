package cf_315;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), S = in.nextInt(), q = in.nextInt(), cnt = 0, t = 0;
		while (t < T) {
			q *= S;
			t += q;
			cnt++;
		}
		System.out.println(cnt);
		in.close();
	}
}
