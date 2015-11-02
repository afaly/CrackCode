package bloomberg;

public class Bloom_009 {

	public static int firstUnique(String s) {
		int[] f = new int[256];
		char[] p = s.toCharArray();
		for (int i = p.length - 1; i >= 0; i--) {
			if (f[p[i]] == 0) f[p[i]] = i + 1;
			else
				f[p[i]] = -1;
		}
		int idx = s.length() + 1;
		for (int i = 0; i < 256; i++)
			if (f[i] > 0 && f[i] < idx) idx = f[i];
		return idx - 1;
	}

	public static void main(String[] args) {
		System.out.println(firstUnique("zaaaabbbabbbbccccccghhhhjkiwuye"));
	}

}
