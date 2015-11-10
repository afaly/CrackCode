package assig_01;

import edu.princeton.cs.algs4.Digraph;

public class DiRoot {

	public static boolean check(Digraph wordnet) {
		int cnt = 0;
		for (Integer node = 0; node < wordnet.V(); node++)
			if (!wordnet.adj(node).iterator().hasNext()) cnt++;
		return cnt == 1;
	}

}
