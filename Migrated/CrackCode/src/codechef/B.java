package codechef;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine()), l, i, j, ii, jj;
		char[] c;
		while (T-- > 0) {
			c = in.nextLine().trim().toCharArray();
			l = c.length;
			i = 0;
			j = l - 1;
			ii = -1;
			jj = -1;
			boolean pal = true, used = false, again = false;
			while (j >= i && pal) {
				if (c[i] != c[j]) {
					if (!used) {
						used = true;
						boolean f1 = j >= i + 1 && c[i + 1] == c[j];
						boolean f2 = j - 1 >= i && c[i] == c[j - 1];
						if (f1 && f2) {
							again = true;
							ii = i;
							jj = j - 1;
							i++;
						} else if (f1) i++;
						else if (f2) j--;
						else pal = false;
					} else {
						pal = false;
					}
				}
				i++;
				j--;
			}
			if (pal) System.out.println("YES");
			else {
				if (again) {
					pal = true;
					i = ii;
					j = jj;
					while (j >= i && pal) {
						if (c[i] != c[j]) {
							if (!used) {
								used = true;
								boolean f1 = j >= i + 1 && c[i + 1] == c[j];
								boolean f2 = j - 1 >= i && c[i] == c[j - 1];
								if (f1 && f2) {
									again = true;
									ii = i;
									jj = j - 1;
									i++;
								} else if (f1) i++;
								else if (f2) j--;
								else pal = false;
							} else {
								pal = false;
							}
						}
						i++;
						j--;
					}
				}
				if (pal) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		in.close();
	}
}
