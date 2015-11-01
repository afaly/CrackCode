package cf_293;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		char[] t = in.nextLine().toCharArray();
		int len = s.length;
		boolean found = false;
		int i = 0;
		while (i < len && t[i] == s[i])
			i++;
		if (i < len && t[i] - s[i] > 1) {
			s[i]++;
			found = true;
		} else {
			while (++i < len && s[i] == 'z');
			if (i < len) {
				found = true;
				s[i]++;
			}
		}

		if (found) System.out.println(new String(s));
		else
			System.out.println("No such string");
		in.close();
	}
}
