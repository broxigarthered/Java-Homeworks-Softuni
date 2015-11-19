/**
 * Created by adelinadutskinova on 11/2/15.
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShmoogleCounter {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String line = input.nextLine();
        String pat = "\\bint\\s*([a-z]\\w*)\\b";
        String pat2 = "\\bdouble\\s*([a-z]\\w*)\\b";
        Pattern patternInt = Pattern.compile(pat);
        Pattern patternDouble = Pattern.compile(pat2);
        List<String> intList = new ArrayList<>();
        List<String> doubleList = new ArrayList<>();
        String resultInts = "";
        String resulDoubles = "";



        while(!line.equals("//END_OF_CODE")){

            Matcher matchInts = patternInt.matcher(line);
            Matcher matchDoubles = patternDouble.matcher(line);

            while(matchInts.find()){
                String variable = matchInts.group(1);
                intList.add(variable);
            }

            while(matchDoubles.find()){
                String variable = matchDoubles.group(1);
                doubleList.add(variable);
            }
            line = input.nextLine();
        }
        intList.removeAll(Arrays.asList("", null));
        java.util.Collections.sort(intList);
        doubleList.removeAll(Arrays.asList("",null));
        java.util.Collections.sort(doubleList);

        for (String i : intList) {resultInts+=i+", ";}
        for (String d : doubleList) {resulDoubles+=d+", ";}

        if(doubleList.isEmpty()){
            System.out.println("Doubles: None");
        } else System.out.println("Doubles: "+resulDoubles.substring(0,resulDoubles.length()-2));

        if(intList.isEmpty()){
            System.out.println("Ints: None");
        } else  System.out.println("Ints: "+resultInts.substring(0,resultInts.length()-2));



    }
}
