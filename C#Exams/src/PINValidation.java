/**
 * Created by adelinadutskinova on 11/12/15.
 */
import java.util.Scanner;
public class PINValidation {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String name = input.nextLine();
        String gender = input.nextLine();
        String pin = input.nextLine();
        int sum = 0;

        if(pin.length() < 0 && pin.length() > 10){
            System.out.println("<h2>Incorrect data</h2>");
            return;
        }
        int[] nums =  {2,4,8,5,10,9,7,3,6};

        for (int i = 0; i < pin.length()-1; i++) {
            int currentNum = Integer.parseInt(String.format("%c",pin.charAt(i)));
            sum += nums[i]  * currentNum;
        }

        int remainder = sum%11;
        if(remainder == 10){
            remainder = 0;
        }

        String month = pin.substring(2,4);



        if(Integer.parseInt(month) > 12 || Integer.parseInt(month) < 1){
            System.out.println("<h2>Incorrect data</h2>");
            return;
        }
        if(remainder != 6){
            System.out.println("<h2>Incorrect data</h2>");
            return;
        }
        else{
            System.out.printf("{\"name\":\"%s\",\"gender\":\"%s\",\"pin\":\"%s\"}",
                    name,
                    gender,
                    pin);
        }


    }
}
