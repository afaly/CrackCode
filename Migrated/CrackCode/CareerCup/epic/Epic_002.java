package epic;

public class Epic_002 {

	public static void Spiral(int[][] n) {
		spiral(n, 0);
	}

	private static void spiral(int[][] n, int lvl) {
		if (lvl >= (n[0].length + 1) / 2) return;
		StringBuilder sb = new StringBuilder();
		for (int i = lvl; i < n.length - lvl; i++)
			sb.append(n[lvl][i]).append(" ");

		for (int j = lvl + 1; j < n.length - lvl; j++)
			sb.append(n[j][(n.length - lvl) - 1]).append(" ");

		for (int i = (n.length - lvl) - 2; i >= lvl; i--)
			sb.append(n[(n.length - lvl) - 1][i]).append(" ");

		for (int j = (n.length - lvl) - 2; j > lvl; j--)
			sb.append(n[j][lvl]).append(" ");

		System.out.println(sb.toString().trim());
		spiral(n, lvl + 1);
	}

	public static void main(String[] args) {
		Spiral(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } });
	}
}
