package bloomberg;

import java.util.ArrayList;
import java.util.HashMap;

public class Bloom_004 {

	public static ArrayList<String> airPortPath(ArrayList<String> l) {
		if (l.size() % 2 == 1) return null;
		ArrayList<String> route = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, Boolean> flg = new HashMap<String, Boolean>();
		for (int i = 0; i < l.size(); i += 2) {
			map.put(l.get(i), l.get(i + 1));
			flg.put(l.get(i + 1), true);
			if (!flg.containsKey(l.get(i))) flg.put(l.get(i), false);
		}
		String source = null;
		for (String s : flg.keySet())
			if (!flg.get(s)) {
				source = s;
				break;
			}
		while (map.containsKey(source)) {
			route.add(source);
			source = map.get(source);
		}
		route.add(source);
		return route;
	}

	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("JFK");
		l.add("LXA");
		l.add("SNA");
		l.add("RKJ");
		l.add("LXA");
		l.add("SNA");
		System.out.println(airPortPath(l));
	}

}
