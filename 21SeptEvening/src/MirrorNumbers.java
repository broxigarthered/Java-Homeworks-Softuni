/**
 * Created by adelinadutskinova on 10/31/15.
 */
import java.util.Scanner;

public class MirrorNumbers {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(input.nextLine());
        String line = input.nextLine();
        String[] numbers = new String[n];
        boolean found = false;
        numbers = line.split(" ");

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                String firstWord = numbers[i];
                String secondWord = new StringBuilder(numbers[j]).reverse().toString();

                if(numbers[i].equals(numbers[j])){
                    continue;
                }
                if (firstWord.equals(secondWord)){
                    System.out.println(numbers[i]+"<!>"+numbers[j]);
                    found = true;
                }

            }
            numbers[i]="";
        }

        if (found == false){
            System.out.println("No");
        }
    }
}
