/**
 * Created by adelinadutskinova on 10/16/15.
 */
import java.util.Scanner;
public class MagicExchangeableWords {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String line = input.nextLine();

        String[] tokens = line.split(" ");
        String firstString = tokens[0];
        String secondString = tokens[1];

        boolean result = ExchangeableWords(firstString,secondString);
        System.out.println(result);
    }

    public static boolean ExchangeableWords(String first, String second){
        boolean result = false;
        char[] firstString = first.toCharArray();
        char[] secondString = second.toCharArray();

        for (int i = 1; i < firstString.length; i++) {
            if (firstString[i] != firstString[i-1] &&
                    secondString[i] != secondString[i-1]
                    ){
                result = true;
            }

            else if(firstString[i] == firstString[i-1] &&
                    secondString[i] == secondString[i-1]
                    ){
                result = true;
            }
            else{
                result = false;
            }
        }

        return result;
    }
}
