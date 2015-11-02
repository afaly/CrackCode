package hackerRank;

import java.util.Scanner;

public class Socks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			System.out.println(in.nextInt() + 1);
		}
		in.close();
	}
}
