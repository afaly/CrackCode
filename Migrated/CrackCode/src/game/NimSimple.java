package game;

import java.util.Arrays;

enum Player {
	First, Second
}

public class NimSimple {

	private boolean[] game;
	private int[] moves;
	private boolean WIN = true, LOS = false;

	public NimSimple(int Coins, int[] moves) {
		this.game = new boolean[Coins + 1];
		this.moves = moves;
		Arrays.sort(this.moves);
		play();
	}

	public boolean isWin(int pos) {
		return game[pos];
	}

	public String game() {
		int width = 0;
		int len = game.length;
		while (len > 0) {
			width++;
			len /= 10;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("{ \n");
		for (int i = 0; i < game.length; i++) {
			sb.append(String.format("\t[%" + width + "d]", i));
			if (game[i]) sb.append(" W\n");
			else sb.append(" L\n");
		}
		sb.append("}");
		return sb.toString();
	}

	private void play() {
		game[0] = LOS;
		for (int i = 1; i < game.length; i++) {
			for (int j = 0; j < moves.length && i >= moves[j] && !game[i]; j++) {
				if (!game[i - moves[j]]) game[i] = WIN;
			}
		}
	}

	public static void main(String[] args) {
		NimSimple g = new NimSimple(30, new int[] {  13 });
		System.out.println(g.game());
	}

}
