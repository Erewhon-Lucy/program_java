package lexical.man_lex;

import java.util.ArrayList;

public class Analyzer {
    public static ArrayList<Token> analyze(ArrayList<Character> chars) {
        ArrayList<Token> result = new ArrayList<>();

        // 记录数组下标
        int index = 0;

        // 记录行数
        int row = 1;

        // 存储临时的字符串
        String temp = "";

        //开始扫描
        while (index < chars.size()) {

            //处理注释
            if (chars.get(index) == '/' && index < chars.size() - 1 && chars.get(index + 1) == '/') {
                System.out.print("comments: ");
                while (chars.get(index) != '\n') {
                    System.out.print(""+chars.get(index));
                    index++;
                }
                System.out.println();
            }
            //判断/**/型注释中间的字符
            else if (chars.get(index) == '/' && index < chars.size() - 1 && chars.get(index + 1) == '*') {
                System.out.print("comments: ");
                while (index < chars.size() - 1 && (chars.get(index)!= '*' || chars.get(index + 1) != '/')) {
                    System.out.print(chars.get(index));
                    index++;
                    if (index == (chars.size() - 2)) {
                        System.out.println("wrong comments");
                        System.exit(0);
                    }
                }
                System.out.println("*/");
            }

            // 判断保留字或标识符
            if (isLetter(chars.get(index))) {
                temp += chars.get(index);
                while (chars.size() > index + 1 && (isLetter(chars.get(index + 1)) || isDigit(chars.get(index + 1)))) {
                    index++;
                    temp += chars.get(index);
                }
                if (isReserve(temp) != -1)
                    result.add(new Token(isReserve(temp), temp, "Keyword"));
                else
                    result.add(new Token(83, temp, "Identifier"));
            }

            // 处理数
            else if (isDigit(chars.get(index)) || (chars.get(index) == '-' && index < chars.size() - 1 && isDigit
                    (chars.get(index + 1)))) {
                if(chars.get(index) == '-'){
                    temp += chars.get(index);
                    index++;
                }
                temp += chars.get(index);
                while (chars.size() > index + 1 && isDigit(chars.get(index + 1))) {
                    index++;
                    temp += chars.get(index);
                }
                if (chars.get(index + 1) == '.') {
                    index++;
                    if (chars.size() > index + 1 && !isDigit(chars.get(index + 1))) {
                        result.add(new Token("line " + row + " invalid number"));
                    }
                    else {
                        temp += chars.get(index);
                        while (chars.size() > index + 1 && isDigit(chars.get(index + 1))) {
                            index++;
                            temp += chars.get(index);
                        }
                    }
                    result.add(new Token(82, temp, "decimal number "));
                }
                    result.add(new Token(81, temp, "Integer "));
            }

            // 处理换行符
            else if (chars.get(index) == '\n') {
                row++;
            }

            // 处理其他情况，并且跳过空格
            else if (chars.get(index) != ' ') {
                temp += chars.get(index);
                if (isDivide(temp) != -1) {
                    result.add(new Token(isDivide(temp), temp, "Separator"));
                    temp = "";
                    index++;
                    continue;
                }
                //判断是否为运算符
                else {
                    while (chars.size() > index + 1 && (isDivide(chars.get(index + 1) + "") == -1) && (!isDigit(chars.get(index
                            + 1))) && (!isLetter(chars.get(index + 1))) && chars.get(index + 1) != ' ') {
                        index++;
                        temp = temp + chars.get(index);
                    }

                    if (isOperator(temp) != -1)
                        result.add(new Token(isOperator(temp), temp, "Operator"));
                }

            }

            temp = "";
            index++;
        }

        return result;
    }

    // 判断是否为字符
    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c < 'Z');
    }

    //判断是否为保留字,并返回编号
    private static int isReserve(String s) {
        String[] reservedWords = TokensLibrary.keywords;
        int index = -1;
        for (int i = 0; i < reservedWords.length; i++) {
            if (s.equals(reservedWords[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    //判断是否为运算符,并返回编号
    private static int isOperator(String s) {
        String[] operators = TokensLibrary.operators;
        int index = -1;
        for (int i = 0; i < operators.length; i++) {
            if (s.equals(operators[i])) {
                index = i + 30;
                break;
            }
        }
        return index;
    }

    //判断是否为界符,并返回编号
    private static int isDivide(String s) {
        char[] separators = TokensLibrary.separators;
        int index = -1;
        for (int i = 0; i < separators.length; i++) {
            if (s.equals(separators[i] + "")) {
                index = i + 60;
                break;
            }
        }
        return index;
    }

    //判断是否为数字
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

}
