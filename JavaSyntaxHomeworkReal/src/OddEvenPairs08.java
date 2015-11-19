import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/15/15.
 */
public class OddEvenPairs08 {
    static Scanner input = new Scanner(System.in);


    //Problem 8.	*Odd and Even Pairs
    //You are given an array of integers as a single line, separated by a space.
    //Write a program that checks consecutive pairs and prints if both are odd/even or not. Note that the array length should also be an even number

    public static void main(String[] args){

        String line = input.nextLine();
        String[] tokens = line.split(" ");
        int[] array = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String numberAsString = tokens[i];
            array[i] = Integer.parseInt(tokens[i]);
        }

        if (tokens.length%2==1){
            System.out.println("Invalid length");
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int firstNum = array[i-1];
            int secondNum = array[i];


            if (firstNum%2 == 0 && secondNum%2 == 0){
                System.out.println(array[i-1]+ ", "+array[i] + " -> both are even");
            }

            else if (firstNum%2 == 1 && secondNum%2 == 1){
                System.out.println(array[i-1]+ ", "+array[i] + " -> both are odd");
            }

            else System.out.println(firstNum+ ", "+secondNum + " -> different");

            i++;
        }




    }
}
