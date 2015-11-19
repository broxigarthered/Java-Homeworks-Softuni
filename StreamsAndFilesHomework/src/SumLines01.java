/**
 * Created by adelinadutskinova on 10/21/15.
 */
import java.io.*;
import java.util.Scanner;

public class SumLines01 {
    static Scanner input = new Scanner(System.in);

    private static final String FILE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/lines.txt";

    public static void main(String[] args) {

        File file = new File(FILE_PATH);
        //BufferedReader in combination with FileReader.

            try {

                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line = reader.readLine();
                int sum = 0;

                while (line != null){
                    for (int i = 0; i < line.length(); i++) {
                        sum+=line.charAt(i);
                    }
                    System.out.println(sum);
                    sum=0;
                    line = reader.readLine();
                }

                reader.close();
            }


            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
