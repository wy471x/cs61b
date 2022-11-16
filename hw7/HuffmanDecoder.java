import java.util.ArrayList;
import java.util.List;

/**
 * @author wanyong
 * @date 2022/11/15 17:43
 * @desc
 **/
public class HuffmanDecoder {
    private static final Integer FIXED_BITS = 8;

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("number of arguments less than 2.");
        }
        // Read the Huffman coding trie.
        ObjectReader objectReader = new ObjectReader(args[0]);
        BinaryTrie binaryTrie = (BinaryTrie) objectReader.readObject();

        // read the number of symbols.
        Integer numbers = (Integer) objectReader.readObject();

        // Read the massive bit sequence corresponding to the original txt.
        List<Character> symbols = new ArrayList<>();
        BitSequence bitSequence = (BitSequence) objectReader.readObject();
        int step = 0;
        while (step + FIXED_BITS < bitSequence.length()) {
            BitSequence temp = new BitSequence();
            for (int i = step; i < step + FIXED_BITS; i++) {
                temp = temp.appended(bitSequence.bitAt(i));
            }
            Match match = binaryTrie.longestPrefixMatch(temp);
            if (match != null) {
                symbols.add(match.getSymbol());
            }
            step += FIXED_BITS;
        }
        int lastN = bitSequence.length() - step;
        Match match = binaryTrie.longestPrefixMatch(bitSequence.lastNBits(lastN));
        if (match != null) {
            symbols.add(match.getSymbol());
        }
        ObjectWriter objectWriter = new ObjectWriter(args[1]);
        for (Character symbol : symbols) {
            objectWriter.writeObject(symbol);
        }
    }
}
