/**
 * Created by adelinadutskinova on 11/10/15.
 */
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.stream.Stream;

public class OlympicsTest {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // country - participants - wins
        String line = input.nextLine();

        LinkedHashMap<String, Integer> winz = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> participants = new LinkedHashMap<>();
        while (!line.equals("report")) {
            String[] tokens = line.split("\\s*\\|\\s*");
            String n = tokens[0];
            String name = n.replaceAll("\\s{2,}", " ").trim();
            String c = tokens[1];
            String country = c.replaceAll("\\s{2,}", " ").trim();

            List<String> oldNames = participants.get(country);

            //TODO check if null
            if(oldNames == null){
                participants.put(country,new ArrayList<>());
            }

            if (!participants.get(country).contains(name)) {
                participants.get(country).add(name);
            }

            Integer oldWins = winz.get(country);
            if(oldWins == null){
                oldWins = 0;
            }
            winz.put(country, oldWins+1);

            line = input.nextLine();
    }
            winz.entrySet().stream()
                    .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                    .forEach(k -> System.out.printf("%s (%d participants): %d wins\r\n",
                            k.getKey(),
                            participants.get(k.getKey()).size(),
                            k.getValue()
                    ));

        }
}
