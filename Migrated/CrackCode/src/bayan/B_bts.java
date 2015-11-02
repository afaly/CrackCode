package bayan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class B_bts {

	public static String[] readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded).replaceAll("[^a-zA-Z ]", "").toLowerCase()
				.split("\\s+");
	}

	public static void main(String[] args) {
		try {
			String[] xs, ss;
			String[] sin = readFile("swift/input.txt");
			String[] sjn = readFile("swift/output.txt");
			int siz1 = sin.length;
			int siz2 = sjn.length;

			int dif = Math.abs(siz1 - siz2);
			int min = Math.min(siz1, siz2);
			System.out.println("Diff: " + dif);
			if (siz1 > siz2) {
				xs = sin;
				ss = sjn;
			} else {
				xs = sjn;
				ss = sin;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < min; i++) {
				boolean cont = true;
				for (int j = 0; j < dif && cont; j++) {
					cont = !ss[i].equals(xs[i + j]);
				}
				if (cont) {
					sb.delete(0, sb.length());
					sb.append(ss[i]).append(" -> ");
					for (int j = 0; j < dif; j++) {
						sb.append(" ").append(xs[i + j]);
					}
					System.out.println(sb.toString());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
