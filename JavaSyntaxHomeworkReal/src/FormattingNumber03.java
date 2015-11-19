import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/14/15.
 */
public class FormattingNumber03 {
    static Scanner input = new Scanner(System.in);

    public static void main(String []args){

        int a = Integer.parseInt(input.nextLine());
        double b = Double.parseDouble(input.nextLine());
        double c =Double.parseDouble(input.nextLine());

        String hex = Integer.toHexString(a);
        String binary = Integer.toBinaryString(a);

        System.out.println(padLeft(c,10));


        System.out.print("|" + padRight(hex, 10));
        System.out.print("|" + padLeft(binary, 10) + "|");
        //System.out.println(new DecimalFormat("##.##").format(result));
        System.out.print(padRight(b, 10));
        System.out.println("|"+new DecimalFormat("##.##").format(c)+"        "+"|");

    }

    public static String padLeft(String s, int n) {
        int times = n-s.length()+1;
        return String.format("%1$" + "s", s + times );
    }
    public static String padLeft(double s,int n){
        return String.format("%1$" + "s", s + n );
    }

    public static String padRight(String s, int n) {
        int times = n-s.length()+1;
        return String.format("%1$-" + times +  "s", s );
    }

    public static String padRight(double s, int n) {
        return String.format("%1$" + n + "s", s);
    }


}
