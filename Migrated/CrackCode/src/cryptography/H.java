package cryptography;

import java.util.Scanner;

public class H {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().trim().split("\\W+");
		int[] cr = new int[26];
		long sum = 0;
		for (int i = 0; i < 26; i++) {
			cr[i] = Integer.parseInt(ss[i]);
			sum += cr[i];
		}
		char[] p = new char[(int) sum];
		int cnt = cr[0], ci = 0;
		for (int i = 0; i < sum; i++) {
			while (cnt == 0)
				cnt = cr[++ci];
			int pos = Integer.parseInt(in.nextLine().trim());
			p[pos - 1] = (char) (ci + 'a');
			cnt--;
		}

		System.out.println(p);
		in.close();
	}
}
