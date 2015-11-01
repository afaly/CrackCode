package cf_306;

import java.util.Scanner;

public class A {

	public static boolean isSubstring(String s) {
		String[] ss = s.split("A");
		int f1 = 0, f2 = 0, i = -1, j = -1, k = 0;
		for (String x : ss) {
			if (x.isEmpty()) continue;
			if (x.length() == 1) {
				if (f1 > 0) f2 += x.equals("B") ? 1 : 0;
				else
					f1 += x.equals("B") ? 1 : 0;
			} else {
				f1 += x.startsWith("B") ? 1 : 0;
				f2 += x.endsWith("B") ? 1 : 0;
			}
		}
		return (f1 > 1 || f2 > 1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(isSubstring(in.nextLine()) ? "YES" : "NO");
		in.close();
	}

}
