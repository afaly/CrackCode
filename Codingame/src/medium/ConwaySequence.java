package medium;

import java.util.ArrayList;
import java.util.Scanner;

public class ConwaySequence {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int L = in.nextInt();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(R);
		for (int i = 2; i <= L; i++) {
			ArrayList<Integer> l2 = new ArrayList<Integer>();
			Integer x = l1.get(0), y = -1;
			int cnt = 1;
			for (int j = 1; j < l1.size(); j++) {
				y = l1.get(j);
				if (x == y) cnt++;
				else {
					l2.add(cnt);
					l2.add(x);
					x = y;
					cnt = 1;
				}
			}
			l2.add(cnt);
			l2.add(x);
			l1 = l2;
		}
		StringBuilder sb = new StringBuilder();
		for (Integer i : l1)
			sb.append(i).append(" ");
		System.out.println(sb.toString().trim());

		in.close();
	}
}
