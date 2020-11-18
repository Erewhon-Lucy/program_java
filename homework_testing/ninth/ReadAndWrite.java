package homework_testing.ninth;

import java.io.*;

public class ReadAndWrite {
    public static void main(String[] args) {
        String inputFile = "homework_testing\\ninth\\input.txt";
        ReadFile.Read(inputFile);
        String outputFile = "homework_testing\\ninth\\output.txt";
        byte[] result = ("" + ReadFile.cnt).getBytes();
        WriteFile.Write(outputFile, result);
    }
}

class ReadFile {
    static int cnt;

    static public void Read(String filename) {
        try {
            InputStream fin = new FileInputStream(filename);
            int i = 0;
            cnt = 0;
            while ((i = fin.read()) != -1) {
                cnt += 1;
            }
            System.out.println("total character:" + cnt);
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class WriteFile {
    static public void Write(String filename, byte[] result) {
        try {
            OutputStream fout = new FileOutputStream(filename);
            fout.write(result);
            fout.close();
            System.out.println("successfully write into output.txt, please open it");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
