package assig_01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    private final WordNet wordnet;

    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    public String outcast(String[] nouns) {
        int N = nouns.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int dist_ij = wordnet.distance(nouns[i], nouns[j]);
                dists[i] += dist_ij;
                dists[j] += dist_ij;
            }
        }
        int maxIdx = 0;
        for (int itr = 1; itr < N; itr++)
            if (dists[itr] > dists[maxIdx]) maxIdx = itr;
        return nouns[maxIdx];
    }

    public static void main(String[] args) {
        String[] a = { "synsets.txt", "hypernyms.txt", "outcast5.txt",
                "outcast8.txt", "outcast11.txt" };
        WordNet wordnet = new WordNet("wordnet/" + a[0], "wordnet/" + a[1]);
        Outcast outcast = new Outcast(wordnet);
        System.out.println("-----------------------");
        for (int t = 2; t < a.length; t++) {
            In in = new In("wordnet/" + a[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(a[t] + ": " + outcast.outcast(nouns));
        }
    }
}