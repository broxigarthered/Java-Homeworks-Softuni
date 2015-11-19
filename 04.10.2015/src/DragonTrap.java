import java.util.Scanner;

public class DragonTrap {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int n = Integer.parseInt(input.nextLine());
        char[][] matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = input.nextLine().toCharArray();
        }

        String line = input.nextLine();

        while(!line.equals("End")){

            String[] commands = line.split(" ");
            String fN = commands[0].replace('(',' ').trim();
            String sN = commands[1].replace(')', ' ').trim();
            int row = Integer.parseInt(fN);
            int col = Integer.parseInt(sN);
            int radius = Integer.parseInt(commands[2]);
            int rotations = Integer.parseInt(commands[3]);

            int topBorder = row - radius;
            int bottomBorder = row + radius;
            int leftBorder = col - radius;
            int rightBorder = col + radius;

            rotateMatrix(rotations,matrix);
            line = input.nextLine();
        }
    }

    public static void rotateMatrix(int rotations, char[][]matrix){



    }

    private static String getBorders(char[][] pernik, int top, int bot, int left, int right){
       StringBuilder borders = new StringBuilder();

        if(top >= 0 && top<pernik.length){
            int minCol = Math.max(0, left);
            int maxCol = Math.min(pernik[0].length,right);

            for (int i = 0; i < maxCol; i++) {
                borders.append(pernik[top][i]);
            }
            top++;
        }
        if(right >= 0 && right < pernik[0].length){
            int minRow = Math.max(0,top);
            int maxRow = Math.min(pernik.length, bot);

            for (int i = minRow; i < maxRow; i++) {
                borders.append(pernik[i][right]);
            }
            top--;

        }

        if(bot >= 0 && bot < pernik.length){
            int minCol = Math.max(0,left);
            int maxCol = Math.min(pernik[0].length,right);

            for (int i = minCol; i < maxCol ; i++) {
                borders.append(pernik[i][right]);
            }
            right--;
        }

        if(left >= 0 && left < pernik[0].length){
            int minCol = Math.max(0,left);
            int maxCol = Math.min(pernik[0].length,right);

            for (int i = minCol; i < maxCol ; i++) {
                borders.append(pernik[i][right]);
            }
            right--;
        }
        return borders.toString();
    }
}

