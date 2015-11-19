
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiggestTableRow {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String line = input.nextLine();
        String pat = "<td>(.*?)<\\/td>";
        double sum = 0;
        double bestSum = 0;
        boolean found = false;
        List<String> dList = new ArrayList<String>();
        List<String> resultList = new ArrayList<String>();


        while(!line.equals("</table>")){
            Pattern pattern = Pattern.compile(pat);
            Matcher match = pattern.matcher(line);


            while(match.find()){
                if(tryParseDouble(match.group(1))){
                    sum += Double.parseDouble(match.group(1));
                    found = true;
                    dList.add(match.group(1));
                }
            }

            if(sum > bestSum){
                bestSum = sum;
                resultList = dList;
                dList = new ArrayList<>();
            }
            sum = 0;

            line = input.nextLine();
        }


        if(!found){
            System.out.println("no data");
        }
        else {

            DecimalFormat df = new DecimalFormat("###");
            String result = df.format(bestSum)+ " = ";
            //result += String.format("%s - %d kg, ",entry2.getKey(),
            //entry2.getValue());
            for (int i = 0; i < resultList.size(); i++) {
                result += String.format("%s + ",resultList.get(i));
            }
            System.out.println(result.substring(0,result.length()-2));
        }
    }
    private static boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
