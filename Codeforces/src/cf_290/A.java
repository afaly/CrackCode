package cf_290;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < m - 1; i++) {
			sb1.append(".");
			sb2.append("#");
		}
		sb2.append("#");
		for (int i = 0, j = 0; i < n; i++) {
			if ((i & 1) == 0) {
				System.out.println(sb2.toString());
			} else {
				if ((j & 1) == 0)
					System.out.println(sb1.toString() + "#");
				else
					System.out.println("#" + sb1.toString());
				j++;
			}
		}

		in.close();
	}

}
