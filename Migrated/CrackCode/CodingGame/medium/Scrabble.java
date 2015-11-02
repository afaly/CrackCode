package medium;

import java.util.Scanner;

public class Scrabble {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int nbMot = in.nextInt();
		int maxPoint = 0;
		int indiceMot = 0;
		String mots[] = new String[nbMot];
		for (int i = 0; i < nbMot; i++) {
			mots[i] = in.next();
		}
		String lettreAutorise = in.next();
		for (int i = 0; i < nbMot; i++) {
			String lettreA = lettreAutorise;
			int point = 0;
			String motAutorise = "";
			for (int j = 0; j < mots[i].length(); j++) {
				int index = lettreA.indexOf(mots[i].charAt(j));
				if (index < 0) {
					motAutorise = "KO";
					break;
				} else {
					String lettresTmp = lettreA.substring(0, index)
							+ lettreA.substring(index + 1);
					lettreA = lettresTmp;
				}
			}
			if (motAutorise != "KO") {
				for (int j = 0; j < mots[i].length(); j++) {
					point += pointLettre(mots[i].charAt(j));
				}
				if (point > maxPoint) {
					maxPoint = point;
					indiceMot = i;
				}
			}
		}
		System.out.println(mots[indiceMot]);

		in.close();
	}

	public static int pointLettre(char lettre) {
		switch (lettre) {
		case 'e':
		case 'a':
		case 'i':
		case 'o':
		case 'n':
		case 'r':
		case 't':
		case 'l':
		case 's':
		case 'u':
			return 1;
		case 'd':
		case 'g':
			return 2;
		case 'b':
		case 'c':
		case 'm':
		case 'p':
			return 3;
		case 'f':
		case 'h':
		case 'v':
		case 'w':
		case 'y':
			return 4;
		case 'k':
			return 5;
		case 'j':
		case 'x':
			return 8;
		case 'q':
		case 'z':
			return 10;
		}
		return 0;
	}
}
