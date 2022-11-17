import java.util.ArrayList;
import java.util.List;

/**
 * @author wanyong
 * @date 2022/11/15 17:43
 * @desc
 **/
public class HuffmanDecoder {
    private static final Integer FIXED_BITS = 8;

    private static Integer numbers;

    private static BinaryTrie binaryTrie;

    private static BitSequence bitSequence;

    private static char[] chars;

    public Integer getNumbers() {
        return numbers;
    }

    public static char[] getChars() {
        return chars;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public BinaryTrie getBinaryTrie() {
        return binaryTrie;
    }

    public void setBinaryTrie(BinaryTrie binaryTrie) {
        this.binaryTrie = binaryTrie;
    }

    public BitSequence getBitSequence() {
        return bitSequence;
    }

    public void setBitSequence(BitSequence bitSequence) {
        this.bitSequence = bitSequence;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("number of arguments less than 2.");
        }
        // Read the Huffman coding trie.
        ObjectReader objectReader = new ObjectReader(args[0]);
        binaryTrie = (BinaryTrie) objectReader.readObject();

        // read the number of symbols.
        numbers = (Integer) objectReader.readObject();

        // Read the massive bit sequence corresponding to the original txt.
        chars = new char[numbers];
        int k = 0;
        bitSequence = (BitSequence) objectReader.readObject();

        // Repeat until there are no more symbols:
        //    4a: Perform a longest prefix match on the massive sequence.
        //    4b: Record the symbol in some data structure.
        //    4c: Create a new bit sequence containing the remaining unmatched bits.
        BitSequence temp = new BitSequence(bitSequence);
        while (temp.length() > 0) {
            Match match = binaryTrie.longestPrefixMatch(temp);
            if (match != null) {
                chars[k++] = match.getSymbol();
                temp = new BitSequence(temp.allButFirstNBits(match.getSequence().length()));
            }
        }
        // Write the symbols in some data structure to the specified file.
        FileUtils.writeCharArray(args[1], chars);
    }
}
