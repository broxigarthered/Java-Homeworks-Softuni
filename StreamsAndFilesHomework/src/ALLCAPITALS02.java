/**
 * Created by adelinadutskinova on 10/21/15.
 */
import java.io.*;
import java.util.Scanner;
public class ALLCAPITALS02 {
    static Scanner input = new Scanner(System.in);

    private static final String FILE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/lines.txt";
    private static final String SAVE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/temp.txt";

    public static void main(String[] args) {
        //Use BufferedReader, FileReader, FileWriter, and PrintWriter.
        File file = new File(FILE_PATH);
        File outputFile = new File(SAVE_PATH);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            FileWriter fw = new FileWriter(outputFile,true);
            PrintWriter writer = new PrintWriter(fw,true);

            StringBuilder result = new StringBuilder();


            while(line!=null){

                //TODO output string which contains the result
                for (int i = 0; i < line.length(); i++) {
                    line = line.toUpperCase();
                }
                line+= "\n";


                writer.print(line);


                line = reader.readLine();
            }
            writer.close();
            reader.close();
            boolean successful = outputFile.renameTo(file);
            System.out.println(successful);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
