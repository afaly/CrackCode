package cf_313;

import java.util.Scanner;

public class C {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static int Count(int[] n) {
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			cnt += n[i];
			if (n[i] > 0) n[i]--;
		}
		return cnt > 0 ? cnt + Count(n) : cnt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		int[] n = new int[6];
		for (int i = 0; i < 6; i++)
			n[i] = I(s[i]);
		System.out.println(Count(n));
		in.close();
	}

}
