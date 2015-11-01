package graphs;

import java.util.Scanner;

public class cf_500A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), T = in.nextInt();
		in.nextLine();
		int[] n = new int[N];
		String[] s = in.nextLine().split("\\s+");
		for (int i = 1; i < N; i++)
			n[i] = I(s[i - 1]);
		int cur = 1;
		while (cur != T && cur < N)
			cur += n[cur];
		if (cur == T) System.out.println("YES");
		else
			System.out.println("NO");
		in.close();
	}

}
