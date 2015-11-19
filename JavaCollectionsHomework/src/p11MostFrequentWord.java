/**
 * Created by adelinadutskinova on 10/23/15.
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class p11MostFrequentWord {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine().toLowerCase();
        String[] words = line.split("\\W\\s*");

        TreeMap<String,Integer> wordOccurrences = new TreeMap<>();
        int maxWordCount = 0;  // nai-golemiq count

        for (String word : words) { // za vsqka duma

            Integer wordCount = wordOccurrences.get(word);
            if (wordCount == null) {
                wordCount = 0;
            }


            if (wordCount + 1 > maxWordCount) maxWordCount = wordCount + 1;
            wordOccurrences.put(word, wordCount + 1);
        }

        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            if (entry.getValue() == maxWordCount) {
                System.out.println(entry.getKey() + " -> "
                        + maxWordCount + " times");
            }

        }




    }

}

