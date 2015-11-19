/**
 * Created by adelinadutskinova on 10/22/15.
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p6CountSpecifiedWord {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine().toLowerCase();
        String[] words = line.split(" ");

        String wordToBeFound = input.nextLine();

        long times = countNumberOfOccurrencesOfWordInString(line,wordToBeFound);
        System.out.println(times);


    }
    public static long countNumberOfOccurrencesOfWordInString(String msg, String target) {
        return Arrays.stream(msg.split("[ ,\\.]")).filter(s -> s.equals(target)).count();
    }

}
