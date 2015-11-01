package cf_313;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		String[] ss = in.nextLine().split("\\s+");
		int[] n = new int[N];
		for (int i = 0; i < N; i++)
			n[i] = I(ss[i]);
		Arrays.sort(n);
		if (n[0] == 1) {
			System.out.println("-1");
		} else {
			System.out.println("1");
		}
		in.close();
	}
}
