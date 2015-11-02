package nonLecture;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class OnlinePalindrome {

	private int R = 256;
	private long h1, h2;
	private int cnt;
	private long P, k;
	private char temp;

	private Queue<Character> q;

	// a random 31-bit prime
	private static long longRandomPrime() {
		return BigInteger.probablePrime(31, new Random()).longValue();
	}

	public OnlinePalindrome(int R) {
		this.q = new LinkedList<>();
		this.P = longRandomPrime();
		this.R = Math.min(Math.max(0, R), 256);
		this.h1 = 0l;
		this.h2 = 0l;
		this.cnt = 0;
		this.k = 1l;
	}

	public boolean digest(char c) {
		cnt++;
		if (cnt == 1) {
			h1 = c;
			return true;
		} else if (cnt == 2) {
			q.add(c);
			h2 = c;
			return h1 == h2;
		} else {
			q.add(c);
			if ((cnt & 1) == 1) {
				temp = q.remove();
				h2 = (h2 / R) % P;
				h2 = (((c * k) % P) + h2) % P;
			} else {
				h1 = (((h1 * R) % P) + temp) % P;
				k = (k * R) % P;
				h2 = (((c * k) % P) + h2) % P;
			}
			System.out.println(h1 + " , " + h2);
			return h1 == h2;
		}
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("abababababa");
		String s1 = sb.toString();
		String s2 = sb.reverse().toString();
		String s = s1 + s2;
		System.out.println(s);
		OnlinePalindrome p = new OnlinePalindrome(256);
		for (char c : s.toCharArray()) {
			System.out.println("C :" + c + " PAL : " + p.digest(c));
		}
	}

}
