/**
 * Created by adelinadutskinova on 11/15/15.
 */
import java.util.Scanner;
public class SoftuniPalataConf {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfPeople = Integer.parseInt(input.nextLine());
        int lines = Integer.parseInt(input.nextLine());
        int beds = 0;
        int food = 0;

        for (int i = 0; i < lines; i++) {
            String line = input.nextLine();
            String[] tokens = line.split(" ");
            String sleep = tokens[0];
            int quantity = Integer.parseInt(tokens[1]);
            String type =tokens[2];
            //tents
            if(sleep.equals("tents")){
                if(type.equals("normal")){
                    beds+=2 * quantity;
                }
                if(type.equals("firstClass")){
                    beds+=3 * quantity;
                }
            }

            //rooms
            if(sleep.equals("rooms")){
                if(type.equals("single")){
                    beds+= 1*quantity;
                }
                if(type.equals("double")){
                    beds+=2 * quantity;
                }
                if(type.equals("triple")){
                    beds+=3*quantity;
                }
            }

            //meals -> musaka -> 2 people
            //meals -> zakuska -> 0 people
            if(sleep.equals("food")){
                if(type.equals("musaka")){
                    food += 2*quantity;
                }
                if(type.equals("zakuska")){
                    food+= 0*quantity;
                }
            }

        }
        //TODO print the result
        if(beds >= numberOfPeople){
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d \n",beds-numberOfPeople);
        }
        else if(beds < numberOfPeople){
            System.out.printf("Some people are freezing cold. Beds needed: %d\n", numberOfPeople - beds);
        }

        if(food >= numberOfPeople){
            System.out.printf("Nobody left hungry. Meals left: %d\n", food - numberOfPeople);
        }
        else if(food<numberOfPeople){
            System.out.printf("People are starving. Meals needed: %d\n",numberOfPeople-food);
        }

    }
}
