package AdInf10;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split(" ");
		int L = Integer.parseInt(s[0]);
		int S1 = Integer.parseInt(s[1]);
		int S2 = Integer.parseInt(s[2]);
		double V = Math.abs(S2 - S1);
		double C = Math.sqrt(2) * L;
		int Q = Integer.parseInt(in.nextLine());
		while (Q-- > 0) {
			long q = Long.parseLong(in.nextLine());
			double dq = Math.sqrt(2.0*q);
			double r = (C - dq) / V;
			System.out.println(r);
		}
		in.close();
	}
}
