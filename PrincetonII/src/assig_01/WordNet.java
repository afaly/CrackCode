package assig_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

//All methods and the constructor should throw a java.lang.NullPointerException if any argument is null
public class WordNet {

	private Map<String, Integer> nounsMap;
	private List<String> revNounMap;
	private Digraph wordnet;
	private Integer numOfSynsets;

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		if (synsets == null) throw new NullPointerException(
				"Synsets cann't be Null.");
		if (hypernyms == null) throw new NullPointerException(
				"Hypernyms cann't be Null.");

		nounsMap = new HashMap<String, Integer>();
		revNounMap = new ArrayList<String>();
		numOfSynsets = readSynsets(synsets);
		wordnet = new Digraph(numOfSynsets);
		readHypernyms(hypernyms);
	}

	private Integer readSynsets(String synsets) {
		In read = new In(synsets);
		Integer numOfSynsets = 0;
		while (read.hasNextLine()) {
			String[] data = read.readLine().split(",");
			Integer id = Integer.parseInt(data[0]);
			revNounMap.add(data[1]);
			String[] synset = data[1].split("\\s+");
			for (String noun : synset)
				nounsMap.put(noun, id);
			numOfSynsets++;
		}

		return numOfSynsets;
	}

	private void readHypernyms(String hypernyms) {
		In read = new In(hypernyms);
		while (read.hasNextLine()) {
			String[] data = read.readLine().split(",");
			Integer src = Integer.parseInt(data[0]), dst;
			for (int i = 1; i < data.length; i++) {
				dst = Integer.parseInt(data[i]);
				wordnet.addEdge(src, dst);
			}
		}
	}

	// returns all WordNet nouns
	public Iterable<String> nouns() {
		return nounsMap.keySet();
	}

	// is the word a WordNet noun?
	public boolean isNoun(String word) {
		if (word == null) throw new NullPointerException(
				"Search Word cann't be Null.");
		return nounsMap.containsKey(word);
	}

	// distance between nounA and nounB (defined below)
	public int distance(String nounA, String nounB) {
		if (nounA == null) throw new NullPointerException(
				"First noun cann't be Null.");
		if (nounB == null) throw new NullPointerException(
				"Second noun cann't be Null.");
		if (!isNoun(nounA)) throw new IllegalArgumentException(
				"First String is not a valid noun.");
		if (!isNoun(nounB)) throw new IllegalArgumentException(
				"Second String is not a valid noun.");
		return new SAP(wordnet)
				.length(nounsMap.get(nounA), nounsMap.get(nounB));
	}

	// a synset (second field of synsets.txt) that is the common ancestor of
	// nounA and nounB
	// in a shortest ancestral path (defined below)
	public String sap(String nounA, String nounB) {
		if (nounA == null) throw new NullPointerException(
				"First noun cann't be Null.");
		if (nounB == null) throw new NullPointerException(
				"Second noun cann't be Null.");
		if (!isNoun(nounA)) throw new IllegalArgumentException(
				"First String is not a valid noun.");
		if (!isNoun(nounB)) throw new IllegalArgumentException(
				"Second String is not a valid noun.");
		return revNounMap.get(new SAP(wordnet).ancestor(nounsMap.get(nounA),
				nounsMap.get(nounB)));
	}

	// do unit testing of this class
	public static void main(String[] args) {
		String s = "wordnet/synsets100-subgraph.txt";
		String h = "wordnet/hypernyms100-subgraph.txt";
		WordNet w = new WordNet(s, h);
		for (String n : w.nouns()) {
			for (String m : w.nouns()) {
				int dist = w.distance(n, m);
				String prnt = w.sap(n, m);
				System.out.println("|" + n + " - " + m + "| = " + dist
						+ "\t\t " + prnt);
			}
		}
	}
}