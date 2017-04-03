
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author peraa0837
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new scanner
        Scanner input = new Scanner(System.in);


        while (true) {
            //prompt first player to enter a word
            System.out.println("Player 1: Enter the word you wish player 2 to guess.");
            String word = input.nextLine();
            //converts word to lower case for consistency
            word = word.toLowerCase();
            for (int spaces = 0; spaces < 13; spaces++) {
                System.out.println(" ");
            }
            //gets the length of the entered word
            int length = word.length();
            //prints out blanks for every letter
            String dashes = "";
            for (int blanks = 0; blanks < length; blanks = blanks + 1) {
                dashes = dashes + "-";
            }
            //creates a stringbuilder in order to setCharAt
            StringBuilder temp = new StringBuilder(dashes);


            //creates integers for lives and correct guesses
            int correct = 0;
            int lives = 6;
            while (lives > 0) {
                //prompts user to guess a letter
                System.out.println(temp);
                System.out.println("Player 2: Guess a letter. You have " + lives + " lives left.");
                String guess = input.nextLine();
                //converts guess to lower case to maintain consistency
                guess = guess.toLowerCase();
                //turns the guess string into a character
                char guessChar = guess.charAt(0);
                //creates an integer for the position of the letter in the word
                int x = word.indexOf(guessChar);

                //if correct, search for more of the same character then replace dashes
                if (x >= 0) {
                    System.out.println("Correct.");
                    while (x >= 0) {
                        temp.setCharAt(x, guessChar);
                        x = word.indexOf(guessChar, x + 1);
                        if (x >= 0) {
                            correct++;
                        }
                    }
                    correct++;
                    //if incorrect, lose 1 life
                } else {
                    System.out.println("You've lost one life.");
                    lives--;
                }
                //if word is succesfully completed, say winning string
                if (correct == length) {
                    System.out.println("Congratulations, you won!");
                    System.out.println("The word was " + word + ".");
                    break;
                }
            }
            //if all lives are lost, end game
            if (correct < length) {
                System.out.println("You've lost all your lives. Game over.");
                System.out.println("The correct word was " + word + ".");
            }
            //ask to play again
            System.out.println("Play again? (Yes/No)");
            String restart = input.nextLine();
            restart = restart.toLowerCase();
            if (restart.equals("no")) {
                break;
            }
        }
    }
}
