package solvedTopcoder;
public class MagicSquare {
	public int missing(int[] square) {
		int pos;
		for (int i = 0;; i++) {
			if (square[i] == -1) {
				pos = i;
				break;
			}
		}
		int currentRow = pos / 3;
		int nextRow = (currentRow + 1) % 3;
		return rowSum(square, nextRow) - rowSum(square, currentRow) - 1;
	}

	int rowSum(int square[], int row) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += square[row * 3 + i];
		}
		return sum;
	}
}
