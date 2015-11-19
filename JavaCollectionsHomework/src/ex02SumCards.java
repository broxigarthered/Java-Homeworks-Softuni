/**
 * Created by adelinadutskinova on 10/25/15.
 */
import java.util.Scanner;
public class ex02SumCards {

    //TODO vzimame purviq element,ako sledva6tiq e raven na purviq
    //TODO da go umnojavame po 2
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //TODO 2 -> 2, 3 -> 3, 4 -> 4, 5 -> 5,
        //TODO 6 -> 6, 7 -> 7, 8 -> 8, 9 -> 9, 10 -> 10, J -> 12,
        //TODO Q -> 13, K -> 14, A -> 15

        String line = input.nextLine();
        String[] cards = line.split(" ");
        boolean countedTwice = false;
        int result = 0;

        if (cards.length == 1){
            String lastCardFace = Character.toString(cards[cards.length-1].charAt(0));
            if(cards[cards.length-1].length()>=3){
                lastCardFace += cards[cards.length-1].charAt(1);
            }
            result+=Count(countedTwice,lastCardFace);
            System.out.println(result);
            return;
        }
        else if(cards.length == 2){
            String lastCardFace = Character.toString(cards[cards.length-1].charAt(0));
            String previousCardFace = Character.toString(cards[cards.length-2].charAt(0));

            if(cards[cards.length-1].length()>=3){
                lastCardFace += cards[cards.length-1].charAt(1);
            }
            if(cards[cards.length-2].length()>=3){
                previousCardFace += cards[cards.length-2].charAt(1);
            }

            //checks if it was equal to the previous
            if (lastCardFace.equals(previousCardFace)){
                countedTwice = true;
            }
            result+=Count(countedTwice,lastCardFace);





            System.out.println(result);
        }




        for (int i = 1; i < cards.length-1; i++) {
            String firstCard = Character.toString(cards[i-1].charAt(0));
            String cardFace = Character.toString(cards[i].charAt(0));
            String nextCardFace = Character.toString(cards[i+1].charAt(0));

            if(cards[i].length()>=3){
                cardFace += cards[i].charAt(1);
            }
            if(cards[i-1].length()>=3){
                firstCard += cards[i-1].charAt(1);
            }
            if(cards[i+1].length()>=3){
                nextCardFace += cards[i+1].charAt(1);
            }


            if (cardFace.equals(nextCardFace) || cardFace.equals(firstCard)){
                countedTwice = true;
            }

            result += Count(countedTwice,cardFace);
            countedTwice = false;

            //TODO check if it is on the first line and add the first element
            if(i==1){
                if (cardFace.equals(firstCard)){
                    countedTwice=true;
                }
                result+=Count(countedTwice,firstCard);
            }
        }

        String lastCardFace = Character.toString(cards[cards.length-1].charAt(0));
        String previousCardFace = Character.toString(cards[cards.length-2].charAt(0));

        if(cards[cards.length-1].length()>=3){
            lastCardFace += cards[cards.length-1].charAt(1);
        }
        if(cards[cards.length-2].length()>=3){
            previousCardFace += cards[cards.length-2].charAt(1);
        }

        //checks if it was equal to the previous
        if (lastCardFace.equals(previousCardFace)){
            countedTwice = true;
        }
        result+=Count(countedTwice,lastCardFace);





        System.out.println(result);
    }

    private static int Count (boolean f, String cardFace){
        int globalResult=0;
        switch(cardFace){
            case "2":
                globalResult+=2;
                break;
            case "3":
                globalResult+=3;
                break;
            case "4":
                globalResult+=4;
                break;
            case "5":
                globalResult+=5;
                break;
            case "6":
                globalResult+=6;
                break;
            case "7":
                globalResult+=7;
                break;
            case "8":
                globalResult+=8;
                break;
            case "9":
                globalResult+=9;
                break;
            case "10":
                globalResult+=10;
                break;
            case "J":
                globalResult+=12;
                break;
            case "Q":
                globalResult+=13;
                break;
            case "K":
                globalResult+=14;
                break;
            case "A":
                globalResult+=15;
                break;
        }

        if(f){
            globalResult*=2;
        }

        return globalResult;
    }
}
