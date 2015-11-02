package cryptography;

import java.util.HashMap;
import java.util.Scanner;

public class J {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Character, Character> m = new HashMap<Character, Character>();
		String[] cipherStr = { "wbpctfb", "ghnxfuv", "jjy", "lvevavsvcz",
				"mkojrpcf", "qcvhcvyginfnf", "djfa" };
		String[] plainStr = { "charzeh", "yousefi", "mmt", "bikinigirl",
				"djvmware", "priorityqueue", "xmen" };
		for (int i = 0; i < cipherStr.length; i++) {
			char[] c = cipherStr[i].toCharArray();
			char[] p = plainStr[i].toCharArray();
			for (int j = 0; j < c.length; j++)
				m.put(c[j], p[j]);
		}

		char[] c = in.nextLine().trim().toCharArray();
		char[] d = new char[c.length];

		for (int i = 0; i < c.length; i++)
			d[i] = m.get(c[i]);

		System.out.println(new String(d));
		in.close();
	}

}
