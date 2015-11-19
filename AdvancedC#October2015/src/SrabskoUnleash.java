/**
 * Created by adelinadutskinova on 11/2/15.
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleash {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedHashMap<String,LinkedHashMap<String,Integer>> venues = new LinkedHashMap();


        String line = input.nextLine();
        String pat = "([a-zA-Z\\s*]+)\\s@([a-zA-Z\\s*]+)\\s(\\d+)\\s(\\d+)";
        Pattern pattern = Pattern.compile(pat);

        while (!line.equals("End")) {
            Matcher match = pattern.matcher(line);
            while(match.find()) {
                String singer = match.group(1);
                String venue = match.group(2);
                int ticketsPrice = Integer.parseInt(match.group(3));
                int ticketsCount = Integer.parseInt(match.group(4));

                if (!venues.containsKey(venue)) { // checks if map contains the key
                    venues.put(venue, new LinkedHashMap<>());
                }

                Integer oldAmount = venues.get(venue).put(singer,
                        venues.get(venue).get(singer)); // takes the current prize(old price)
                if (oldAmount == null) {
                    oldAmount = 0;
                }

                venues.get(venue).put(singer, oldAmount + (ticketsCount * ticketsPrice)); // addvame
            }
            line = input.nextLine();

        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : venues.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream()
                    .sorted((t1,t2) -> t2.getValue().compareTo(t1.getValue()))
                    .forEach(innerEntry -> System.out.printf("#  %s -> %d\n",innerEntry.getKey(),innerEntry.getValue()));
        }
    }
}