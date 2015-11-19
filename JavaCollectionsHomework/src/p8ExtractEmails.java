/**
 * Created by adelinadutskinova on 10/22/15.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p8ExtractEmails {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine();

        String pattern = "\\b\\w*\\.*\\-*\\w*@\\w*\\.*\\-*\\w*\\.*\\w*\\.*\\w*\\b";
        Pattern emailsPattern = Pattern.compile(pattern);
        Matcher match1 = emailsPattern.matcher(line);

        while(match1.find()){
            //TODO logic here extract the emails in strings and print them
            String matchedEmails = match1.group(0);
            System.out.println(matchedEmails);
        }
    }
}
