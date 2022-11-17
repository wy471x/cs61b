import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanyong
 * @date 2022/11/15 17:42
 * @desc
 **/
public class HuffmanEncoder {

    private static final String FILE_PATH = "watermelonsugar.txt";
    private static final String FILE_SUFFIX = ".huf";

    private static Integer numbers;

    public char[] getChars() {
        return chars;
    }

    private static BinaryTrie binaryTrie;

    private static BitSequence bitSequence;

    private static char[] chars;

    public Integer getNumbers() {
        return numbers;
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

    public static Map<Character, Integer> buildFrequencyTable(char[] inputSymbols) {
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < inputSymbols.length; i++) {
            table.put(inputSymbols[i], table.getOrDefault(inputSymbols[i], 0) + 1);
        }
        return table;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("number of arguments less than 1.");
        }
        // Read the file as 8 bit symbols
        chars = FileUtils.readFile(FILE_PATH);
        // Build frequency table
        Map<Character, Integer> characterIntegerMap = buildFrequencyTable(chars);
        // Use frequency table to construct a binary decoding trie
        binaryTrie = new BinaryTrie(characterIntegerMap);
        ObjectWriter objectWriter = new ObjectWriter(args[0] + FILE_SUFFIX);
        // Write the binary decoding trie to the .huf file
        objectWriter.writeObject(binaryTrie);
        // write the number of symbols to the .huf file
        numbers = chars.length;
        objectWriter.writeObject(numbers);
        // Use binary trie to create lookup table for encoding
        Map<Character, BitSequence> characterBitSequenceMap = binaryTrie.buildLookupTable();
        // Create a list of bitsequences
        List<BitSequence> bitSequenceArrayList = new ArrayList<BitSequence>();
        // For each 8 bit symbol:
        //    Lookup that symbol in the lookup table.
        //    Add the appropriate bit sequence to the list of bitsequences.
        for (int i = 0; i < chars.length; i++) {
            if (characterBitSequenceMap.containsKey(chars[i])) {
                bitSequenceArrayList.add(characterBitSequenceMap.get(chars[i]));
            }
        }
        // Assemble all bit sequences into one huge bit sequence
        bitSequence = BitSequence.assemble(bitSequenceArrayList);
        // Write the huge bit sequence to the .huf file
        objectWriter.writeObject(bitSequence);
    }
}
