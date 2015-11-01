package cf_300;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split("\\s+");
		long n = Long.parseLong(s[0]);
		int m = Integer.parseInt(s[1]);

		s = in.nextLine().split("\\s+");
		long d = Long.parseLong(s[0]);
		long h = Long.parseLong(s[1]);
		long maxh = h + (d - 1);
		boolean valid = true;
		for (int i = 1; i < m && valid; i++) {
			s = in.nextLine().split("\\s+");
			long dd = Long.parseLong(s[0]);
			long hh = Long.parseLong(s[1]);
			if (Math.abs(dd - d) < Math.abs(hh - h)) valid = false;
			else {
				long x = ((dd - d) + Math.abs(hh - h)) - 1;
//				System.out.println("X : " + x);
				if (h < hh) {
					maxh = Math.max(maxh, hh);
					if (x > 0) maxh = Math.max(maxh, h + ((x + 1) / 2));
				} else {
					maxh = Math.max(maxh, h);
					if (x > 0) maxh = Math.max(maxh, hh + ((x + 1) / 2));
				}
			}

			d = dd;
			h = hh;
		}
		if (valid) {
			maxh = Math.max(maxh, h + (n - d));
			System.out.println(maxh);
		} else
			System.out.println("IMPOSSIBLE");
		in.close();
	}
}
