/**
 * Created by adelinadutskinova on 11/13/15.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheNumbers {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String finalResult = "";

        String line = input.nextLine();
        String pat = "(\\d+)";
        Pattern pattern = Pattern.compile(pat);
        Matcher match = pattern.matcher(line);

        while(match.find()){
            numbers.add(Integer.parseInt(match.group(1)));
        }

        //saving the numbers as hexDecimal
        List<String> strHex = new ArrayList<String>(numbers.size());
        for (Integer myInt : numbers) {
            strHex.add(Integer.toHexString(myInt).toUpperCase());
        }

        //check if their length is less than 4
        for (int i = 0; i < strHex.size(); i++) {
                //String currentNumber = String.format("%04s", Integer.parseInt(strHex.get(i)));
                String currentNumber = String.format("%4s", strHex.get(i)).replace(' ', '0');
                result.add("0x"+ currentNumber);
        }

        //print the result
        for (int i = 0; i < result.size(); i++) {
            String currentS = result.get(i);
            finalResult+=currentS+"-";
        }
        System.out.println(finalResult.substring(0,finalResult.length()-1));
    }

}
