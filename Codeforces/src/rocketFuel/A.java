package rocketFuel;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().trim().split(" ");
		int n1 = Integer.parseInt(ss[0]);
		int n2 = Integer.parseInt(ss[1]);
		if (n2 >= n1)
			System.out.println("Second");
		else
			System.out.println("First");

		in.close();
	}
}
