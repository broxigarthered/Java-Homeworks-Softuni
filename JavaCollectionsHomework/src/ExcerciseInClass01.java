/**
 * Created by adelinadutskinova on 10/21/15.
 */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

public class ExcerciseInClass01 {
    static Scanner input = new  Scanner(System.in);

    public static void main(String[] args) {

        String[] elements = input.nextLine().split(" ");

        List<Integer> numbers = Arrays.stream(elements)
                .filter(ExcerciseInClass01::isNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        //using lambda
        int sumReduce = numbers.stream().reduce((x,y)-> x+y).get();

        System.out.println(sum);
        System.out.println(sumReduce);


    }
    private static boolean isNumber(String str){
        for(char ch : str.toCharArray()){
            if(!Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }
}
