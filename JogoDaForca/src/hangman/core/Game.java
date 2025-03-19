package hangman.core;

import hangman.io.Input;
import hangman.io.Output;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private static final int MAX_CHANCES = 5;
    private int chancesLeft = MAX_CHANCES;
    private final Set<Character> lettersUsed = new HashSet<>();
    private static final int COMMAND_RESET_GAME = 1;
    private static final Scanner SC = new Scanner(System.in);

    public void start() throws InvalidLetterException{
        boolean playAgain = true;
        while (playAgain) {
            chancesLeft = MAX_CHANCES;
            lettersUsed.clear();
            Output.writeToConsole("Discover the word");
            Dictionary dictionary = Dictionary.getInstance();
            Word word = dictionary.nextWord();
            printWord(word);
            Output.writeToConsole("WARNING: letters with accents are different from letters without accents!");
            Output.writeToConsole();

            while (!word.reveled() && chancesLeft > 0){
                char letter = readLetter();
                if (word.reveal(letter)){
                    onHit();
                } else {
                    onMiss();
                }
                lettersUsed.add(letter);
                printWord(word);
            }

            onEnd(word);
            playAgain = resetGame();
        }
        Output.writeToConsole("Thanks for playing!");
    }

    private void printWord(Word word){
        Output.writeToConsole();
        Output.writeToConsole(word);
        Output.writeToConsole();
    }

    private char readLetter(){
        while (true) {
            try {
                return validLetter(Input.readFromKeyBoard("Enter a letter: "));
            } catch (InvalidLetterException e) {
                Output.writeToConsole("ERROR: " + e.getMessage());
            }
        }
    }

    private char validLetter(String text) throws InvalidLetterException{
        String trimmedText = text.trim();

        if (trimmedText.length() == 0){
            throw new InvalidLetterException("Empty letter is not allowed");
        } else if (trimmedText.length() > 1){
            throw new InvalidLetterException("Provide only one letter");
        }

        char letter = trimmedText.charAt(0);

        if (!Character.isLetter(letter)) {
            throw new InvalidLetterException("Only letters are allowed");
        }

        char upperLetter = Character.toUpperCase(letter);
        if (lettersUsed.contains(upperLetter)){
            throw new InvalidLetterException("You alredy tried this one");
        }
        return upperLetter;
    }

    private void onHit(){
        Output.writeToConsole("You found it");
    }

    private void onMiss(){
        chancesLeft--;
        Output.writeToConsole("You missed..." + chancesLeft + " chance(s) left");
    }

    private void onEnd(Word word) throws InvalidLetterException {
        if (word.reveled()){
            Output.writeToConsole("You dided (:");
        } else {
            Output.writeToConsole("The word was: " + word.show());
            Output.writeToConsole("Better luck next time... :)");
        }
    }

    private boolean resetGame() throws InvalidLetterException {
        Output.writeToConsole("Want to play more rounds? ENTER 1 for YES, any other key to EXIT: ");
        if (SC.hasNextInt() && SC.nextInt() == COMMAND_RESET_GAME){
            return true;
        }
        return false;
    }
}
