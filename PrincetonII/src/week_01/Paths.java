package week_01;

public interface Paths {

	public boolean hasPathTo(Integer dst);

	public Iterable<Integer> getPathTo(Integer dst);
}
