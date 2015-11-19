/**
 * Created by adelinadutskinova on 11/14/15.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine();
        String pat = "([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(pat);
        Matcher match = pattern.matcher(line);
        String endKey = "";
        String startKey = "";
        double totalSum = 0;
        boolean noNumberFound = true;
        boolean noKeyIsFound = false;

        //finds the firstKey
        if(match.find()){
            startKey = match.group(match.groupCount());
        }
        //finds he endKey
        while(match.find()){
            endKey = match.group(1);
        }

        //check if any of the keys are missing
        if(endKey.equals("") || startKey.equals("")){
            System.out.println("<p>A key is missing</p>");
            return;
        }

        //Main logic
        //reads the secondLine
        line = input.nextLine();
        String realPattern = startKey+"(.*?)"+endKey;
        Pattern pattern1 = Pattern.compile(realPattern);
        Matcher match1 = pattern1.matcher(line);
        while(match1.find()){
            if(tryParseDouble(match1.group(1))){
                totalSum += Double.parseDouble(match1.group(1));
                noNumberFound = false;
            }
        }


        if(noNumberFound){
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }

        else{
            System.out.printf("<p>The total value is: <em>%.2f</em></p>", totalSum);
        }


    }
    private static boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
