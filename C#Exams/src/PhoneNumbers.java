/**
 * Created by adelinadutskinova on 11/14/15.
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String line = input.nextLine();
        String pat = "([A-Z][a-zA-Z]*)[^a-zA-Z\\+]*?(?=\\+|[0-9]{2})([0-9\\+]{0,1}[0-9][0-9\\/(). -]*[0-9])";
        LinkedHashMap<String,String> phoneBook = new LinkedHashMap<>();

        boolean found  = false;

        while(!line.equals("END")) {
            Pattern pattern = Pattern.compile(pat);
            Matcher match = pattern.matcher(line);

            while (match.find()){
                String name = match.group(1);
                String number = match.group(2);
                found = true;

                number = number.replace("(","");
                number = number.replace(")","");
                number = number.replace(".","");
                number = number.replace("/","");
                number = number.replace("-","");
                number = number.replace(" ","");
                phoneBook.put(name,number);
            }
            if(!found){
                System.out.println("<p>No matches!</p>");
                return;
            }

            line = input.nextLine();
        }

        String result = "<ol>";
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            result += String.format("<li><b>%s:</b> %s</li>",entry.getKey(),
                    entry.getValue());
        }
        result = result.substring(0, result.length()) + "</ol>";
        System.out.println(result);
    }
}
