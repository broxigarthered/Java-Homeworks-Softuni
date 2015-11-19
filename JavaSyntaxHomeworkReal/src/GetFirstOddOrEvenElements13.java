
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by adelinadutskinova on 10/16/15.
 */
public class GetFirstOddOrEvenElements13 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //INPUT and VARIABLES
        String line = input.nextLine();
        String[] num = line.split(" ");
        int[] arr = new int[num.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        line = input.nextLine();
        String[] tokens = line.split(" ");
        int times = Integer.parseInt(tokens[1]);
        String type = tokens[2];

        Output(times, type, arr);
    }

    public static void Output(int times, String type, int[] arr) {
        List<Integer> resultListOfOdds = new ArrayList<>();
        List<Integer> resultListOfEvens = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            switch (type) {
                case "odd":
                    if (arr[i]%2 == 1){
                        resultListOfOdds.add(arr[i]);
                    }


                    break;

                case "even":
                    if (arr[i]%2 == 0){
                        resultListOfEvens.add(arr[i]);
                    }

                    break;
            }
        }

        int howManyOdds = resultListOfOdds.size();
        int howManyEvens = resultListOfEvens.size();

        if (type.equals("odd")) {
            if (howManyOdds >= times) {
                for (int j = 0; j < howManyOdds; j++) {
                    System.out.print(resultListOfOdds.toArray()[j] + " ");
                }
            } else if (howManyOdds < times) {
                for (int i = 0; i < howManyOdds; i++) {
                    System.out.print(resultListOfOdds.toArray()[i] + " ");
                }
            }
        }
        else{
            if (howManyEvens >= times) {
                for (int j = 0; j < howManyEvens; j++) {
                    System.out.print(resultListOfEvens.toArray()[j] + " ");
                }
            } else if (howManyEvens < times) {
                for (int i = 0; i < howManyEvens; i++) {
                    System.out.print(resultListOfEvens.toArray()[i] + " ");
                }
            }

        }
    }
}

