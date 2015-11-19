import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PrintCharacterTriangle {

static Scanner input = new Scanner(System.in);


    public static void main(String[] args){

        int number = Integer.parseInt(input.nextLine());
        char ch = (char)(number+'a');
        String result = new String();



        for(char c = 'a'; c < ch; c++){

            result+=c+" ";

            System.out.println(result);
        }

        for (int i = number-1; i > 0 ; i--) {
            for (int j = 0; j < i ; j++) {
                System.out.print((char) (j + 97) + " ");
            }
            System.out.println();
        }








    }
}
