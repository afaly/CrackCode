package week_02;

public class UF {

    private int[] mark, rank;
    private int cnt, sz;

    public UF(int size) {
        this.sz = size;
        this.mark = new int[sz];
        this.rank = new int[sz];
        for (int i = 0; i < sz; i++)
            mark[i] = i;
        this.cnt = sz;
    }

    public int count() {
        return cnt;
    }

    public int find(int i) {
        return mark[i] != i ? mark[i] = find(i) : mark[i];
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        int pi = find(i), pj = find(j);
        if (pi != pj) {
            if (rank[i] > rank[j]) mark[j] = pi;
            else if (rank[i] < rank[j]) mark[i] = pj;
            else {
                rank[i]++;
                mark[j] = pi;
            }
            cnt--;
        }
    }
}
