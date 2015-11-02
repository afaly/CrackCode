package bit;

import java.util.Scanner;

public class Flip {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T-- > 0) {
			int v = in.nextInt();
			int m = (1 << 31) - 1;
			System.out.println(v ^ m);
		}
		in.close();
	}

}
