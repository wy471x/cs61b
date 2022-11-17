import edu.princeton.cs.algs4.MinPQ;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanyong
 * @date 2022/11/15 17:27
 * @desc
 **/
public class BinaryTrie implements Serializable {

    private Node root;

    private Map<Character, BitSequence> table;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTrie(Map<Character, Integer> frequencyTable) {
        root = buildTrie(frequencyTable);
        table = buildLookupTable();
    }

    // build the Huffman trie given frequencies
    private static Node buildTrie(Map<Character, Integer> frequencyTable) {
        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<>();
        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            if (entry.getValue() > 0) {
                pq.insert(new Node(entry.getKey(), entry.getValue(), null, null));
            }
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            BinaryTrie.Node left  = pq.delMin();
            BinaryTrie.Node right = pq.delMin();
            BinaryTrie.Node parent = new BinaryTrie.Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    // match longest prefix
    public Match longestPrefixMatch(BitSequence querySequence) {
        for (Map.Entry<Character, BitSequence> entry : table.entrySet()) {
            if (checkSequenceEquality(querySequence, entry.getValue())) {
                return new Match(entry.getValue(), entry.getKey());
            }
        }
        return null;
    }

    // check two bit sequence equality
    private boolean checkSequenceEquality(BitSequence querySequence, BitSequence source) {
        for (int i = 1; i <= querySequence.length(); i++) {
            if (querySequence.firstNBits(i).equals(source)) {
                return true;
            }
        }
        return false;
    }

    // build lookup table
    public Map<Character, BitSequence> buildLookupTable() {
        Map<Character, BitSequence> table = new HashMap<>();
        buildCode(table, root, new BitSequence());
        return table;
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(Map<Character, BitSequence> table, Node x, BitSequence s) {
        if (!x.isLeaf()) {
            buildCode(table, x.left, s.appended(0));
            buildCode(table, x.right, s.appended(1));
        } else {
            table.put(x.ch, s);
        }
    }

    // Huffman trie node
    public static class Node implements Comparable<BinaryTrie.Node>, Serializable {
        private final char ch;
        private final int freq;
        private final BinaryTrie.Node left, right;

        public char getCh() {
            return ch;
        }

        public int getFreq() {
            return freq;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        Node(char ch, int freq, BinaryTrie.Node left, BinaryTrie.Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        @Override
        public int compareTo(BinaryTrie.Node that) {
            return this.freq - that.freq;
        }
    }
}
