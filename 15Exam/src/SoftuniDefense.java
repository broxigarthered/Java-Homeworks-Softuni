/**
 * Created by adelinadutskinova on 11/15/15.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniDefense {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String pat = ".*?([A-Z][a-z]+).*?([A-Z]+[a-z]*[A-Z]+).*?(\\d+)L";
        double totalLiters = 0;
        Pattern pattern = Pattern.compile(pat);

        String line = input.nextLine();
        while(!line.equals("OK KoftiShans")){
            Matcher match = pattern.matcher(line);

            while(match.find()){
                String name = match.group(1);
                String typeOfAlchol = match.group(2);
                int liters = Integer.parseInt(match.group(3));
                totalLiters+= liters*0.001;

                System.out.printf("%s brought %d liters of %s!\n",
                        name,
                        liters,
                        typeOfAlchol.toLowerCase());
            }

            line = input.nextLine();
        }
        System.out.printf("%.3f softuni liters",totalLiters);
    }
}
