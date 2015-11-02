package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class KeywordTranspositionCipher {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		while (N-- > 0) {
			char[] K = in.nextLine().toCharArray();
			char[] C = in.nextLine().toCharArray();
			int Klen = K.length, Clen = C.length, cnt = 0;
			HashMap<Integer, ArrayList<Character>> key = new HashMap<Integer, ArrayList<Character>>(
					Klen);
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			int pos = 0;
			for (Character c : K)
				map.put(c, pos++);
			boolean[] f = new boolean[26];
			for (char c : K) {
				key.put(cnt, new ArrayList<Character>());
				key.get(cnt).add(c);
				f[c - 'A'] = true;
				cnt++;
			}
			cnt = 0;
			for (int i = 0; i < 26; i++)
				if (!f[i]) {
					key.get(map.get(K[cnt % Klen])).add((char) (i + 'A'));
					cnt++;
				}
			char[] conv = new char[26];
			char start = 'A';
			Arrays.sort(K);
			for (Character k : K) {
				System.out.println(key.get(map.get(k)));
				for (char c : key.get(map.get(k)))
					conv[c - 'A'] = start++;
			}

			for (int i = 0; i < Clen; i++)
				if (C[i] - 'A' >= 0 && C[i] - 'A' < 26) C[i] = conv[C[i] - 'A'];
			System.out.println(new String(C));
		}
		in.close();
	}
}
