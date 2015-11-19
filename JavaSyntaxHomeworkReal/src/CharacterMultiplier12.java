/**
 * Created by adelinadutskinova on 10/15/15.
 */
import java.util.Scanner;
public class CharacterMultiplier12 {
    static Scanner input =new Scanner(System.in);

    public static void main(String[] args){
        String line = input.nextLine();
        String[] tokens = line.split(" ");

        String item1 = tokens[0];
        String item2 = tokens[1];


        System.out.println(CalculateString(item1, item2));

    }
    private static int CalculateString(String item1, String item2){
        int result = 0;
        int totalLength = Math.min(item1.length(), item2.length());


        for (int i = 0; i < totalLength; i++) {

                result+= item1.charAt(i) * item2.charAt(i);
        }

      if (item1.length() > item2.length()){
          int temLength = item1.length()-item2.length();

          for (int i = item2.length(); i <item1.length(); i++) {
              result+= item1.charAt(i);
          }
      }

        else if (item2.length() > item1.length()){
            int temLength = item1.length()-item2.length();

            for (int i = item1.length(); i <item2.length(); i++) {
                result+= item2.charAt(i);
            }
        }

        return result;
    }
}
