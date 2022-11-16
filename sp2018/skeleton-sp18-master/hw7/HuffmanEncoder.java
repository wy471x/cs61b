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
        char[] chars = FileUtils.readFile(FILE_PATH);
        Map<Character, Integer> characterIntegerMap = buildFrequencyTable(chars);
        BinaryTrie binaryTrie = new BinaryTrie(characterIntegerMap);
        ObjectWriter objectWriter = new ObjectWriter(args[0] + FILE_SUFFIX);
        objectWriter.writeObject(binaryTrie);
        objectWriter.writeObject(chars.length);
        Map<Character, BitSequence> characterBitSequenceMap = binaryTrie.buildLookupTable();
        List<BitSequence> bitSequenceArrayList = new ArrayList<BitSequence>();
        for (int i = 0; i < chars.length; i++) {
            if (characterBitSequenceMap.containsKey(chars[i])) {
                bitSequenceArrayList.add(characterBitSequenceMap.get(chars[i]));
            }
        }
        BitSequence assemble = BitSequence.assemble(bitSequenceArrayList);
        objectWriter.writeObject(assemble);
    }
}
