package hangman.core;

import hangman.io.Input;
import java.util.List;
import java.util.Random;

public class Dictionary {

    private static final String FILE_PATH = "/hangman/resources/dictionary.txt";
    private static final Dictionary INSTANCE = new Dictionary();
    private final Random random = new Random();

    private final List<String> words;

    private Dictionary (){
        words = Input.readLinesFromFile(FILE_PATH);
    }

    public Word nextWord(){
        return new Word
                (words.get(
                random.nextInt(0, words.size())
        ));
    }

    public static Dictionary getInstance(){
        return INSTANCE;
    }
}
