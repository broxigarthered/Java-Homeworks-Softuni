/**
 * Created by adelinadutskinova on 10/25/15.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex03SimpleExpression {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String line = input.nextLine();




        String patternString = "\\s*(\\d+)\\s*(\\-*\\+*)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher match = pattern.matcher(line);
        // grupa edno sa 4islata
        // grupa dve sa - i +

        double result = 0;
        int crn = 0;
        while(match.find()){

            double currentNumber = Double.parseDouble(match.group(1));
            String currentSymbol = match.group(2);
            double num = 0;

            if(currentSymbol.equals("+")){

            }
            else if(currentSymbol.equals("")){

            }
            else{

            }
            crn++;
        }

        System.out.println(result);
    }
}
