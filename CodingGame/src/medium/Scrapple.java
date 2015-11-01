package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
public class Scrapple {

	public static Map<String, String> map;
	public static Map<Integer, ArrayList<String>> smap;
	public static int maxScore = -1;
	public static boolean[] maxString;
	public static boolean solved = false;

	public static String toStr(Character[] c, boolean[] f) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			if (f[i])
				sb.append(c[i]);
		}
		return sb.toString();
	}

	public static int Score(Character[] c, boolean[] f, int i) {
		if (solved)
			return 0;
		if (i >= c.length) {
			int score = 0;
			for (int j = 0; j < c.length; j++) {
				if (f[j])
					score += findScore(c[j]);
			}
			return score;
		} else {
			// TAKE IT
			int s1 = Score(c, f, i + 1);
			if (s1 > maxScore && map.containsKey(toStr(c, f))) {
				maxScore = s1;
				maxString = Arrays.copyOf(f, 7);
				solved = true;
			}
			f[i] = false;
			int s2 = Score(c, f, i + 1);
			if (s2 > maxScore && map.containsKey(toStr(c, f))) {
				maxScore = s2;
				maxString = Arrays.copyOf(f, 7);
				solved = true;
			}
			f[i] = true;
			return Math.max(s1, s2);
		}
	}

	public static int findScore(char c) {
		if (c == 'e' || c == 'a' || c == 'i' || c == 'o' || c == 'n'
				|| c == 'r' || c == 't' || c == 'l' || c == 's' || c == 'u')
			return 1;
		else if (c == 'd' || c == 'g')
			return 2;
		else if (c == 'b' || c == 'c' || c == 'm' || c == 'm' || c == 'p')
			return 3;
		else if (c == 'f' || c == 'h' || c == 'v' || c == 'w' || c == 'y')
			return 4;
		else if (c == 'k')
			return 5;
		else if (c == 'j' || c == 'x')
			return 8;
		else if (c == 'q' || c == 'z')
			return 10;
		else
			return 0;
	}

	public static Comparator<Character> cmp = new Comparator<Character>() {
		@Override
		public int compare(Character o1, Character o2) {
			int s2 = findScore(o2);
			int s1 = findScore(o1);
			if (s1 == s2)
				return o1.compareTo(o2);
			else
				return s2 - s1;
		}
	};

	public static Character[] toCharacterArray(String s) {
		if (s == null)
			return null;
		int len = s.length();
		Character[] array = new Character[len];
		for (int i = 0; i < len; i++) {
			array[i] = new Character(s.charAt(i));
		}
		return array;
	}

	public static String toStr(Character[] c) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]);
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		map = new HashMap<String, String>(N);
		smap = new HashMap<Integer, ArrayList<String>>();
		for (int i = 0; i < N; i++) {
			String ss = in.nextLine();
			Character[] W = toCharacterArray(ss);
			Arrays.sort(W, cmp);
			map.put(toStr(W), ss);
			int score = 0;
			for (Character c : W)
				score += findScore(c);
			ArrayList<String> l;
			if (smap.containsKey(score))
				l = smap.get(score);
			else
				l = new ArrayList<String>();
			l.add(ss);
			smap.put(score, l);
			System.err.println(ss + " : " + score);
		}
		Character[] L = toCharacterArray(in.nextLine());
		boolean[] f = new boolean[7];
		for (int k = 0; k < f.length; k++)
			f[k] = true;
		Arrays.sort(L, cmp);
		Score(L, f, 0);
		String res = toStr(L, maxString);
		System.err.println(maxScore);
		ArrayList<String> resList = smap.get(maxScore);
		for (String rs : resList) {
			System.err.println(rs + "  : " + res);
			Character[] crs = toCharacterArray(rs);
			Arrays.sort(crs, cmp);
			if (res.equalsIgnoreCase(toStr(crs))) {
				System.out.println(rs);
				break;
			}
		}
		in.close();
	}
}