package Java_pack;

import java.util.Scanner;

public class Check_Character {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        String string=null;
        System.out.print("请输入任意字符:");
        string=str.nextLine();
        Check e;
        char[] characters = string.toCharArray();
        for(int i = 0;i < characters.length;i++){
            e = new Check(characters[i]);
            try{
                e.CheckProcess(characters[i]);
                System.out.println("Input again");
            }catch (Exception m){
                System.out.println("Exception : " + m);
            }
        }
    }
}
class Check{
    char character;
    Check(char character){
        this.character = character;
    }
    public void CheckProcess(char character) throws CheckCharacterException{
        if((character <= 'Z' && character >= 'A')||(character <= 'z' && character >= 'a')||(character == ' '));
        else {
            throw new CheckCharacterException("Invalid input");
        }
    }
    class CheckCharacterException extends Exception{
        CheckCharacterException(String message){
            super(message);
        }
    }
}
