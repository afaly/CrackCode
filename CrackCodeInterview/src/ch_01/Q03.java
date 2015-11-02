package ch_01;

import java.util.Scanner;

public class Q03 {

	public static boolean isPermutation(String a, String b) {
		if (a.length() != b.length()) return false;
		int[] freq = new int[256];
		for (int i = 0; i < a.length(); i++) {
			freq[a.charAt(i)]++;
			freq[b.charAt(i)]--;
		}
		for (int i = 0; i < 256; i++)
			if (freq[i] != 0) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(isPermutation(in.nextLine(), in.nextLine()));
		in.close();
	}

}
