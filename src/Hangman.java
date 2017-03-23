
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
        while(true){
            System.out.println("Player 1: Enter the word you wish player 2 to guess.");
            String word = input.nextLine();
            int length = word.length();
            for(int blanks = 0; blanks < length; blanks = blanks + 1 ){
            System.out.print("_ ");
            }
            int lives = 0;
            while(lives < 6){
                System.out.println("Player 2: Guess a letter.");
                String guess = input.nextLine();
                for(int i = 0; i < length; i++){
                    char guessChar = word.charAt(i);
                    if(guess.equals(""+guessChar)){
                        System.out.println("Correct");
                        int position = word.indexOf(guess);
                        for(int g = 0; g < length; length++){
                            if(g == position){
                                System.out.println(guess + " ");
                            }
                            System.out.println("_ ");
                        break;
                    }
                }else{
                        System.out.println("You lost one life.");
                        lives++;
                        break;
                    }
                }
                
            }
            System.out.println("You've lost all your lives. Game over.");
            break;
        }
    }
}
