package hangman.io;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Output {

    private static final PrintWriter OUT = new PrintWriter(new OutputStreamWriter(System.out, UTF_8), true);

    private Output(){}

    public static void writeToConsole(){
        writeToConsole(null, true);
    }

    public static void writeToConsole(Object obj){
        writeToConsole(obj, true);
    }

    public static void writeToConsole(Object obj, boolean newLine){
        if(Objects.isNull(obj)){
            OUT.println();
        } else if(newLine){
            OUT.println(obj);
        }
        else {
            OUT.format("%s", obj);
        }
    }
}
