/**
 * Created by adelinadutskinova on 10/24/15.
 */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p13FilterArray {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine();
        String[] words = line.split(" ");


        List<String> result = (List<String>) Arrays.stream(words)
                .filter(x -> x.length() > 3)
                .collect(Collectors.toList());

        if (!result.isEmpty()) {
            for (String s : result) {
                System.out.print(s + " ");
            }
        }
        else{
            System.out.println("(empty)");
        }

    }
}
