package easy;

import java.util.Scanner;

public class AsciiArt {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		in.nextLine();
		int H = in.nextInt();
		in.nextLine();
		char[] val = in.nextLine().toCharArray();
		char[][][] c = new char[27][H][L];
		for (int i = 0; i < H; i++) {
			char[] ROW = in.nextLine().toCharArray();
			for (int j = 0; j < ROW.length; j++) {
				int k = j / L;
				int l = j % L;
				c[k][i][l] = ROW[j];
			}
		}
		for (int i = 0; i < H; i++) {
			for (char ch : val) {
				int idx = Character.toUpperCase(ch) - 'A';
				if (idx < 0 || idx > 26) idx = 26;
				System.out.print(new String(c[idx][i]));
			}
			System.out.println("");
		}

		in.close();
	}
}
