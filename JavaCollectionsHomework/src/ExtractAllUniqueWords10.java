/**
 * Created by adelinadutskinova on 10/23/15.
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExtractAllUniqueWords10 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine().toLowerCase();

        String[] splittedText = line.split("\\W+");

        Arrays.stream(splittedText)
               .sorted().distinct().forEach(x -> System.out.print(x+" "));



    }
}
