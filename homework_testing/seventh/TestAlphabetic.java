package homework_testing.seventh;
import java.util.Scanner;

public class TestAlphabetic {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        String string;
        System.out.print("please enter: ");
        string=str.nextLine();
        char[] characters = string.toCharArray();
        Test t;
        for (int i = 0; i < characters.length; i++) {
            t = new Test();
            t.chs = characters;
            try {
                t.validate(t.chs[i]);
            }catch (Exception m){
                System.out.println("Exception : " + m);
            }

        }
    }
}

class Test {
    char[] chs;
    static boolean isAlphabetic(char ch) {
        for (int i=65;i<91;i++) {
            if (ch == (char)i) {
                return true;
            }
        }
        for (int i=97;i<123;i++) {
            if (ch == (char)i) {
                return true;
            }
        }
        return false;
    }
    void validate(char ch) throws NonAlphabeticException {
        if (!isAlphabetic(ch)) {
            throw new NonAlphabeticException(ch + " is not an alphabetic character");
        }
        System.out.println(ch + " is an alphabetic character");
    }

}

class NonAlphabeticException extends Exception {
    NonAlphabeticException(String info) {
        super(info);
    }
}