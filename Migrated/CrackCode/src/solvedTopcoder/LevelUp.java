package solvedTopcoder;
public class LevelUp {
	public int toNextLevel(int[] expNeeded, int received) {
		for (int i = 0;; i++) {
			if (expNeeded[i] > received) {
				return expNeeded[i] - received;
			}
		}
	}
}
