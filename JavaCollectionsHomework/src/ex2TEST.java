/**
 * Created by adelinadutskinova on 10/25/15.
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex2TEST {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String line = input.nextLine();




        //String patternString = "\\s*(\\-*\\+*\\s*\\d+\\.+)\\s*";
        String patternString  = "\\s*(\\-*\\+*\\s*[0-9]\\.*\\d*)\\s*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher match = pattern.matcher(line);
        // grupa edno sa 4islata
        // grupa dve sa - i +

        BigDecimal result = new BigDecimal(BigInteger.ZERO);

        while(match.find()){


            String currentDouble = match.group(1);
            String arebe = currentDouble.replaceAll("\\s*","");
            BigDecimal n = new BigDecimal(arebe);

            result = result.add(n);

        }

        System.out.println(result.toPlainString());


    }
}
