/**
 * Created by adelinadutskinova on 10/21/15.
 */
import java.util.Scanner;
public class ExcerciseInClass02 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(input.nextLine());
        printRecursive(n);


    }

    private static void printRecursive(int n){
        if(n<1){
            return;
        }

        printRecursive(n-1);
        System.out.println(n);
    }
}
