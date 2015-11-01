package zetolabs_2015;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		char[] c = in.nextLine().toCharArray();
		boolean found = false;
		for (int i = 1; i < N && !found; i++) {
			for (int j = 0; j < N && !found; j++) {
				if (c[j] == '*') {
					int cnt = 0;
					for (int k = j; k < N && cnt < 5; k += i) {
						if (c[k] != '*') break;
						else
							cnt++;
					}
					if (cnt == 5) {
						// System.out.println("Found : " + i + "  , " + j);
						found = true;
					}
				}
			}
		}

		if (found) System.out.println("yes");
		else
			System.out.println("no");

		in.close();
	}

}
