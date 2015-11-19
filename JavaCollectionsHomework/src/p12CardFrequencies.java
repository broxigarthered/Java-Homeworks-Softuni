/**
 * Created by adelinadutskinova on 10/24/15.
 */

import java.util.*;

public class p12CardFrequencies {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedHashMap<String,Double> map = new LinkedHashMap<String,Double>();

        String line = input.nextLine();
        String[] words = line.split("\\W+");

        for (String word : words) {
            if(!map.containsKey(word)){   /// ako mapa ne cointainva keya da go addne
                map.put(word, null);
            }



            Double wordCount = map.get(word); // vzima value-to na opredelena duma
            if(wordCount == null){            // Ako value-to e null da go vzemem kato 0 vuv promenliva, koqto posle 6te q butnem kato value
                wordCount = 0d;
            }

            map.put(word,wordCount+=100);
        }


        map.entrySet();
        for (Map.Entry<String,Double> entry : map.entrySet()) {
            double value = entry.getValue() / words.length;

            System.out.printf("%s -> %.2f%"+"% %n",entry.getKey(), value);
        }

    }
}
