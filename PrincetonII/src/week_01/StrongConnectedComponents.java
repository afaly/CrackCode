package week_01;

public class StrongConnectedComponents {

	private int[] mark;

	public StrongConnectedComponents(Digraph G) {
		this.mark = new int[G.V()];

	}

	public boolean isSCC(Integer v, Integer w) {
		return mark[v] == mark[w];
	}

	public Integer SCC(Integer v) {
		return mark[v];
	}

}
