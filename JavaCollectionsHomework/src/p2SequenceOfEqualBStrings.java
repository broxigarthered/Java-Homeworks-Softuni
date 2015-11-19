/**
 * Created by adelinadutskinova on 10/22/15.
 */

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


public class p2SequenceOfEqualBStrings {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine();
        String[] words = line.split(" ");

        LinkedHashMap<String,List<String>> results = Arrays
                .stream(words)
                .collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.toCollection(ArrayList::new)));

        for (List<String> repeatingWords : results.values()) {
            System.out.println(repeatingWords);
        }
    }

}
