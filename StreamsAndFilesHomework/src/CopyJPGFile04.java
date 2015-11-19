/**
 * Created by adelinadutskinova on 10/21/15.
 */

import java.io.*;
import java.util.Scanner;

public class CopyJPGFile04 {
    static Scanner input = new Scanner(System.in);

    private static final String FILE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/01.jpg";
    private static final String SAVE_PATH = "/Users/adelinadutskinova/IdeaProjects/StreamsAndFilesHomework/FileIOStuff/my-copied-picture.jpg";

    public static void main(String[] args) {

        //Write a program that copies the contents of a .jpg file
        // to another using FileInputStream, FileOutputStream,
        //and byte[] buffer. Set the name of the new file as my-copied-picture.jpg.

        File file = new File(FILE_PATH);
        File outputFile = new File(SAVE_PATH);

        try {
            FileInputStream photo = new FileInputStream(file);
            FileOutputStream resultPhoto = new FileOutputStream(outputFile);


            int currentByte = photo.read();
            while(currentByte!=-1){
                resultPhoto.write(currentByte);
                currentByte = photo.read();
            }

            photo.close();
            resultPhoto.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
