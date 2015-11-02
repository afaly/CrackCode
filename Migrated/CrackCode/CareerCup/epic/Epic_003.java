package epic;
import java.util.ArrayList;

public class Epic_003 {

	public static final int N = 1000001, M = 4;

	public static void Mingo(int[][] v, ArrayList<Integer> l) {
		int[] x = new int[N], y = new int[N];
		int dl = 0, dr = 0;
		int[] r = new int[M], c = new int[M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				x[v[i][j]] = i;
				y[v[i][j]] = j;
				c[j] ^= v[i][j];
				r[i] ^= v[i][j];
				if (i - j == 0) dl ^= v[i][j];
				if (i + j == M) dr ^= v[i][j];
			}
		}

		for (int k : l) {
			int i = x[k], j = y[k];
			r[i] ^= k;
			c[j] ^= k;
			if (i - j == 0) dl ^= v[i][j];
			if (i + j == M) dr ^= v[i][j];
			System.out.println("Played : " + k);
			if (c[j] == 0 || r[i] == 0 || dl == 0 || dr == 0) {
				System.out.println("Mingo");
			}
		}
	}

	public static void main(String[] args) {
		int[][] m = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		ArrayList<Integer> l = new ArrayList<>();
		l.add(3);
		l.add(9);
		l.add(11);
		l.add(2);
		l.add(5);
		l.add(6);
		l.add(16);
		l.add(4);
		l.add(13);
		l.add(10);
		l.add(7);
		l.add(1);

		Mingo(m, l);
	}

}
