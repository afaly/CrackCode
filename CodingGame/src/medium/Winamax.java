package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
public class Winamax {

	public static int getValue(String s) {
		int val = 0;
		try {
			val = Integer.parseInt(s);
		} catch (Exception e) {
			if (s.equalsIgnoreCase("J"))
				val = 11;
			else if (s.equalsIgnoreCase("Q"))
				val = 12;
			else if (s.equalsIgnoreCase("K"))
				val = 13;
			else if (s.equalsIgnoreCase("A"))
				val = 14;
		}
		return val;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Queue<Integer> p1, p2, t1, t2;
		p1 = new LinkedList<Integer>();
		p2 = new LinkedList<Integer>();
		t1 = new LinkedList<Integer>();
		t2 = new LinkedList<Integer>();

		int n = in.nextInt(); // the number of cards for player 1
		for (int i = 0; i < n; i++) {
			String c1 = in.next(); // the n cards of player 1
			p1.add(getValue(c1.substring(0, c1.length() - 1)));
		}
		int m = in.nextInt(); // the number of cards for player 2
		for (int i = 0; i < m; i++) {
			String c2 = in.next(); // the m cards of player 2
			p2.add(getValue(c2.substring(0, c2.length() - 1)));
		}
		in.close();

		boolean fight = true;
		boolean isWar = false;
		int winner = 0;
		int games = 0;
		while (fight) {
			if (p1.isEmpty()) {
				winner = 2;
				fight = false;
			} else if (p2.isEmpty()) {
				winner = 1;
				fight = false;
			} else {
				if (!isWar)
					games++;
				int v1 = p1.poll();
				int v2 = p2.poll();
				t1.add(v1);
				t2.add(v2);
				if (v1 > v2) {
					p1.addAll(t1);
					p1.addAll(t2);
					isWar &= false;
					t1.clear();
					t2.clear();
				} else if (v2 > v1) {
					p2.addAll(t1);
					p2.addAll(t2);
					isWar &= false;
					t1.clear();
					t2.clear();
				} else {
					if (p1.size() < 3 || p2.size() < 3) {
						winner = 0;
						fight = false;
					} else {
						int itrs = 3;
						while (itrs-- > 0) {
							t1.add(p1.poll());
							t2.add(p2.poll());
						}
					}
				}
			}
		}

		if (winner == 1)
			System.out.println(winner + " " + games);
		else if (winner == 2)
			System.out.println(winner + " " + games);
		else
			System.out.println("PAT");
	}
}