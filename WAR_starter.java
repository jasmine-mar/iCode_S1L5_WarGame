import java.util.Random;
import java.util.Scanner;

public class WAR_starter {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String again = "y";
        while (again.equals("y")){

             // Generation of 2 random cards (1-52)
            Random rand = new Random();
            int computerCARD = rand.nextInt(52);
            int userCARD = rand.nextInt(52); 
            if(computerCARD == 0){
                computerCARD += 1;
            }
            if(userCARD == 0){
                userCARD += 1;
            }

            //YOUR CODE GOES HERE
            System.out.println(userCARD);
            char usuit = 'x';
            int unum = 0;
            if(userCARD <= 13){
                usuit = 'C';
                unum = userCARD;
            }
            else if(userCARD <= 26){
                usuit = 'D';
                unum = userCARD - 13;
            }
            else if(userCARD <= 39){
                usuit = 'H';
                unum = userCARD - 26;
            }
            else if(userCARD <= 52){
                usuit = 'S';
                unum = userCARD - 39;
            }
            String ucard = usuit+String.valueOf(unum);

            System.out.println(computerCARD);
            char csuit = 'x';
            int cnum = 0;
            if(computerCARD <= 13){
                csuit = 'C';
                cnum = computerCARD;
            }
            else if(computerCARD <= 26){
                csuit = 'D';
                cnum = computerCARD - 13;
            }
            else if(computerCARD <= 39){
                csuit = 'H';
                cnum = computerCARD - 26;
            }
            else if(computerCARD <= 52){
                csuit = 'S';
                cnum = computerCARD - 39;
            }
            String ccard = csuit+String.valueOf(cnum);
            System.out.println("ComputerCARD is "+csuit+cnum);
            //

            // Final send of 2 cards value (suit + value) to be outputted as ASCII cards
            printAsciiEval(ccard, ucard);

            System.out.println("Do you want to play again?");
            again = scanner.nextLine();
        }
    }

       
    public static void printAsciiEval(String computerCard, String userCard) {

        if(computerCard.length() == 2){
            printAscii_2Char_card(computerCard);
        }else {
            printAscii_3Char_card(computerCard);
        }

        System.out.println("------------");
        System.out.println("--COMPUTER--");
        System.out.println("------------");
        System.out.println("-----VS-----");
        System.out.println("------------");
        System.out.println("----USER----");
        System.out.println("------------");

        if(userCard.length() == 2){
            printAscii_2Char_card(userCard);
        }else {
            printAscii_3Char_card(userCard);
        }
    }

    public static void printAscii_2Char_card(String card){
        // Top of the computer card
        System.out.println("┌─────────┐");
        // Upper part of the card with the character
        System.out.println("│" + card + "       │"); // top-left corner of the card
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.println("│    " + card + "   │"); // middle of the card
        System.out.println("│         │");
        System.out.println("│         │");
        // Bottom part of the card with the character mirrored
        System.out.println("│       " + card + "│"); // bottom-right corner of the card
        // Bottom of the card
        System.out.println("└─────────┘");
    }

    public static void printAscii_3Char_card(String card){
        // Top of the computer card
        System.out.println("┌──────────┐");
        // Upper part of the card with the character
        System.out.println("│" + card + "       │"); // top-left corner of the card
        System.out.println("│          │");
        System.out.println("│          │");
        System.out.println("│    " + card + "   │"); // middle of the card
        System.out.println("│          │");
        System.out.println("│          │");
        // Bottom part of the card with the character mirrored
        System.out.println("│       " + card + "│"); // bottom-right corner of the card
        // Bottom of the card
        System.out.println("└──────────┘");
    }
}
