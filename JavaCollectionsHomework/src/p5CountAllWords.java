/**
 * Created by adelinadutskinova on 10/22/15.
 */
import java.util.Arrays;
import java.util.Scanner;
public class p5CountAllWords {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String line = input.nextLine();
        String[] words = line.split(" ");

        int count = (int) Arrays.stream(words)
                .count();

        System.out.println(count);

    }
}
