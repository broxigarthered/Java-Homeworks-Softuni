/**
 * Created by adelinadutskinova on 11/10/15.
 */
import java.util.Scanner;
public class ITVillage {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        char[][] matrix = new char[4][4];
        String line = input.nextLine();
        String[] tokens = line.split("|");
        matrix[0] = tokens[0].toCharArray();

        for (int i = 0; i < 4; i++) {
            matrix[i] = input.nextLine().toCharArray();
        }
    }
}
