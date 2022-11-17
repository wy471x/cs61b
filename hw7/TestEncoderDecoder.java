import org.junit.Assert;
import org.junit.Test;

/**
 * @author wanyong
 * @date 2022/11/17 16:44
 * @desc
 **/
public class TestEncoderDecoder {

    private static HuffmanEncoder huffmanEncoder = new HuffmanEncoder();

    private static HuffmanDecoder huffmanDecoder = new HuffmanDecoder();

    @Test
    public void test1() {
        String[] args1 = new String[]{"watermelonsugar.txt"};
        huffmanEncoder.main(args1);
        String[] args2 = new String[]{"watermelonsugar.txt.huf", "originalwatermelon.txt"};
        huffmanDecoder.main(args2);
        Integer number1 = huffmanEncoder.getNumbers();
        Integer numbers2 = huffmanDecoder.getNumbers();
        Assert.assertEquals(number1, numbers2);
        BinaryTrie binaryTrie1 = huffmanEncoder.getBinaryTrie();
        BinaryTrie binaryTrie2 = huffmanDecoder.getBinaryTrie();
        Assert.assertEquals(true, checkTwoBinaryTrieEquality(binaryTrie1, binaryTrie2));
        BitSequence bitSequence1 = huffmanEncoder.getBitSequence();
        BitSequence bitSequence2 = huffmanDecoder.getBitSequence();
        Assert.assertEquals(true, checkTwoBitSequenceEquality(bitSequence1, bitSequence2));

        char[] chars1 = huffmanEncoder.getChars();
        char[] chars2 = huffmanDecoder.getChars();
        Assert.assertEquals(true, checkTwoCharsEquality(chars1, chars2));

    }

    public boolean checkTwoCharsEquality(char[] encoder, char[] decoder) {
        for (int i = 0; i < encoder.length; i++) {
            if (encoder[i] != decoder[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkTwoBitSequenceEquality(BitSequence encoder, BitSequence decoder) {
        return encoder.toString().equals(decoder.toString());
    }

    public boolean checkTwoBinaryTrieEquality(BinaryTrie encoder, BinaryTrie decoder) {
        BinaryTrie.Node root1 = encoder.getRoot();
        BinaryTrie.Node root2 = decoder.getRoot();

        return helper(root1, root2);
    }

    public boolean helper(BinaryTrie.Node node1, BinaryTrie.Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.getCh() != node2.getCh()
        && node1.getFreq() != node2.getFreq()) {
            return false;
        }

        return helper(node1.getLeft(), node2.getLeft())
                && helper(node1.getRight(), node2.getRight());
    }
}
