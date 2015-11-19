/**
 * Created by adelinadutskinova on 11/11/15.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p20OhMyGirl {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        StringBuilder words = new StringBuilder();

        String key = input.nextLine();
        String line = input.nextLine();
        String pat = "[a-z0-9][0-9]*#*\"*[a-zA-Z0-9]+\\d(.*?)[a-z0-9][0-9]*#*\"*[a-zA-Z0-9]+\\d";

        while(!line.equals("END")){
            words.append(line);
            line = input.nextLine();
        }
            Pattern pattern = Pattern.compile(pat);
            Matcher match = pattern.matcher(words);

            while(match.find()){
                String currentSegment = match.group(1);
                result.append(currentSegment);
            }


        System.out.println(result);
    }
}
