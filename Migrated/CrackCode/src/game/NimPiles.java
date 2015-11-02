package game;

public class NimPiles {

	public static boolean isWin(int[] piles) {
		int res = 0;
		for (int pile : piles)
			res ^= pile;
		return res != 0;
	}

	public static void main(String[] args) {
		System.out.println(isWin(new int[] { 1, 2, 3 }));
		System.out.println(isWin(new int[] { 7, 4, 1 }));
	}
}
