/**
 * Created by adelinadutskinova on 11/10/15.
 */
import apple.laf.JRSUIUtils;

import java.util.*;

public class OlympicsAreComing {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // country - participants - wins
        String line = input.nextLine();

        TreeMap<String, Integer> winz = new TreeMap<>();
        LinkedHashMap<String, List<String>> participants = new LinkedHashMap<>();
        LinkedHashMap<String,TreeMap<Integer,Integer>> omg = new LinkedHashMap<>();
        //LinkedHashMap<String, Integer> participantsCount = new LinkedHashMap<>();

        while(!line.equals("report")){
            String[]tokens = line.split("\\s*\\|\\s*");
            String n = tokens[0];
            String name = n.replaceAll("\\s{2,}"," ").trim();
            String c= tokens[1];
            String country = c.replaceAll("\\s{2,}"," ").trim();



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
        LinkedHashMap<String, TreeMap<String ,Integer>> res = new LinkedHashMap<>();



        for (Map.Entry<String, Integer> entry : winz.entrySet()) {


            System.out.printf("%s (%d participants): %d wins \r\n",
                    entry.getKey(),
                    participants.get(entry.getKey()).size(),
                    winz.get(entry.getKey())

            );
        }

    }
}
