// Importing java tools
import java.util.Random;
import java.util.Scanner;

public class WAR_starter {
    public static void main(String[] args){

        // Opened scanner, and started main while loop
        Scanner scanner = new Scanner(System.in);
        String again = "y";
        while (again.equals("y")){

            // Generation of 2 random cards (1-52)
            Random rand = new Random();
            int computerCARD = rand.nextInt(52);
            int userCARD = rand.nextInt(52); 
            // Makes sure random number is not 0
            if(computerCARD == 0){
                computerCARD += 1;
            }
            if(userCARD == 0){
                userCARD += 1;
            }

            //Converts card number into suit and number for user card
            System.out.println(userCARD);
            char usuit = 'x';
            int unum = 0;
            
            // Cards 1 - 13 are Clubs
            if(userCARD <= 13){
                usuit = 'C';
                unum = userCARD;
            }
                
            // Cards 14 - 26 are Diamonds
            else if(userCARD <= 26){
                usuit = 'D';
                unum = userCARD - 13;
            }
                
            // Cards 27 - 39 are Hearts
            else if(userCARD <= 39){
                usuit = 'H';
                unum = userCARD - 26;
            }

            // Cards 40 - 52 are Spades
            else if(userCARD <= 52){
                usuit = 'S';
                unum = userCARD - 39;
            }
            String ucard = usuit+String.valueOf(unum);

            // Converts card number into suit and number for computer card
            System.out.println(computerCARD);
            char csuit = 'x';
            int cnum = 0;

            // Cards 1 - 13 are Clubs
            if(computerCARD <= 13){
                csuit = 'C';
                cnum = computerCARD;
            }

            // Cards 14 - 26 are Diamonds
            else if(computerCARD <= 26){
                csuit = 'D';
                cnum = computerCARD - 13;
            }

            // Cards 27 - 39 are Hearts
            else if(computerCARD <= 39){
                csuit = 'H';
                cnum = computerCARD - 26;
            }

            // Cards 40 - 52 are Spades
            else if(computerCARD <= 52){
                csuit = 'S';
                cnum = computerCARD - 39;
            }
            String ccard = csuit+String.valueOf(cnum);
            System.out.println("ComputerCARD is "+csuit+cnum);

            // Final send of 2 cards value (suit + value) to be outputted as ASCII cards
            printAsciiEval(ccard, ucard);

            // Asks user if they want to play again, which determines if it loops again or not
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
