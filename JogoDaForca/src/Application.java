import hangman.core.Game;
import hangman.core.InvalidLetterException;

public class Application {

    public static void main(String[] args) throws InvalidLetterException {
        Game g = new Game();
        g.start();
    }
}
