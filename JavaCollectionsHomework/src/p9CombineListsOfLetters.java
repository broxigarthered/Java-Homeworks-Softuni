/**
 * Created by adelinadutskinova on 10/22/15.
 */

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class p9CombineListsOfLetters {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Character> l1 = new ArrayList<>();
        ArrayList<Character> l2 = new ArrayList<>();

        for (char c : input.nextLine().replaceAll("\\s+", "").toCharArray()) {
            l1.add(c);
        }


        for (char c : input.nextLine().replaceAll("\\s+", "").toCharArray()) {
            l2.add(c);
        }


        l2.removeAll(l1);
        l1.addAll(l2);

        for (char c : l1) {
            System.out.print(c + " ");
        }

    }


}
