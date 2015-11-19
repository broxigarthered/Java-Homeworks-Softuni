import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/24/15.
 */
public class p16CalculateN {static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(input.nextLine());
        System.out.println(printFactorial(n));

    }

    private static int printFactorial(int n){
       int result;

        if(n<=1){
            return 1;
        }

        result = printFactorial(n-1)  * n;
        return result;
    }
}

