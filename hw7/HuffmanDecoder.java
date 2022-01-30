import java.util.ArrayList;

/**
 * @author daisy
 * @description
 * @create 2022-01-30-14:20
 */
public class HuffmanDecoder {
    public static void main(String[] args) {
        /*
        String readFile = args[0];
        String writeFile = args[1];
        ObjectReader objectReader = new ObjectReader(readFile);
        BinaryTrie trie = (BinaryTrie) objectReader.readObject();
        BitSequence hugeSequence = (BitSequence) objectReader.readObject();

        List<Character> decodes = new ArrayList<>();
        while (hugeSequence.length() != 0) {
            Match m = trie.longestPrefixMatch(hugeSequence);
            decodes.add(m.getSymbol());
            hugeSequence.allButFirstNBits(m.getSequence().length());
        }
        char[] res = new char[decodes.size()];
        for (int i = 0; i < decodes.size(); i++) {
            res[i] = decodes.get(i);
        }
        FileUtils.writeCharArray(writeFile, res);
*/
        String readFile = args[0];
        String writeFile = args[1];

        ObjectReader objectReader = new ObjectReader(readFile);
        BinaryTrie trie = (BinaryTrie) objectReader.readObject();
        BitSequence hugeSequence = (BitSequence) objectReader.readObject();
        ArrayList<Character> symbols = new ArrayList<>();
        while (hugeSequence.length() != 0) {
            Match m = trie.longestPrefixMatch(hugeSequence);
            symbols.add(m.getSymbol());
            hugeSequence = hugeSequence.allButFirstNBits(m.getSequence().length());
        }
        char[] chars = new char[symbols.size()];
        for (int i = 0; i < symbols.size(); i++) {
            chars[i] = symbols.get(i);
        }
        FileUtils.writeCharArray(writeFile, chars);
    }
}
