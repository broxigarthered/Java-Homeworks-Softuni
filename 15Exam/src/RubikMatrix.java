/**
 * Created by adelinadutskinova on 11/15/15.
 */
import java.util.Scanner;

public class RubikMatrix {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //input
        String line = input.nextLine();
        String[]tokens = line.split(" ");
        int currentNumber = 1;
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        String[][]matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = currentNumber+"";
                currentNumber++;
            }
        }

        System.out.println();
        int numberOfLines = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            line = input.nextLine();
            String[] tokens2 = line.split(" ");
            int columnRow = Integer.parseInt(tokens2[0]);
            String direction = tokens2[1];
            int move = Integer.parseInt(tokens2[2]);

            switch(direction){
                case"up":
                    up(matrix,columnRow,move);
                    break;
                case"down":
                    up(matrix, columnRow, move);
                    break;


                case"left":
                    left(matrix,columnRow,move);
                    break;
                case"right":
                    left(matrix,columnRow,move);
                    break;
            }


        }

        //rearange it
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int currentElement = Integer.parseInt(matrix[i][j]);
                int nextElement = Integer.parseInt(matrix[i+1][j]);

                if(currentElement>nextElement){
                    System.out.printf("Swap(%d, %d) with (%d, %d)\n",
                            i, j, i + 1, j);
                }
                else System.out.println("No swap reqired");


            }
        }
    }
    public static void up(String[][]matrix,int col, int move){
        for (int i = 0; i < move; i++) {
            String temp = "";
            temp = matrix[0][col];
            matrix[0][col] = matrix[1][col];
            matrix[1][col] = temp;
        }
    }
    public static void down(String[][]matrix,int col,int move) {
        for (int i = 0; i < move; i++) {
            String temp = "";
            temp = matrix[0][col];
            matrix[0][col] = matrix[0 - 1][col];
            matrix[0 - 1][col] = temp;
        }
    }

    public static void left(String[][]matrix,int row,int move) {
        for (int i = 0; i < move; i++) {
            String temp = "";
            temp = matrix[row][0];
            matrix[row][0] = matrix[row+1][0];
            matrix[row+1][0] = temp;

        }
    }
}
