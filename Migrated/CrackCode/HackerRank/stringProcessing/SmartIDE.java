package stringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartIDE {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Pattern pat = Pattern.compile("//.*|(?s)/\\*.*?\\*/");
		StringBuilder sb = new StringBuilder();
		while (in.hasNext())
			sb.append(in.nextLine()).append("\r\n");
		Matcher mat = pat.matcher(sb.toString());
		while (mat.find()) {
			String[] ss = mat.group(0).trim().split("\n");
			for (String str : ss)
				System.out.println(str.trim());
		}
		in.close();
	}
}
