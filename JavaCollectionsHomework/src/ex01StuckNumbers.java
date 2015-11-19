/**
 * Created by adelinadutskinova on 10/25/15.
 */
import java.util.Scanner;
public class ex01StuckNumbers {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int times = Integer.parseInt(input.nextLine());
        //TODO we take the first element and the second
        //TODO we start checking with for loops
        boolean found = false;
        String line = input.nextLine();
        String[] numbers = line.split(" ");

        for (int a = 0; a < numbers.length; a++) {
            for (int b = 0; b < numbers.length; b++) {
                for (int c = 0; c < numbers.length; c++) {
                    for (int d = 0; d < numbers.length; d++) {
                        if(!numbers[a].equals(numbers[b]) &&
                                !numbers[a].equals(numbers[c]) &&
                                !numbers[a].equals(numbers[d]) &&

                                !numbers[b].equals(numbers[a]) &&
                                !numbers[b].equals(numbers[c]) &&
                                !numbers[b].equals(numbers[d]) &&

                                !numbers[c].equals(numbers[a])&&
                                !numbers[c].equals(numbers[b])&&
                                !numbers[c].equals(numbers[d])){

                            String firstNumber = numbers[a] + numbers[b];
                            String secondNumber = numbers[c] + numbers[d];

                            if(firstNumber.equals(secondNumber)){
                                found = true;
                                System.out.printf("%s|%s==%s|%s\r\n",numbers[a],
                                        numbers[b],numbers[c],numbers[d]);
                            }
                        }
                    }
                }
            }
        }

        if (found == false){
            System.out.println("No");
        }

    }
}
