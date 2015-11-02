package stringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectLatLng {

	public static void main(String[] args) {
		String str = "^[-+]?(0\\.[0-9]+|([1-9][0-9]*(\\.[0-9]+)?))$";
		Pattern pat = Pattern.compile(str);
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		while (N-- > 0) {
			String s = in.nextLine();
			String[] ss = s.substring(1, s.length() - 1).split(", ");
			boolean valid = true;
			if (ss.length == 2) {
				Matcher mat0 = pat.matcher(ss[0]);
				Matcher mat1 = pat.matcher(ss[1]);
				valid &= mat0.find()
						&& Math.abs(Double.parseDouble(ss[0])) <= 90;
				valid &= mat1.find()
						&& Math.abs(Double.parseDouble(ss[1])) <= 180;
			} else
				valid = false;
			if (valid)
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		}
		in.close();
	}

}
