/**
 * Created by adelinadutskinova on 10/22/15.
 */
import java.util.Scanner;
public class p4LongestIncreasingSequence {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {



        String line = input.nextLine();

        String[] numbers = line.split(" ");
        int[] arrNums = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arrNums[i] = Integer.parseInt(numbers[i]);
        }
        int maxSequence = 1;
        int indexMaxStart = 0;

        for (int i = 0; i < arrNums.length; i++) {
            System.out.printf("%d", arrNums[i]);
            int counter = 1;
            while (i < arrNums.length - 1 && arrNums[i] <arrNums[i + 1]) {
                counter++;
                System.out.printf(" %d", arrNums[i + 1]);
                i++;
            }
            System.out.printf("%n");
            if (counter > maxSequence) {
                maxSequence = counter;
                indexMaxStart = (i + 1) - maxSequence;//find the start position for the longest sequence.
            }
        }
        System.out.print("Longest: ");
        for (int j = indexMaxStart; j < indexMaxStart + maxSequence; j++) {
            System.out.printf("%d ", arrNums[j]);
        }
    }
    }

