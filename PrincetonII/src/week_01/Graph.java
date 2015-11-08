package week_01;

public interface Graph {

	public int V();

	public int E();

	public void addEdge(int src, int dst);

	public void addEdge(int src, int dst, double val);

	public Iterable<Edge> adj(int src);

	public int InDegree(int src);

	public int OutDegree(int src);

}
