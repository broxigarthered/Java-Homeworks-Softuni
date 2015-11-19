import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/13/15.
 */
public class GetAverage {

    static Scanner input = new Scanner(System.in);

    public static void main (String []args){

        double a = Double.parseDouble(input.nextLine());
        double b = Double.parseDouble(input.nextLine());
        double c = Double.parseDouble(input.nextLine());

         GetAverage(a,b,c);
    }

    public static void GetAverage(double a, double b,double c){
        double result = (a+b+c)/3;
        System.out.println(new DecimalFormat("##.##").format(result));
    }

}
