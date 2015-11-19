/**
 * Created by adelinadutskinova on 11/1/15.
 */
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulator {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String line = input.nextLine();


        List numbers = Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        line = input.nextLine();

        while(!line.equals("end")){
            String[] tokens = line.split(" ");
            String command = tokens[0];

            switch(command){
                case "exchange":
                    int times = Integer.parseInt(tokens[1]);
                    if(times+1 > numbers.size() || times < 0){
                        System.out.println("Invalid index");
                        break;
                    }
                    numbers = exchange(times,numbers);
                    break;

                case "max":
                    String what = tokens[1];
                    System.out.println(Max(what, numbers));
                    break;

                case "min":
                    String what2 = tokens[1];
                    int index = Min(what2,numbers);
                    if (index < 0 ){
                        System.out.println("No matches");
                    }else System.out.println(Min(what2,numbers));

                    break;
                case "first":
                    int cnt = Integer.parseInt(tokens[1]);
                    String oddOrEven = tokens[2];
                    if(cnt > numbers.size()){
                        System.out.println("Invalid count");
                        break;
                    }
                    System.out.println(first(cnt, oddOrEven, numbers));


                    break;

                case "last":
                    int cn = Integer.parseInt(tokens[1]);
                    String evenOrOdd = tokens[2];
                    if(cn > numbers.size()){
                    System.out.println("Invalid count");
                    break;
                }
                System.out.println(last(cn, evenOrOdd, numbers));

                    break;

            }

            line = input.nextLine();
        }
        System.out.println(numbers);
    }

    public static List exchange(int times, List<Integer> numbers){
        List<Integer> firstHalf = numbers.subList(0,times+1);
        List<Integer> secondHalf = numbers.subList(times+1,numbers.size());
        List<Integer> result = new ArrayList<>();
        result.addAll(secondHalf);
        result.addAll(firstHalf);
        return result;
    }

    public static int Max(String what, List<Integer> numbers){
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        
        if(what.equals("even")){
            for (int i = 0; i < numbers.size(); i++) {
                if(numbers.get(i) % 2 == 0){
                    if(max <= numbers.get(i)){
                        max = numbers.get(i);
                        maxIndex = i;
                    }
                }
            }
        }
        
        else{
            for (int i = 0; i < numbers.size(); i++) {
                if(numbers.get(i) % 2 == 1){
                    if (numbers.get(i) >= max){
                        max = numbers.get(i);
                        maxIndex = i;
                    }
                }
            }
        }
        return maxIndex;
    }

    public static int Min(String what,List<Integer> numbers){
        int min = Integer.MAX_VALUE;
        int minIndex = -5;

        if(what.equals("even")){
            for (int i = 0; i < numbers.size(); i++) {
                if(numbers.get(i) % 2 == 0){
                    if(min >= numbers.get(i)){
                        min = numbers.get(i);
                        minIndex = i;
                    }
                }
            }
        }
        else{
            for (int i = 0; i < numbers.size(); i++) {
                if(numbers.get(i) % 2 == 1){
                    if (numbers.get(i) <= min){
                        min = numbers.get(i);
                        minIndex = i;
                    }
                }
            }
        }
        return minIndex;
    }

    public static List first(int times, String word, List<Integer> numbers){
        List<Integer> result = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        evenList = numbers.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        oddList = numbers.stream().filter(n -> n%2 == 1).collect(Collectors.toList());



        if (word.equals("even")){
            if(times >= evenList.size()){
                return evenList;
            }
            result = evenList.subList(0,times);
        }
        if (word.equals("odd")){
            if(times >= oddList.size()){
                return oddList;
            }
            result = oddList.subList(0,times);
        }

        return result;
    }

    private static List last (int times, String word, List<Integer> numbers){
        List<Integer> result = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        evenList = numbers.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        oddList = numbers.stream().filter(n -> n%2 == 1).collect(Collectors.toList());



        if (word.equals("even")){
            if(times >= evenList.size()){
                return evenList;
            }
            result = evenList.subList(0,times);
        }
        if (word.equals("odd")){
            if(times >= oddList.size()){
                return oddList;
            }

            result = oddList.subList(oddList.size() - times, oddList.size());
        }

        return result;
    }
}
