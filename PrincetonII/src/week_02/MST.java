package week_02;

import week_01.Edge;

public interface MST {

    public Iterable<Edge> edges();

    public double weight();

    public int trees();
}
