package edu;

import java.util.Scanner;

public class WorldCupCity {

	public static int I(String s) {
		return Integer.parseInt(s);
	}

	public static long L(String s) {
		return Long.parseLong(s);
	}

	public static int[] IA(String s) {
		String[] ss = s.split("\\s+");
		int[] a = new int[ss.length];
		for (int i = 0; i < ss.length; i++)
			a[i] = Integer.parseInt(ss[i]);
		return a;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		

		in.close();
	}
}
