package dynamic;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/*-
 Problem Statement

 We are in a distant future. After the downfall of mankind, the Earth is now ruled by fairies. The "Turing game Online" website is hot among fairies right now. On this website, everyone can play the programming puzzle "Turing game".

 Fairies love powers of 5, that is, the numbers 1, 5, 25, 125, 625, and so on. In the Turing game, the player is given a string of bits (zeros and ones). The ideal situation is when the string is represents a power of 5 in binary, with no leading zeros. If that is not the case, the fairy player tries to cut the given string into pieces, each piece being a binary representation of a power of 5, with no leading zeros. Of course, it may be the case that even this is impossible. In that case, the fairy player becomes depressed, and bad things happen when a fairy gets depressed. You, as one of the surviving humans, are in charge of checking the bit strings to prevent the bad things from happening.

 You are given a String S that consists of characters '0' and '1' only. S represents the string given to a player of the Turing game. Return the smallest positive integer K such that it is possible to cut S into K pieces, each of them being a power of 5. If there is no such K, return -1 instead.

 Definition

 Class:	CuttingBitString
 Method:	getmin
 Parameters:	String
 Returns:	int
 Method signature:	int getmin(String S)
 (be sure your method is public)



 Constraints
 -	S will contain between 1 and 50 characters, inclusive.
 -	Each character in S will be either '0' or '1'.

 Examples
 0)	

 "101101101"
 Returns: 3
 We can split the given string into three "101"s.

 Note that "101" is 5 in binary.

 1)	

 "1111101"
 Returns: 1
 "1111101" is 5^3.

 2)	

 "00000"
 Returns: -1
 0 is not a power of 5.

 3)	

 "110011011"
 Returns: 3
 Split it into "11001", "101" and "1".

 4)	

 "1000101011"
 Returns: -1
 5)	

 "111011100110101100101110111"
 Returns: 5
 */

public class CuttingBitString {

	private static Set<String> po5;
	private static String s;
	private static char[] c;
	private static int[][] mem;
	private static int Size, OO = 100;

	static {
		po5 = new LinkedHashSet<String>();
		for (long i = 1; i < Math.pow(2, 51); i *= 5)
			po5.add(Long.toBinaryString(i));
	}

	public static int cutBitString(String str) {
		s = str;
		c = str.toCharArray();
		Size = c.length;
		mem = new int[Size][Size];
		for (int i = 0; i < Size; i++) {
			Arrays.fill(mem[i], -1);
		}
		int ret = cutBitStr(0, 0);
		return ret >= OO ? -1 : ret;
	}

	private static int cutBitStr(int i, int j) {
		if (j == Size - 1) return isPowerOfFive(i, j) ? 1 : OO;
		if (mem[i][j] > -1) return mem[i][j];
		int c1 = OO;
		if (isPowerOfFive(i, j)) c1 = 1 + cutBitStr(j + 1, j + 1);
		int c2 = cutBitStr(i, j + 1);
		mem[i][j] = Math.min(c1, c2);
		return mem[i][j];

	}

	private static boolean isPowerOfFive(int i, int j) {
		return po5.contains(s.substring(i, j + 1));
	}

	public static void main(String[] args) {
		System.out.println("Min Cut: " + cutBitString("101101101"));
		System.out.println("Min Cut: " + cutBitString("1111101"));
		System.out.println("Min Cut: " + cutBitString("00000"));
		System.out.println("Min Cut: " + cutBitString("110011011"));
		System.out.println("Min Cut: " + cutBitString("1000101011"));
		System.out.println("Min Cut: "
				+ cutBitString("111011100110101100101110111"));
	}

}
