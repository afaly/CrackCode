package microsoft;

import java.util.HashMap;

public class Micro_003 {

	public static HashMap<String, Integer> getCount(HashMap<String, String> emp) {
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		for (String s : emp.keySet()) {
			if (!res.containsKey(s)) res.put(s, 0);
			String key = emp.get(s);
			boolean go = !s.equals(key);
			while (go) {
				int val = 0;
				if (res.containsKey(key)) val = res.get(key);
				res.put(key, val + 1);
				if (emp.get(key).equalsIgnoreCase(key)) go = false;
				else
					key = emp.get(key);
			}
		}
		return res;
	}

	public static void main(String[] args) {

		HashMap<String, String> emp = new HashMap<String, String>();
		// { "A","C" },
		// { "B","C" },
		// { "C","F" },
		// { "D","E" },
		// { "E","F" },
		// { "F","F" }

		emp.put("a", "c");
		emp.put("b", "c");
		emp.put("c", "f");
		emp.put("d", "e");
		emp.put("e", "f");
		emp.put("f", "g");
		emp.put("j", "a");
		emp.put("g", "g");
		HashMap<String, Integer> res = getCount(emp);
		for (String key : res.keySet()) {
			System.out.println(key + " : " + res.get(key));
		}
	}
}
