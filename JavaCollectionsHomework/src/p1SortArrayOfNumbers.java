/**
 * Created by adelinadutskinova on 10/22/15.
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class p1SortArrayOfNumbers {
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        int n = Integer.parseInt(input.nextLine());
        String line = input.nextLine();

        String[] numbers = line.split(" ");
        int[] arrNums = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            arrNums[i] = Integer.parseInt(numbers[i]);
        }

        Arrays.stream(arrNums)
                .sorted()
                //.filter(s -> s%2==0)
                .forEach(i -> System.out.printf("%d ",i));

    }
}
