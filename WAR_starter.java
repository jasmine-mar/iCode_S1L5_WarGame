// Importing java tools
import java.util.Random;
import java.util.Scanner;

public class WAR_starter {
    public static void main(String[] args){

        // Opened scanner, and started main while loop
        Scanner scanner = new Scanner(System.in);

        // Create variables for the game
        String again = "y";
        int cardstaken = 1;
        int usercards = 26;
        int computercards = 26;
        int turns = 0;

        // Game loop repeats until user or computer runs out of cards
        while (usercards > 0 && computercards > 0){
            System.out.println("-----------------------------------------------------------");
    
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

            // Final send of 2 cards value (suit + value) to be outputted as ASCII cards
            printAsciiEval(ccard, ucard);

            // Checks if user card value is greater than computer card value
            if (unum > cnum){
                System.out.println("User wins!");
                usercards += cardstaken;
                computercards -= cardstaken;
                System.out.println("User gains "+ String.valueOf(cardstaken) + " cards.");
                System.out.println("Computer loses "+ String.valueOf(cardstaken) + " cards.");
            }

            // Checks if computer card value is greater than user card value
            else if (cnum > unum){
                System.out.println("Computer wins!");
                computercards += cardstaken;
                usercards -= cardstaken;
                System.out.println("Computer gains "+ String.valueOf(cardstaken) + " cards.");
                System.out.println("User loses "+ String.valueOf(cardstaken) + " cards.");
            }

            // Reset the cards put down and taken each round to 1
            cardstaken = 1;
            
            // Checks if user card value and computer card value is equal
            // If so, declare a 'war', cards taken and put down are now 5
            if (unum == cnum){
                System.out.println("User and computer cards are equal!");
                System.out.println("A war has started, 4 cards have been placed face-down.");
                System.out.println("The winner of the next two cards will take all.");
                cardstaken = 5;
            }

            // Prints out how many cards the user and computer currently have
            System.out.println();
            System.out.println("User currently has " + String.valueOf(usercards) + " cards.");
            System.out.println("Computer currently has " + String.valueOf(computercards) + " cards.");
            System.out.println();

            // Signals that another turn is over
            turns += 1;

            // Pauses the loop to give time for the user the read.
            System.out.println("Type anything to continue to next round.");
            again = scanner.nextLine();
        
        
        }
        // Game over screen

        // If the user is the one that ran out of cards, print that the computer has won
        if (usercards <= 0){
            System.out.println("Computer has won the game!");
            System.out.println("It took " + String.valueOf(turns) + " turns to finish the game.");
        }

        //If the computer is the one that ran out of cards, print that the user has won
        if (computercards <= 0){
            System.out.println("Computer has won the game!");
            System.out.println("It took " + String.valueOf(turns) + " turns to finish the game.");
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
