import java.util.Random;
import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/15/15.
 */
public class RandomizeNumbersFromNtoM07 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        int n = Integer.parseInt(input.nextLine());
        int m = Integer.parseInt(input.nextLine());

        int firstNum = Math.min(n,m);
        int secondNum = Math.max(n, m);
        Random r = new Random();


        for (int i = firstNum; i <= secondNum ; i++) {
            showRandomInteger(firstNum,secondNum,r);
        }

    }

    private static void showRandomInteger(int aStart, int aEnd, Random aRandom){

        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * aRandom.nextDouble());
        int randomNumber =  (int)(fraction + aStart);
        System.out.println(randomNumber);

    }

}
