import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ax(By-Cy) + Bx(Cy-Ay) + Cx(Ay-By)
 */
public class TriangleArea02 {
    static Scanner input = new Scanner(System.in);

    public static void main (String[]args){

        List<Integer> listX = new ArrayList<>();
        List<Integer> listy = new ArrayList<>();

        String line = input.nextLine();

        for (int i = 0; i <= 2 ; i++) {

            String[] tokens = line.split(" ");

            listX.add(Integer.parseInt(tokens[0]));
            listy.add(Integer.parseInt(tokens[1]));


            line = input.nextLine();
        }

        //Ax(By-Cy) + Bx(Cy-Ay) + Cx(Ay-By)

        int Ax = listX.get(0)*(listy.get(1)-listy.get(2));
        int Bx = listX.get(1)*(listy.get(2)-listy.get(0));
        int Cx = listX.get(2)*(listy.get(0)-listy.get(1));

        int result = Math.abs(Ax + Bx + Cx)/2;


        System.out.println(result);



    }

}
