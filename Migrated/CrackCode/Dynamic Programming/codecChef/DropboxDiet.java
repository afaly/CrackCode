package codecChef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 Of the boatload of perks Dropbox offers, the ones most threatening to our engineers’ 
 waistlines are the daily lunches, the fully-stocked drink fridge, and a full-length 
 bar covered with every snack you could want. All of those calories add up. Luckily,
 the office is also well-equipped with ping-pong, a DDR machine, and a subsidized gym
 right across the street that can burn those calories right back off. Although we often
 don’t, Dropboxers should choose the food they eat to counterbalance the activities they
 perform so that they don’t end up with caloric deficit or excess.

 Help us keep our caloric intake in check. You’ll be given a list of activities and their
 caloric impact. 

 Write a program that outputs the names of activities a Dropboxer should choose to partake
 in so that the sum of their caloric impact is zero. Once an activity is selected, it cannot
 be chosen again.
 */
/* INPUT: */
/*
 2
 red-bull 140
 coke 110
 */
/*
 12
 free-lunch 802
 mixed-nuts 421
 orange-juice 143
 heavy-ddr-session -302
 cheese-snacks 137
 cookies 316
 mexican-coke 150
 dropballers-basketball -611
 coding-six-hours -466
 riding-scooter -42
 rock-band -195
 playing-drums -295
 */
/* OUTPUT: */
/*
 no solution
 */
/*
 coding-six-hours
 cookies
 mexican-coke
 */
public class DropboxDiet {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	private static int[] v;
	private static Boolean[][] mem;
	private static int sz, off;
	private static ArrayList<Integer> sol;

	public static ArrayList<Integer> Diet(int[] vals) {
		v = vals;
		sz = vals.length;
		Arrays.sort(v);
		diet(0, 0, new Stack<Integer>());
		return sol;
	}

	private static boolean diet(int i, int sum, Stack<Integer> st) {
		if (sum > 0) return false;
		if (sum == 0 && !st.isEmpty()) {
			sol = new ArrayList<Integer>(st);
			return true;
		}
		if (i == sz) return false;
		st.push(v[i]);
		boolean f1 = diet(i + 1, sum + v[i], st);
		st.pop();
		boolean f2 = diet(i + 1, sum, st);
		return f1 || f2;
	}

	public static ArrayList<Integer> Diet_DP(int[] vals) {
		v = vals;
		sz = vals.length;
		Arrays.sort(v);
		int maxSum = 0, minSum = 0;
		if (v[0] >= 0) return null;
		for (int val : v) {
			if (val > 0) maxSum += val;
			else
				minSum += val;
		}
		off = -minSum;
		mem = new Boolean[sz][maxSum + off + 1];
		if (diet(0, -1, 0)) {
			sol = new ArrayList<Integer>();
			int i = 0, sum = off;
			for (int j = 0; j < sz; j++)
				if (mem[j][sum] != null && mem[j][sum]) i = j;
			while (i > 0) {
				if (mem[i][sum] != null && mem[i][sum]) {
					if (mem[i - 1][sum] != null && mem[i - 1][sum]) {
						i--;
					} else {
						sol.add(i);
						for (int j = 0; j < i; j++) {
							if (mem[j][sum] != null && mem[j][sum]) i = j;
						}
					}
				}
			}
		}
		return sol;
	}
	

	private static boolean diet(int i, int j, int sum) {
		if (sum > 0) return false;
		if (sum == 0 && j > -1) return true;
		if (i == sz) return false;
		if (mem[i][sum + off] != null) return mem[i][sum + off];
		boolean f1 = diet(i + 1, i, sum + v[i]);
		boolean f2 = diet(i + 1, j, sum);
		mem[i][sum + off] = f1 || f2;
		return mem[i][sum + off];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = I(in.nextLine().trim());
		int n[] = new int[N];
		String[] s;
		HashMap<Integer, String> cal = new HashMap<Integer, String>();
		while (--N >= 0) {
			s = in.nextLine().trim().split("\\s+");
			n[N] = I(s[1]);
			cal.put(n[N], s[0]);
		}
		System.out.println("Solution By DP : " + Diet_DP(n));
		ArrayList<Integer> res = Diet(n);
		if (res == null || res.size() == 0) System.out.println("no soultion");
		else
			for (Integer key : res)
				System.out.println(cal.get(key) + " " + key);
		in.close();
	}
}
