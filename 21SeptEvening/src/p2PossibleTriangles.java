/**
 * Created by adelinadutskinova on 10/31/15.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class p2PossibleTriangles {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Double> nums = new ArrayList<Double>();
        boolean found = false;

        String line = input.nextLine();
        while(!line.equals("End")){
            String[] tokens = line.split(" ");

            for (int i = 0; i < tokens.length; i++) {
                nums.add(Double.parseDouble(tokens[i]));
            }

            Collections.sort(nums);
            double a = nums.get(0);
            double b = nums.get(1);
            double c = nums.get(2);

            if(a + b > c){
                System.out.printf("%.2f+%.2f>%.2f\r\n",a,b,c);
                found = true;
            }

            nums.clear();
            line = input.nextLine();
        }
        if(!found){
            System.out.println("No");
        }
    }
}
