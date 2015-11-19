
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;
/**
 * Created by adelinadutskinova on 10/17/15.
 */

public class DragonSharp01 {
    static Scanner input = new Scanner(System.in);
    static int firstNumber = 0;
    static String sign = "";
    static int lastNumber = 0;
    public static void main(String[] args) {

        boolean IsItFalse = false;

        int lineNumber = 1;
        String pattern = "if\\s+\\((\\d+=*<*>*\\d*)\\)\\s+(\\w+\\s+\\d*)\\s*\\w*\\s*\\\"*(.*)\\\";";
        Pattern ifPattern = Pattern.compile(pattern);
        //grp 1 matches the statement (1==5) e.g   --  grp 2 matches out or loop + \s + times e.g loop 3
        // grp 3 matches the word

        String pattern2 = "else\\s+(\\w+\\s+\\d*)\\s*\\w*\\s*\\\"*(.*)\\\";";
        Pattern elsePattern = Pattern.compile(pattern2);
        //GRP1 matches whether out or loop 3
        //grp2 matches the word

        StringBuilder result = new StringBuilder();


        int k = Integer.parseInt(input.nextLine());
        String line = input.nextLine();
        for (int ka = 0; ka < k ; ka++) {



            Matcher match1 = ifPattern.matcher(line);
            Matcher match2 = elsePattern.matcher(line);


            while (match1.find()) {


                String statement = match1.group(1);
                String outOrLoop = match1.group(2);
                String word = match1.group(3);

                isNumberOrChar(statement);
                int times = findingTheNumber(outOrLoop);

                if (sign.equals("==")) {
                    if (firstNumber == lastNumber) {
                        for (int i = 0; i < times; i++) {
                            result.append(word + '\n' );
                        }
                        IsItFalse = true;
                    } else IsItFalse = false;

                } else if (sign.equals(">")) {
                    if (firstNumber > lastNumber) {
                        for (int i = 0; i < times; i++) {
                            result.append(word + '\n');
                        }
                        IsItFalse = true;
                    } else IsItFalse = false;

                } else if (sign.equals("<")) {
                    if (firstNumber < lastNumber) {
                        for (int i = 0; i < times; i++) {
                            result.append(word + '\n' );
                        }
                        IsItFalse = true;
                    } else IsItFalse = false;
                }


            }


            if (!IsItFalse) {
                while (match2.find()) {


                    String outOrLoop = match2.group(1);
                    String word = match2.group(2);

                    int times = findingTheNumber(outOrLoop);
                    for (int i = 0; i < times; i++) {
                        result.append(word + '\n');
                    }

                }
            }


            if (!line.contains("\"") || !line.contains(";")){
                System.out.println("Compile time error @ line "+lineNumber);
                return;
            }
            lineNumber++;
            if (input.hasNextLine()) {
                line=input.nextLine();
            }
        }

        System.out.println(result);
    }
    public static void isNumberOrChar(String k){

        String pattern = "(\\d*)(==|>|<)(\\d*)";
        Pattern regex = Pattern.compile(pattern);
        Matcher regexMatcher = regex.matcher(k);

        while(regexMatcher.find()){

            firstNumber = Integer.parseInt(regexMatcher.group(1));
            lastNumber = Integer.parseInt(regexMatcher.group(3));
            sign = regexMatcher.group(2);


        }
    }

    public static int findingTheNumber(String outOrLoop){
        String pattern = "(\\d+)";
        Pattern pat = Pattern.compile(pattern);
        Matcher regexMatcher = pat.matcher(outOrLoop);
        while(regexMatcher.find()){
            int times = Integer.parseInt(regexMatcher.group(1));
            return times;
        }

        return 1;
    }
}
