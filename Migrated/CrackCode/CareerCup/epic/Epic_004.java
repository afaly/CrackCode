package epic;

import java.util.Stack;

public class Epic_004 {

	public static boolean Balanced(String s) {
		Stack<Character> st = new Stack<Character>();
		char[] c = s.toCharArray();
		for (char a : c) {
			if (a == '(' || a == '{' || a == '[') st.push(a);
			else if ((a == ')' || a == '}' || a == ']')) {
				if (st.isEmpty()) return false;
				char t = st.pop();
				if (a == '(' && t != ')') return false;
				if (a == '{' && t != '}') return false;
				if (a == '[' && t != ']') return false;
			}
		}
		return st.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(Balanced("(a{A}b[c]"));
	}

}
