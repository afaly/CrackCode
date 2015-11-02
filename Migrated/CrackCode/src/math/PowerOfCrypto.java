package math;

import java.util.Scanner;

public class PowerOfCrypto {

	public static long intRoot(int n, double p) {
		return (long) (Math.pow(10, Math.log10(p) / n) + 0.5);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			Integer n = Integer.parseInt(in.nextLine());
			Double p = Double.parseDouble(in.nextLine());
			System.out.println(intRoot(n, p));
		}
		in.close();
	}

}
