package week_01;

public class Edge {

    private final int src, dst;
    private final double val;

    public Edge(int src, int dst) {
        this.src = src;
        this.dst = dst;
        this.val = 0.0;
    }

    public Edge(int src, int dst, double val) {
        this.src = src;
        this.dst = dst;
        this.val = val;
    }

    public int dst() {
        return dst;
    }

    public int src() {
        return src;
    }

    public int either() {
        return src;
    }

    public int other(int v) {
        return v == src ? dst : src;
    }

    public double val() {
        return val;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dst;
        long temp;
        temp = Double.doubleToLongBits(val);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Edge)) return false;
        Edge other = (Edge) obj;
        if (dst != other.dst) return false;
        if (Double.doubleToLongBits(val) != Double.doubleToLongBits(other.val)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [" + src + " -> " + dst + "= " + val + "]";
    }

}
