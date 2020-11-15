package lexical.man_lex;

import java.io.*;
import java.util.ArrayList;

//处理文件 将其转换为char[]
public class ReadFile {
    public static ArrayList<Character> readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename))));
        String line;
        ArrayList<Character> input = new ArrayList<>();
        char[] tempChars;

        while (null != (line = br.readLine())) {
            tempChars = line.toCharArray();
            for (char c : tempChars) {
                if (c == '\t') {
                    continue;
                }
                input.add(c);
            }
            input.add('\n');
        }

        br.close();

        return input;
    }
}
