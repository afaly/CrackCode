package euler;

import java.util.Scanner;

public class Euler_059 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean[] valid = new boolean[255];
		for (int i = 'a'; i <= 'z'; i++)
			valid[i] = true;
		for (int i = 'A'; i <= 'Z'; i++)
			valid[i] = true;
		for (int i = '0'; i <= '9'; i++)
			valid[i] = true;
		// ;:,.'?-!
		valid['('] = true;
		valid[')'] = true;
		valid[';'] = true;
		valid[':'] = true;
		valid[','] = true;
		valid['.'] = true;
		valid['\''] = true;
		valid['?'] = true;
		valid['-'] = true;
		valid['!'] = true;
		valid[' '] = true;

		int N = in.nextInt();
		int[] n = new int[N];
		char[] key = new char[3];
		for (int i = 0; i < N; i++)
			n[i++] = in.nextInt();
		boolean found = false;
		for (int j = 'a'; j <= 'z' && !found; j++) {
			boolean flag = false;
			for (int z = 0; z < N && !flag; z += 3) {
				if (!valid[n[z] ^ j]) flag = true;
			}
			if (!flag) {
				key[0] = (char) j;
				found = true;
			}
		}

		found = false;
		for (int j = 'a'; j <= 'z' && !found; j++) {
			boolean flag = false;
			for (int z = 2; z < N && !flag; z += 3) {
				if (!valid[n[z] ^ j]) flag = true;
			}
			if (!flag) {
				key[1] = (char) j;
				found = true;
			}
		}

		found = false;
		for (int j = 'a'; j <= 'z' && !found; j++) {
			boolean flag = false;
			for (int z = 1; z < N && !flag; z += 3) {
				if (!valid[(n[z] ^ j)]) flag = true;
			}
			if (!flag) {
				key[2] = (char) j;
				found = true;
			}
		}

		System.out.println(key);

		in.close();
	}

}
