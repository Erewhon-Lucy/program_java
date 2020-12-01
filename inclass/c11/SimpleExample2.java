package inclass.c11;

import java.awt.*;
import javax.swing.*;

public class SimpleExample2 extends Frame {
    public static void main(String args[]) {
        JFrame f = new JFrame();
        JButton b = new JButton("Click me!!");
        f.add(b);
        f.setSize(300, 100);
        f.setTitle("This is my First Swing example");
        f.setLayout(new FlowLayout());
        f.setVisible(true);
    }
}