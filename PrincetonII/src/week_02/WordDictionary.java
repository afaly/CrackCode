package week_02;

public class WordDictionary {

    class Node {
        Node[] nxt;
        boolean word;

        public Node(int size) {
            this.nxt = new Node[size];
            this.word = false;
        }

        public Node[] next() {
            return nxt;
        }

        public boolean isWord() {
            return word;
        }

        public void setWord() {
            word = true;
        }
    }

    private Node root;
    private final int A = 32;

    public WordDictionary() {
        this.root = new Node(A);
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node itr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (itr.nxt[c - 'a'] == null) itr.nxt[c - 'a'] = new Node(A);
            itr = itr.nxt[c - 'a'];
        }
        itr.setWord();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        Node itr = root;
        return isWord(0, word, itr);
    }

    private boolean isWord(int x, String word, Node itr) {
        if (x == word.length()) return itr.isWord();
        char c = word.charAt(x);
        if (c == '.') {
            boolean valid = false;
            for (int j = 0; j < A && !valid; j++)
                if (itr.nxt[j] != null) valid |= isWord(x + 1, word, itr.nxt[j]);
            return valid;
        } else {
            if (itr.nxt[c - 'a'] == null) return false;
            return isWord(x + 1, word, itr.nxt[c - 'a']);
        }
    }

    public static int reverseBits(long n) {
        long val = 0;
        for (int i = 0; i < 32; i++) {
            val <<= 1;
            val |= (n & 1);
            n >>>= 1;
        }
        return (int) val;
    }

    public static void main(String[] args) {
        /*-
        WordDictionary d = new WordDictionary();
        d.addWord("a");
        d.addWord("ab");
        System.out.println(d.search("a"));
        System.out.println(d.search("a."));
        System.out.println(d.search("ab"));
        System.out.println(d.search(".a"));
        System.out.println(d.search(".b"));
        System.out.println(d.search("ab."));
        System.out.println(d.search("."));
        System.out.println(d.search(".."));
         */
        long n = 2147483648l, v = reverseBits(n);
        System.out.println(n + " -> " + v);
        System.out.println(Long.toBinaryString(n));
        System.out.println(Long.toBinaryString(v));
    }
}