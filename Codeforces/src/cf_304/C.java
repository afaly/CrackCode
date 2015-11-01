package cf_304;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine());
		String[] s1 = in.nextLine().split("\\s+");
		String[] s2 = in.nextLine().split("\\s+");
		int n1 = I(s1[0]), n2 = I(s2[0]);
		Queue<Integer> p1 = new LinkedList<Integer>();
		Queue<Integer> p2 = new LinkedList<Integer>();
		for (int i = 1; i <= n1; i++)
			p1.add(I(s1[i]));
		for (int i = 1; i <= n2; i++)
			p2.add(I(s2[i]));

		int cnt = 0;
		int winner = 0;
		int turns = 10000000;
		while (!p1.isEmpty() && !p2.isEmpty() && winner == 0 && turns >= 0) {
			int m1 = p1.poll();
			int m2 = p2.poll();
			if (m1 > m2) {
				p1.add(m2);
				p1.add(m1);
			} else {
				p2.add(m1);
				p2.add(m2);
			}
			cnt++;
			turns--;
			if (p1.isEmpty()) winner = 2;
			if (p2.isEmpty()) winner = 1;
		}
		if (winner <= 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt + " " + winner);
		}
		in.close();
	}
}
