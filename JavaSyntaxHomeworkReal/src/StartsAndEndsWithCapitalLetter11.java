/**
 * Created by adelinadutskinova on 10/15/15.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartsAndEndsWithCapitalLetter11 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine();

        Pattern regex = Pattern.compile("\\b([A-Z][A-Za-z]*[A-Z])\\b");
        Matcher regexMatcher = regex.matcher(line);

        while (regexMatcher.find()){ // dokato namira grupi
            for (int i = 1; i <= regexMatcher.groupCount() ; i++) {
                String matchedText = regexMatcher.group(1);
                System.out.print(matchedText + " ");
            }
        }

    }
}
