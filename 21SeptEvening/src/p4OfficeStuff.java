
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class p4OfficeStuff {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        TreeMap<String,LinkedHashMap<String,Integer>> testMap = new TreeMap<>();

        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String pattern = "";

            String[] tokens = line.split("\\s*-");
            String company = tokens[0].replace('|',' ').trim();
            int amount = Integer.parseInt(tokens[1].trim());
            String product = tokens[2].replace('|',' ').trim();

            if(!testMap.containsKey(company)){  // ako nqma keya go addvame
                testMap.put(company,new LinkedHashMap<String,Integer>());
            }

            // addvame amounta
            Integer oldAmount = testMap.get(company).put(product,
                    testMap.get(company).get(product));
            if(oldAmount == null){
                oldAmount = 0;
            }

            testMap.get(company).put(product,oldAmount+amount); // pribavqme kum stariq ammount

        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : testMap.entrySet()) {
            String result = entry.getKey()+": ";
            LinkedHashMap<String,Integer> innerMap = entry.getValue();

            for (Map.Entry<String, Integer> entry2 : innerMap.entrySet()) {
                result += String.format("%s-%d, ",entry2.getKey(),entry2.getValue());
            }
            System.out.println(result.substring(0,result.length()-2));

        }
    }
}
