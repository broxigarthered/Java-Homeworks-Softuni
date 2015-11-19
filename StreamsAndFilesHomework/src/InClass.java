/**
 * Created by adelinadutskinova on 10/19/15.
 */
import java.io.*;
import java.util.Scanner;
public class InClass {

    static Scanner input = new Scanner(System.in);

    //Stringovete s tova kade se namirat failovete se namirat failovete
    private static final String FILE_Path ="/Users/adelinadutskinova/IdeaProjects/InClass/3-2/users.txt";
    private static final String SAVE_Path = "/Users/adelinadutskinova/IdeaProjects/InClass/3-2/total-time.txt";

    public static void main(String[] args) {
        //Pravim gi kato filepath, taka 4e programata da znae kade da interactva
        File file = new File(FILE_Path);
        File outputFile = new File(SAVE_Path);

        //TryCatch block 6ot ina4e ne trugva, ne me pitai za6to :-D
        try {
            //reader-a go pravim za da 4ete daden file
            BufferedReader reader = new BufferedReader(new FileReader(file));

            //tuk zapisvame vseki red v String - line
            String line = reader.readLine();

            //fw e tova s koeto 6te pi6eme na result-a, ina4e kazano outputFile-a
            FileWriter fw = new FileWriter(outputFile,true);
            PrintWriter writer = new PrintWriter(fw, true);

            //Definirame totalMinutes i outputStringa
            int totalMinutes = 0;
            String output = new String();

            while(line != null){
                //6te 4ete dokato ne pro4ete absoliutno ni6to

                //splitvame pro4etenoto taka 4e da moje da vzimame otdelni elementi
                String[] lineArgs = line.split(" ");
                String username = lineArgs[0];

                // tuka slagame vseki put minutite da stavat 0 taka 4e
                // kogato doide nov player da e s novi minuti, za da ne se sabirat
                totalMinutes=0;

                for (int i = 1; i < lineArgs.length ; i++) {
                    // vzimame purviq username i go obrabotvame
                    String[] loggedTime = lineArgs[i].split(":");
                    int hours = Integer.parseInt(loggedTime[0]);
                    int minutes = Integer.parseInt(loggedTime[1]);
                    totalMinutes+= (hours*60) + minutes;

                     output = username + " "+ totalMinutes;




                }
                //LOGIC
                // one day = 1440 minutes

                // sled kato znaem kolko minuti e igral, prosto pravim smetkite
                int days = totalMinutes/1440;

                int hoursPlayed = totalMinutes/60;
                int minutesPlayed = totalMinutes%60;

                output +=" (" + days +" days "+ hoursPlayed + " hours "+minutesPlayed + " minutes)"+"\n";

                writer.print(output);

                line = reader.readLine();

            }

            writer.close();
            reader.close();
            //LE GG!

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }

