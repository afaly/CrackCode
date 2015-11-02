package cryptography;

public class E {

	private static final int U = (int) 'U';
	private static final int F = (int) 'F';

	public static long uf(String s) {
		long val = 0l, exp = 1l;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'U') val += (exp * 1);
			// else val += (exp * F);
			exp *= 256;
		}
		return val;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 26; i++)
			System.out.println((char) (i + 'A') + "  : " + (int) (i + 'A'));
		System.out.println("U: " + (int) 'U' + " >> " + (int) 'T');
		System.out.println("F: " + (int) 'F' + " >> " + (int) 'E');
		System.out.println("0: " + (int) '0');
		System.out.println("1: " + (int) '1');
		System.out.println("c: " + (int) 'c');
		System.out.println(uf("FUUUU") % 256);
		System.out.println(uf("UUUUU") % 256);
		System.out.println(uf("FFF") % 256);
	}

}
