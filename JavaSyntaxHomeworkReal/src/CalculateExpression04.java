import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/15/15.
 */
public class CalculateExpression04 {
    static Scanner input = new Scanner(System.in);

    public static void main(String [] args){

        double a = Double.parseDouble(input.nextLine());
        double b = Double.parseDouble(input.nextLine());
        double c = Double.parseDouble(input.nextLine());

        double f1 = ((Math.pow(a, 2) + Math.pow(b, 2)) /
                (Math.pow(a, 2) - Math.pow(b, 2)));

        double r2 = (a+b+c)/Math.sqrt(c);
        double F1 = Math.pow(f1, r2);
        double F2 = Math.pow((Math.pow(a,2)+Math.pow(b,2)-Math.pow(c,3)),a-b);

        double numbersAverage = (a+b+c)/3;
        double fAverage = (F1+F2)/2;
        double difference = Math.abs(numbersAverage - fAverage);

        System.out.print("F1 result: "+ new DecimalFormat("##.##").format(F1) +
        "; "+ "F2 result: "+ new DecimalFormat("##.##").format(F2)+";"+
                        "Diff: "+new DecimalFormat("###.###").format(difference)

        );







    }
}
