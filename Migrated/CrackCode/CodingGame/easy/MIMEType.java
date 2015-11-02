package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MIMEType {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // Number of elements which make up the
								// association table.
		in.nextLine();
		int Q = in.nextInt(); // Number Q of file names to be analyzed.
		in.nextLine();
		Map<String, String> map = new HashMap<String, String>(N);
		for (int i = 0; i < N; i++) {
			String EXT = in.next(); // file extension
			String MT = in.next(); // MIME type.
			map.put(EXT.toLowerCase(), MT);
			in.nextLine();
		}
		for (int i = 0; i < Q; i++) {
			String FNAME = in.nextLine(); // One file name per line.
			if (!FNAME.contains(".") || FNAME.split("\\.").length < 2
					|| FNAME.charAt(FNAME.length() - 1) == '.') {
				System.out.println("UNKNOWN");
			} else {
				String[] parsed = FNAME.split("\\.");
				String search = parsed[parsed.length - 1].toLowerCase();
				if (map.containsKey(search)) {
					System.out.println(map.get(search));
				} else {
					System.out.println("UNKNOWN");
				}
			}
		}
		in.close();
	}
}
