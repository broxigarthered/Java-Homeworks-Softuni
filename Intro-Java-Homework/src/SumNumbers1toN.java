import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/13/15.
 */
public class SumNumbers1toN {
    static Scanner input = new Scanner(System.in);

    public static void main(String[]args){

        int n = Integer.parseInt(input.nextLine());
        int result = 0;

        for (int i = 0; i <= n; i++) {
            result += i;
        }

        System.out.println(result);
    }
}
