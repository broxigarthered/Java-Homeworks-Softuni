import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/15/15.
 */
public class HitTheTarget09 {
    static Scanner input = new Scanner(System.in);

  //Write a program that takes as input an integer – the target – and outputs to the console all pairs of numbers between 1 and 20, which,
  // if added or subtracted, result in the target.

    public static void main(String[] args){

        //Write a program that takes as input an integer – the target – and outputs to the console all pairs of numbers
        // between 1 and 20, which, if added or subtracted, result in the target.
        int n = Integer.parseInt(input.nextLine());

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j <20; j++) {
                if (i+j == n){
                    System.out.printf("%d + %d = %d", i, j, n);
                    System.out.println();
                }
            }
        }

        for (int i = 20; i > 1 ; i--) {
            for (int j = 20; j > 1 ; j--) {
                if (i-j == n){
                    System.out.printf("%d - %d = %d", i, j, n);
                    System.out.println();
                }
            }
        }
    }
}
