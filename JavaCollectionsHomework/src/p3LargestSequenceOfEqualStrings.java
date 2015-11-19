/**
 * Created by adelinadutskinova on 10/21/15.
 */
import java.util.Scanner;
public class p3LargestSequenceOfEqualStrings {


    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String[] arrStr = input.nextLine().split(" ");

       getLongestString(arrStr);
        // pravim dvata countera da po4vat ot 1



    }

    public static void getLongestString(String[] words){
        int countOfEqualStrings = 1;
        int maxcountOfEqualStrings = 1;


        String result = words[0] + "";
        for (int i = 0; i < words.length - 1; i++) { // countera e do -1 za6toto proverqvame po-nadolu element + 1, ina4e kazano ako ne e do -1 6te grumne


            //Ako sledva6tat duma e ednakva s tazi na koqto sme v momenta
            if (words[i].equals(words[i+1])) {
                countOfEqualStrings++;


                if (i == words.length - 2) {
                    if (maxcountOfEqualStrings < countOfEqualStrings) {
                        result = words[i] + "";
                        maxcountOfEqualStrings = countOfEqualStrings;
                    }
                }
            }
            //Ako sledva6tat duma ne e ednakva
            else { // tva se pravi, ako se vuvede edna duma samo da se za4ete samo tq
                if (countOfEqualStrings > maxcountOfEqualStrings) {
                    result = words[i] + "";
                    maxcountOfEqualStrings = countOfEqualStrings;
                }
                countOfEqualStrings = 1;
            }
        }

        //Printirame po maximum counta ako primerno e do 3, printirame dumata 3 puti
        for (int i = 0; i < maxcountOfEqualStrings; i++) {
            System.out.print(result + " ");
        }

    }

}


