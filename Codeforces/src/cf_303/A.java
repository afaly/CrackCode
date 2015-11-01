package cf_303;

import java.util.ArrayList;
import java.util.Scanner;

public class A {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			String[] s = in.nextLine().split("\\s+");
			boolean good = true;
			for (int j = 0; j < N && good; j++) {
				int v = I(s[j]);
				if (v == 1 || v == 3) good = false;
			}
			if (good) ans.add(i);
		}
		System.out.println(ans.size());
		StringBuilder sb = new StringBuilder();
		for (int v : ans)
			sb.append(v).append(" ");
		if (ans.size() > 0) System.out.println(sb.toString().trim());

		in.close();
	}

}
