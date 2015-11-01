package cf_313;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine(), b = in.nextLine();
		if (a.equalsIgnoreCase(b)) System.out.println("YES");
		else if (a.length() % 2 == 0 && b.length() % 2 == 0) {
			char[] aa = a.toCharArray(), bb = b.toCharArray();
			int[] la = new int[26], ra = new int[26], lb = new int[26], rb = new int[26];
			for (int i = 0; i < aa.length / 2; i++)
				la[aa[i] - 'a']++;
			for (int i = aa.length / 2; i < aa.length; i++)
				ra[aa[i] - 'a']++;
			for (int i = 0; i < bb.length / 2; i++)
				lb[bb[i] - 'a']++;
			for (int i = bb.length / 2; i < bb.length; i++)
				rb[bb[i] - 'a']++;

			boolean f1 = true, f2 = true;
			for (int i = 0; i < 26 && f1; i++)
				f1 &= la[i] == lb[i] && ra[i] == rb[i];

			for (int i = 0; i < 26 && f2; i++)
				f2 &= la[i] == rb[i] && ra[i] == lb[i];

			if (f1 || f2) System.out.println("YES");
			else
				System.out.println("NO");
		} else {
			System.out.println("NO");
		}
		in.close();
	}
}
