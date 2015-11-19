/**
 * Created by adelinadutskinova on 10/24/15.
 */

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class p14SortArrayWithStreamAPI {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String line = input.nextLine();
        String[] numbers = line.split(" ");


        List<Integer> arrayNums = new ArrayList<>();
        for(String s : numbers) arrayNums.add(Integer.valueOf(s));


        line = input.nextLine();

        if (line.equals("Ascending")){
           arrayNums.stream()
                   .sorted()
                   .collect(Collectors.toList())
                   .forEach(x -> System.out.print(x + " "));
        }
        else{
            arrayNums.stream()
                    .sorted(Collections.reverseOrder())
                    .forEach(x -> System.out.print(x + " "));
        }

    }
}
