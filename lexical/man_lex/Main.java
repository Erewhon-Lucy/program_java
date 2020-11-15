package lexical.man_lex;

import java.io.IOException;
import java.util.ArrayList;

import static lexical.man_lex.OutputFile.fileOutput;
import static lexical.man_lex.ReadFile.readFile;
import static lexical.man_lex.Analyzer.analyze;


public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "exp1\\test.txt";
        ArrayList<Character> chars = readFile(filename);
        ArrayList<Token> tokens = analyze(chars);
        fileOutput(tokens, filename);
    }
}
