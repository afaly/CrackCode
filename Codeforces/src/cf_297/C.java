package cf_297;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String[] s = in.nextLine().split("\\s+");
		Integer[] l = new Integer[N];
		for (int i = 0; i < N; i++)
			l[i] = Integer.parseInt(s[i]);

		Arrays.sort(l, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});
		long cnt = 0, d1 = 0, d2 = 0, area = 0;
		for (int i = 0; i < N - 1;) {
			if (l[i] - l[i + 1] > 1) {
				i++;
				continue;
			}
			cnt++;
			if (cnt % 2 == 0) {
				d2 = Math.min(l[i], l[i + 1]);
				area += (d2 * d1);
			} else {
				d1 = Math.min(l[i], l[i + 1]);
			}
			i += 2;
		}
		System.out.println(area);
		in.close();
	}
}
