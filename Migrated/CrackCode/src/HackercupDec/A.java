package HackercupDec;

import java.util.BitSet;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		int SET = 1, UNSET = 2;
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine().trim());
		long a, b;
		String[] ss;
		BitSet as, bs, rs, is;
		while (T-- > 0) {
			ss = in.nextLine().trim().split(" ");
			a = Long.parseLong(ss[0].trim());
			b = Long.parseLong(ss[1].trim());
			as = BitSet.valueOf(new long[] { a });
			bs = BitSet.valueOf(new long[] { b });
			rs = BitSet.valueOf(new long[] { 0l });
			for (int i = 0; i < 32; i++) {
				if (as.get(i) && bs.get(i)) {
					is = BitSet.valueOf(new long[] { b });
					int j = is.nextClearBit(i);
					is.clear(0, j);
					is.set(j);
					long ii = is.toLongArray()[0];
					if (!(ii > b && ii < a))
						rs.set(i);
				}
			}
			long[] R = rs.toLongArray();
			if (R != null && R.length > 0)
				System.out.println(R[0]);
			else
				System.out.println(0l);
		}

		in.close();
	}
}
