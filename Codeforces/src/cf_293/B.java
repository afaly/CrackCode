package cf_293;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int y = 0, w = 0;
		int[] snt = new int[256];
		int[] tnt = new int[256];
		char[] s = in.nextLine().toCharArray();
		for (int i = 0; i < s.length; i++)
			snt[s[i]]++;
		char[] t = in.nextLine().toCharArray();
		for (int i = 0; i < t.length; i++)
			tnt[t[i]]++;

		for (char i = 'a'; i <= 'z'; i++) {
			char u = Character.toUpperCase(i);
			int difl = tnt[i] - snt[i];
			int difu = tnt[u] - snt[u];
			if (difl >= 0) {
				y += snt[i];
			} else {
				y += tnt[i];
			}
			if (difu >= 0) {
				y += snt[u];
			} else {
				y += tnt[u];
			}
			if (difl < 0 && difu > 0) {
				w += Math.min(-difl, difu);
			}
			if (difu < 0 && difl > 0) {
				w += Math.min(-difu, difl);
			}
		}
		System.out.println(y + " " + w);
		in.close();
	}

}
