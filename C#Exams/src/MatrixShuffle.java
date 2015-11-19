/**
 * Created by adelinadutskinova on 11/13/15.
 */
import java.util.Scanner;

public class MatrixShuffle {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(input.nextLine());
        char[][] inputMatrix = new char[n][];
        char[][] spiralMatrix = new char[n][];


        String line = input.nextLine();
        for (int i = 0; i < spiralMatrix.length; i++) {

                //filling the first row
                String sb = line.substring(0,n);
                String rest = sb.substring(n,n*2);
                spiralMatrix[i] = sb.toCharArray();

        }

    }
}
