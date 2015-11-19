/**
 * Created by adelinadutskinova on 11/3/15.
 */
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioActiveMutantVampireBunnies {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] coords = input.nextLine().split(" ");
        int rows = Integer.parseInt(coords[0]);
        int cols = Integer.parseInt(coords[1]);
        int playerRow = -1;
        int playerCol = -1;

        List<char[]> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
           String line = input.nextLine();
            int playerColumn = line.indexOf('P');
            matrix.add(line.toCharArray());

            if(playerColumn != -1){
                playerCol = playerColumn;
                playerRow = i;
            }

        }



        char[] cmds = input.nextLine().toCharArray();
        boolean hasWon = false;
        boolean hasDied = false;

        for (int i = 0; i < cmds.length; i++) {
            char cmd = cmds[i];
            switch(cmd){
                case 'U':
                    if(playerRow == 0){
                        hasWon = true;
                    }else{
                        if(matrix.get(playerRow-1)[playerCol] == 'B'){
                            hasDied = true;
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        else {
                            matrix.get(playerRow - 1)[playerCol] = 'P';
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        playerRow--;
                    }
                    break;
                case 'D':
                    if(playerRow == rows - 1){
                        hasWon = true;
                        matrix.get(playerRow)[playerCol] = '.';
                    }else{
                        if(matrix.get(playerRow+1)[playerCol] == 'B'){
                            hasDied = true;
                        }
                        else {
                            matrix.get(playerRow + 1)[playerCol] = 'P';
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        playerRow++;
                    }
                    break;
                case 'L':
                    if(playerCol == 0){
                        hasWon = true;
                        matrix.get(playerRow)[playerCol] = '.';
                    } else {
                        if(matrix.get(playerRow)[playerCol-1]=='B'){
                            hasDied = true;
                        } else{
                            matrix.get(playerRow)[playerCol] = 'P';
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        playerCol--;
                    }
                    break;
                case 'R':
                    if(playerCol == cols -1){
                        hasWon = true;
                        matrix.get(playerRow)[playerCol] = '.';
                    } else {
                        if(matrix.get(playerRow)[playerCol+1]=='B'){
                            hasDied = true;
                        } else{
                            matrix.get(playerRow)[playerCol+1] = 'P';
                            matrix.get(playerRow)[playerCol] = '.';
                        }
                        playerCol++;
                    }
                    break;
                default:break;
            }

        }



    }
}
