/**
 * Created by adelinadutskinova on 10/20/15.
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleash {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String pattern = "([a-zA-Z\\s*]+)\\s@([a-zA-Z\\s*]+)\\s(\\d+)\\s(\\d+)";

        Pattern pattern1 = Pattern.compile(pattern);


        String line = input.nextLine();


        LinkedHashMap<String, LinkedHashMap<String,Integer>> venues =
                new LinkedHashMap<>();

        while(!line.equals("End")){

            Matcher matcher = pattern1.matcher(line);
            if(matcher.find()){
                String singer = matcher.group(1);
                String venue = matcher.group(2);
                int ticketsPrice = Integer.parseInt(matcher.group(3));
                int ticketsCount = Integer.parseInt(matcher.group(4));

                if(!venues.containsKey(venue)){
                    venues.put(venue, new LinkedHashMap<String, Integer>());
                }

                if(venues.get(venue).containsValue(singer)){
                    venues.get(venue).put(singer,0);
                }

                venues.get(venue).put(singer,
                        venues.get(venue).get(singer) + (ticketsCount*ticketsPrice)
                );

                //venues.get(venue).put(singer, ticketsCount*ticketsPrice);
            }
            line = input.nextLine();
        }

        for(Map.Entry<String, LinkedHashMap<String,Integer>> entry: venues.entrySet()){
            System.out.println(entry.getKey());

            entry.getValue().entrySet().stream().sorted((t1,t2) -> t2.getValue().compareTo(t1.getValue()))
            .forEach(innerEntry -> System.out.printf("#  %s -> %d\n",innerEntry.getKey(),innerEntry.getValue()));

            //vzimame vtorata karta i q obrabotvame
            //entry.get value e vtoriq hashset

        }

    }
}
