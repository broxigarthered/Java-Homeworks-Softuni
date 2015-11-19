import java.util.Scanner;

/**
 * Created by adelinadutskinova on 10/13/15.
 */
public class GhettoNumeralSystem {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){

        int n = Integer.parseInt(input.nextLine());

        String temp = Integer.toString(n);
        //parsing the nubmer to array
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';

        }


        System.out.println(Result(newGuess));

    }
    public static String Result(int[] array){
        String result = new String();

        for (int i = 0; i < array.length; i++) {
            switch(array[i]){
                case 0:
                    result+="Gee";
                    break;
                case 1:
                    result+="Bro";
                    break;
                case 2:
                    result+="Zuz";
                    break;
                case 3:
                    result+="Ma";
                    break;
                case 4:
                    result+="Duh";
                    break;
                case 5:
                    result+="Yo";
                    break;
                case 6:
                    result+="Dis";
                    break;
                case 7:
                    result+="Hood";
                    break;
                case 8:
                    result+="Jam";
                    break;
                case 9:
                    result+="Mack";
                    break;
            }
        }
        return result;

    }
}
