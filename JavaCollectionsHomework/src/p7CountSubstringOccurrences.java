/**
 * Created by adelinadutskinova on 10/22/15.
 */
import java.util.Scanner;
public class p7CountSubstringOccurrences {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String str = input.nextLine().toLowerCase();
        String findStr = input.nextLine();
        int lastIndex = 0;
        int count = countSubstring(findStr, str);


        System.out.println(count);
    }
    public static int countSubstring(String subStr, String str){
        return (str.length() - str.replace(subStr, "").length()) / subStr.length();
    }
}
