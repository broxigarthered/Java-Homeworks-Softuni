/**
 * Created by adelinadutskinova on 11/13/15.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parachute {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //variables
        List<char[]> m = new ArrayList<char[]>();
        int playerCurrentCol = 0;
        int playerCurrentRow = 0;
        int deadRow = 0;


        //We take our input
        String line = input.nextLine();
        while(!line.equals("END")){
            m.add(line.toCharArray());
            line = input.nextLine();
        }

        char[][] matrix = new char[m.size()][];
        for (int i = 0; i < m.size(); i++) {
            matrix[i] = m.get(i);
        }

        //main Logic
        //get the player's row and col
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'o'){
                    deadRow = playerCurrentRow;
                    playerCurrentCol = j;
                    playerCurrentRow = i;
                }
            }
        }


        //moving the player
        for (int i = 1; i < matrix.length; i++) {
            playerCurrentRow++;


            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '>'){
                    playerCurrentCol++;
                }
                else if(matrix[i][j] == '<'){
                    playerCurrentCol--;
                }
            }


            //check if he died
            if (matrix[playerCurrentRow][playerCurrentCol] == '_'){
                System.out.println("Landed on the ground like a boss!");
                System.out.printf("%d %d",playerCurrentRow,playerCurrentCol);
                break;
            }
            else if(matrix[playerCurrentRow][playerCurrentCol] == '~'){
                System.out.println("Drowned in the water like a cat!");
                System.out.printf("%d %d", playerCurrentRow, playerCurrentCol);
                break;
            }
            else if(matrix[playerCurrentRow][playerCurrentCol] == '\\' ||
                    matrix[playerCurrentRow][playerCurrentCol] == '/' ||
                    matrix[playerCurrentRow][playerCurrentCol] == '|' ){
                System.out.println("Got smacked on the rock like a dog!");
                System.out.printf("%d %d", playerCurrentRow, playerCurrentCol);
                break;
            }
        }




    }
}
