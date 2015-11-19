/**
 * Created by adelinadutskinova on 10/21/15.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class SaveAnArrayListOfDoubles05 {

    static Scanner input = new Scanner(System.in);

    private static final String FILE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/01.jpg";
    private static final String SAVE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/double.list";
    static List<Double> list = new ArrayList<Double>();
    public static void main(String[] args) {
        //Write a program that saves and loads the information from an
        //ArrayList to a file using ObjectInputStream, ObjectOutputStream.
        //Set the name of the new file as doubles.list

        list.add(1.38);
        list.add(2.56);
        list.add(4.3);


        saveObjects();
        loadObjects();


    }

    public static void saveObjects(){
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(SAVE_PATH)
                    ));

            for(Object o : list){
                output.writeObject(o);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadObjects() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(SAVE_PATH)))) {
            Object obj;


        }
        catch (EOFException eof) {
            System.out.println("END OF FILE!");
        }
        catch (IOException cnfe) {
            System.out.println(cnfe.toString());
        }
    }
}


