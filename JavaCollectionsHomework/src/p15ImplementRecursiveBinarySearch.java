/**
 * Created by adelinadutskinova on 10/24/15.
 */
import java.util.Scanner;

public class p15ImplementRecursiveBinarySearch {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(input.nextLine());

        String line = input.nextLine();
        String[] numbersAsString = line.split(" ");
        int[] numbers = new int[numbersAsString.length];

        for (int i = 0; i<numbers.length; i++) numbers[i] = Integer.parseInt(numbersAsString[i]);

        int result = binarySearch(numbers, n);
        System.out.println(result);
    }


    public static int binarySearch(int[] a, int target) {
        return binarySearch(a, 0, a.length-1, target);
    }

    public static int binarySearch(int[] a, int start, int end, int target) {
        int middle = (start + end) / 2;
        if(end < start) {
            return -1;
        }

        if(target==a[middle]) {
            return middle;
        } else if(target<a[middle]) {
            return binarySearch(a, start, middle - 1, target);
        } else {
            return binarySearch(a, middle + 1, end, target);
        }
    }
}
