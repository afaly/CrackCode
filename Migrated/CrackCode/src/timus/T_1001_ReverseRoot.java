package timus;

import java.util.Scanner;
import java.util.Stack;

public class T_1001_ReverseRoot {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<Double> vals = new Stack<Double>();
		while (in.hasNextLong()) {
			vals.push(Math.sqrt(in.nextLong()));
		}
		while (!vals.isEmpty())
			System.out.printf("%.4f\n", vals.pop());
		in.close();
	}
}
