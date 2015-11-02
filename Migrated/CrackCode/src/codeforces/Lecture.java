package codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] ss = in.nextLine().trim().split(" ");
		int N = Integer.parseInt(ss[0]);
		int M = Integer.parseInt(ss[1]);
		HashMap<String, String> map = new HashMap<>(M);
		while (M-- > 0) {
			ss = in.nextLine().trim().split(" ");
			map.put(ss[0], ss[0].length() <= ss[1].length() ? ss[0] : ss[1]);
		}
		
		ss = in.nextLine().trim().split(" ");
		for(String s : ss){
			System.out.print(map.get(s)  + " ");
		}

		in.close();
	}

}
