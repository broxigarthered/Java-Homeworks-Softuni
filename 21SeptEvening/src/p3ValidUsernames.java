/**
 * Created by adelinadutskinova on 10/31/15.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import java.util.Scanner;
import java.util.regex.Pattern;

public class p3ValidUsernames {
    static Scanner input = new Scanner(System.in);



    public static void main(String[] args) {
        List<String> justList = new ArrayList<>();
        String bestWord1 = "";
        String bestWord2 = "";
        int bestCounter = 0;
        String line = input.nextLine();
        String pat = "\\b([a-zA-Z][a-zA-Z0-9_]{2,24})\\b";
        Pattern pattern = Pattern.compile(pat);
        Matcher match = pattern.matcher(line);

        while(match.find()){
            String word = match.group(1);
            justList.add(word);
        }

        for (int i = 1; i < justList.size(); i++) {
            String currentWord = justList.get(i);
            String previousWord = justList.get(i-1);
            int currentCounter = currentWord.length() + previousWord.length();
            if(currentCounter>bestCounter){
                bestCounter = currentCounter;
                bestWord1 = previousWord;
                bestWord2 = currentWord;
            }
        }
        System.out.println(bestWord1);
        System.out.println(bestWord2);


    }
}
