
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
            //gets the length of the entered word
            int length = word.length();
            //prints out blanks for every letter
            for (int blanks = 0; blanks < length; blanks = blanks + 1) {
                System.out.print("_ ");
            }
            //creates lives for the second player and enters a loop where lives are required
            int lives = 0;
            while (lives < 6) {
                //player 2 guesses a letter and the program checks if it is correct or not
                System.out.println("Player 2: Guess a letter.");
                String guess = input.nextLine();
                for (int i = 0; i < length;) {
                    char guessChar = word.charAt(i);
                    //prints out the character in the correct position if it is a correct guess
                    if (guess.equals("" + guessChar)) {
                        System.out.println("Correct");
                        int position = word.indexOf(guess);
                        
                    } else {
                        System.out.println("You lost one life.");
                        lives++;
                        break;
                    }
                    i++;
                }

            }
            System.out.println("You've lost all your lives. Game over.");
            break;
        }
    }
}
