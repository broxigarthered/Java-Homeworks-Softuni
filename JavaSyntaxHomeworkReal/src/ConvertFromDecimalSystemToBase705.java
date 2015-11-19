import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/15/15.
 */
public class ConvertFromDecimalSystemToBase705 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        int n = Integer.parseInt(input.nextLine());
        System.out.print(Integer.toString(n, 7));

    }

}
