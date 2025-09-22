package Lab9;

import java.util.Arrays;

public class Lab9_2 {
    public static void main(String[] args) {
        String text = """
                They used 233 features including 227
                stylometric features and six novel social network-specific features
                like character-based ones numbers of alphabets, uppercase
                characters, special characters, word-based ones the total number of
                words, average word length, the number of words with 1 char,
                syntactic ones numbers of punctuation marks and functional
                words, the total number of sentences and many others""";
        String[] words = text.split("[\\s,.?!]+");
        System.out.println(Arrays.toString(words));
        long count=Arrays.stream(words).filter(word->word.matches(".*es")).count();
        System.out.println(count);
        Arrays.sort(words, (word1, word2) -> Integer.compare(word1.length(), word2.length()));
        System.out.println(Arrays.toString(words));
    }
}
