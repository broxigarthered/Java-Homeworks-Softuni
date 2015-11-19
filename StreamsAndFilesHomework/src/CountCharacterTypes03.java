/**
 * Created by adelinadutskinova on 10/21/15.
 */
import java.io.*;
import java.util.Scanner;

public class CountCharacterTypes03 {

    static Scanner input = new Scanner(System.in);

    private static final String FILE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/words.txt";
    private static final String SAVE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/count-chars.txt";

    public static void main(String[] args) {
        File file = new File(FILE_PATH);
        File outputFile = new File(SAVE_PATH);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            FileWriter fw = new FileWriter(outputFile,true);
            PrintWriter writer = new PrintWriter(fw,true);


            int vowelCounter = 0;
            int puncCounter = 0;
            int consonantsCounter = 0;
            String output = "";


            //logic
            while(line!=null){
                for (int i = 0; i < line.length(); i++) {
                    if (isVowel(line.charAt(i))){
                        vowelCounter++;
                    }
                    else if(isPunctuation(line.charAt(i))){
                        puncCounter++;
                    }
                    else if(line.charAt(i) == ' '){
                        continue;
                    }
                    else consonantsCounter++;
                }
                line = reader.readLine();

            }

            output = "Vowels " + vowelCounter + '\n' + "Consonants "+ consonantsCounter+
                    '\n' + "Punctuation "+puncCounter;
            writer.print(output);

            writer.close();
            reader.close();
        }


        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static boolean isPunctuation(char c) {
        return "!,.?".indexOf(c) != -1;
    }
}
