import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/14/15.
 */
public class RectangleArea01 {
    static Scanner input = new Scanner(System.in);

    public static void main (String[]args){

        String line = input.nextLine();
        String[] tokens = line.split(" ");
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        int area = b*a;
        System.out.println(area);
    }
}

